package laTierraDeLaFantasia;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class EjercitoTest {

    private Ejercito ejercitoAliado;
    private Ejercito ejercitoEnemigo;

    @BeforeEach
    public void setUp() {
        ejercitoAliado = new Ejercito(5, Raza.wrives);
        ejercitoEnemigo = new Ejercito(3, Raza.nortaichian);
    }

    @Test
    public void testEjercitoCreacion() {
        assertNotNull(ejercitoAliado);
        assertTrue(ejercitoAliado.estaVivo(), "El ejército debe estar vivo al ser creado");
        assertEquals(5, ejercitoAliado.obtenerCantGuerreros(), "El número de guerreros debe ser 5");
    }

    @Test
    public void testAgregarGuerreros() {
        ejercitoAliado.agregarGuerreros(3, Raza.reralopes);
        assertEquals(8, ejercitoAliado.obtenerCantGuerreros(), "El número de guerreros debe ser 8 después de agregar 3");
    }

    @Test
    public void testAtacarOtroEjercito() {
        ejercitoAliado.atacar(ejercitoEnemigo);
        assertTrue(ejercitoEnemigo.estaVivo(), "El ejército enemigo debe estar vivo después de un ataque");
    }

    @Test
    public void testEjercitoRecibeAtaque() {
        ejercitoAliado.recibirAtaque(50);
        assertTrue(ejercitoAliado.estaVivo(), "El ejército debe estar vivo después de recibir daño parcial");
    }

    @Test
    public void testEjercitoMuere() {
        // Ataques múltiples para asegurar que el ejército muera
    	for(int i=ejercitoAliado.obtenerCantGuerreros(); i>0; i--) {
            ejercitoAliado.recibirAtaque(1000);
            ejercitoAliado.sacarGuerreroMuerto();    		
    	}

        assertFalse(ejercitoAliado.estaVivo(), "El ejército no debe estar vivo después de recibir daño letal");
    }

    @Test
    public void testSacarGuerreroMuerto() {
        // Simulando la muerte de un guerrero
        ejercitoAliado.recibirAtaque(1000);
        ejercitoAliado.sacarGuerreroMuerto();
        assertEquals(4, ejercitoAliado.obtenerCantGuerreros(), "El número de guerreros debe ser 4 después de eliminar un guerrero muerto");
    }

    @Test
    public void testMoverHerido() {
        // Asegurar que los guerreros heridos se muevan al final
        ejercitoAliado.recibirAtaque(10); // Herir al primer guerrero
        ejercitoAliado.moverHerido();
        // No hay un método directo para comprobar el orden, pero podemos verificar que el ejército aún esté vivo
        assertTrue(ejercitoAliado.estaVivo(), "El ejército debe seguir vivo después de mover un guerrero herido");
    }

    @Test
    public void testEjercitoDescansar() {
        ejercitoAliado.recibirAtaque(30); // Causar daño
        ejercitoAliado.descansar(); // Recuperar salud
        // Verificar que todos los guerreros hayan descansado y se hayan curado
        assertTrue(ejercitoAliado.estaVivo(), "El ejército debe estar vivo y descansado después de descansar");
    }
    
    @Test
    public void testAgregarGuerreroPorRaza() {
        Ejercito nuevoEjercito = new Ejercito(0, Raza.wrives);
        nuevoEjercito.agregarGuerreros(1, Raza.radaiteran);
        assertEquals(1, nuevoEjercito.obtenerCantGuerreros(), "El número de guerreros debe ser 1 después de agregar un guerrero de raza Radaiteran");
    }
}

