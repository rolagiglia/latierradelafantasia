package laTierraDeLaFantasia;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class GuerreroTest {

    private CombatDummy enemigo;

    @BeforeEach
    public void setUp() {
        enemigo = new CombatDummy();
    }

    // Pruebas para la clase Reralopes
    @Test
    public void testReralopesAtacarFallo() {
        Guerrero reralopes = new Reralopes();
        do {
        	enemigo.descansar();
            reralopes.atacar(enemigo);        	
        } while(((Reralopes) reralopes).getUltimoAtaqueExitoso()); // Ataca hasta que falla

        assertEquals(100, enemigo.getSalud()); // Debería fallar y no hacer daño
    }

    @Test
    public void testReralopesAtacarPotenciado() {
        Guerrero reralopes = new Reralopes();
        reralopes.descansar(); // Activar ataque potenciado
        
        do {
        	reralopes.atacar(enemigo);
        }while(!((Reralopes) reralopes).getUltimoAtaqueExitoso()); // Ataca hasta que lo consigue
        
        assertEquals(46, enemigo.getSalud()); // Daño potenciado: 27 * 2
    }

    @Test
    public void testReralopesRecibirAtaque() {
        Guerrero reralopes = new Reralopes();
        reralopes.recibirAtaque(20);
        assertEquals(33, reralopes.getSalud()); // Debería reducir la salud correctamente
    }

    // Pruebas para la clase Wrives
    @Test
    public void testWrivesAtacar() {
        Guerrero wrives = new Wrives();
        wrives.recibirAtaque(10);
        wrives.atacar(enemigo);
        assertEquals(-13, enemigo.getSalud()); // Daño normal: 113
    }

    @Test
    public void testWrivesAtacarConDobleDaño() {
        Guerrero wrives = new Wrives();
        wrives.recibirAtaque(0);
        wrives.atacar(enemigo);
        assertEquals(-13, enemigo.getSalud()); // Daño normal: 100 - 113 = -13
        wrives.atacar(enemigo);
        assertEquals(-126, enemigo.getSalud()); // Daño normal: -13 - 113 = -126
        wrives.atacar(enemigo);
        assertEquals(-352, enemigo.getSalud()); // Doble daño: -126 - 226 = -352
    }

    @Test
    public void testWrivesDescansar() {
        Guerrero wrives = new Wrives();
        wrives.descansar();
        assertEquals(158, wrives.getSaludMaxima()); // Salud máxima aumentada en 50
        assertEquals(158, wrives.getSalud()); // Salud aumentada en 50
        wrives.atacar(enemigo);
        assertEquals(100, enemigo.getSalud()); // No debería hacer daño si no recibió ataque
    }

    // Pruebas para la clase Nortaichian
    @Test
    public void testNortaichianAtacarEnModoNormal() {
        Guerrero nortaichian = new Nortaichian();
        nortaichian.atacar(enemigo);
        assertEquals(82, enemigo.getSalud()); // Daño normal: 18
    }

    @Test
    public void testNortaichianRecibirAtaqueEnfurecido() {
        Guerrero nortaichian = new Nortaichian();
        nortaichian.recibirAtaque(10); // Se enfurece durante 2 turnos
        nortaichian.atacar(enemigo); // Ataque enfurecido 1
        assertEquals(64, enemigo.getSalud()); // Daño doble: 18 * 2
    }

    @Test
    public void testNortaichianDescansar() {
        Guerrero nortaichian = new Nortaichian();
        nortaichian.recibirAtaque(10); //Recibe daño
        nortaichian.descansar(); // Vida restaurada y entra en modo piedra
        assertEquals(66, nortaichian.getSalud()); // Salud restaurada

        nortaichian.atacar(enemigo); // Primer turno de piedra
        assertEquals(100, enemigo.getSalud()); // No debería hacer daño

        nortaichian.atacar(enemigo); // Segundo turno de piedra
        assertEquals(100, enemigo.getSalud()); // No debería hacer daño
    }

    @Test
    public void testNortaichianRecibirAtaqueEnModoPiedra() {
        Guerrero nortaichian = new Nortaichian();
        nortaichian.descansar(); // Entra en modo piedra

        nortaichian.recibirAtaque(20); // Daño reducido a la mitad
        assertEquals(56, nortaichian.getSalud()); // Debería recibir 10 de daño
    }

    // Pruebas para la clase Radaiteran
    @Test
    public void testRadaiteranAtacar() {
        Guerrero radaiteran = new Radaiteran();
        radaiteran.atacar(enemigo); // Primer ataque
        assertEquals(44, enemigo.getSalud()); // Daño: 56

        radaiteran.atacar(enemigo); // Segundo ataque
        assertEquals(-15, enemigo.getSalud()); // Daño: 56 + (3 * 1)
    }

    @Test
    public void testRadaiteranRecibirAtaque() {
        Guerrero radaiteran = new Radaiteran();
        radaiteran.recibirAtaque(20);
        assertEquals(16, radaiteran.getSalud()); // Salud reducida correctamente
    }    
}

