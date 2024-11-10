package laTierraDeLaFantasia;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class MapaTest {

    private Mapa mapa;

    @BeforeEach
    public void setUp() {
        mapa = Mapa.obtenerInstancia();
        mapa.setCantidadPueblos(4);
        mapa.setPuebloInicial(1);
        mapa.setPuebloFinal(4);

        mapa.agregarPueblo(new Pueblo(1, 100, Raza.wrives, TipoPueblo.propio));
        mapa.agregarPueblo(new Pueblo(2, 30, Raza.reralopes, TipoPueblo.aliado));
        mapa.agregarPueblo(new Pueblo(3, 40, Raza.nortaichian, TipoPueblo.enemigo));
        mapa.agregarPueblo(new Pueblo(4, 60, Raza.nortaichian, TipoPueblo.enemigo));
    }

    @Test
    public void testCantidadPueblos() {
        assertEquals(4, mapa.getCantidadPueblos(), "La cantidad de pueblos no es la esperada.");
    }

    @Test
    public void testPuebloInicialYFinal() {
        assertEquals(1, mapa.getPuebloInicial(), "El pueblo inicial no es el esperado.");
        assertEquals(4, mapa.getPuebloFinal(), "El pueblo final no es el esperado.");
    }

    @Test
    public void testAgregarPueblo() {
        Pueblo pueblo1 = mapa.obtenerPueblo(1);
        assertEquals(1, pueblo1.getId(), "El ID del pueblo 1 no es el esperado.");
        assertEquals(100, pueblo1.getHabitantes(), "El número de habitantes del pueblo 1 no es el esperado.");
        assertEquals(Raza.wrives, pueblo1.getRaza(), "La raza del pueblo 1 no es la esperada.");
        assertEquals(TipoPueblo.propio, pueblo1.getTipo(), "El tipo del pueblo 1 no es el esperado.");

        Pueblo pueblo2 = mapa.obtenerPueblo(2);
        assertEquals(2, pueblo2.getId(), "El ID del pueblo 2 no es el esperado.");
        assertEquals(30, pueblo2.getHabitantes(), "El número de habitantes del pueblo 2 no es el esperado.");
        assertEquals(Raza.reralopes, pueblo2.getRaza(), "La raza del pueblo 2 no es la esperada.");
        assertEquals(TipoPueblo.aliado, pueblo2.getTipo(), "El tipo del pueblo 2 no es el esperado.");
    }

    @Test
    public void testAgregarCamino() {
        mapa.agregarCamino(1, 2, 10);
        mapa.agregarCamino(2, 3, 5);
        mapa.agregarCamino(3, 4, 7);

        int[][] matriz = mapa.getMatrizAdyacencias();
        assertEquals(10, matriz[1][2], "La distancia entre los pueblos 1 y 2 no es la esperada.");
        assertEquals(5, matriz[2][3], "La distancia entre los pueblos 2 y 3 no es la esperada.");
        assertEquals(7, matriz[3][4], "La distancia entre los pueblos 3 y 4 no es la esperada.");
    }

    @Test
    public void testCalcularCaminoMasCorto() {
        // Agregar varios caminos entre los pueblos
        mapa.agregarCamino(1, 2, 10);
        mapa.agregarCamino(2, 3, 5);
        mapa.agregarCamino(3, 4, 7);
        mapa.agregarCamino(1, 3, 15); // Camino más largo directo de 1 a 3
        mapa.agregarCamino(2, 4, 20); // Camino más largo directo de 2 a 4
        mapa.agregarCamino(1, 4, 50); // Camino directo muy costoso de 1 a 4

        // Calcular el camino más corto
        var caminoMasCorto = mapa.calculaCaminoMasCorto();
        assertNotNull(caminoMasCorto, "El camino más corto no debería ser nulo.");
        
        // Verificar que el camino más corto sigue el orden correcto desde el pueblo inicial (1) hasta el pueblo final (4)
        assertEquals(3, caminoMasCorto.get(0)[0], "El primer pueblo en el camino más corto no es el esperado.");
        assertEquals(4, caminoMasCorto.get(1)[0], "El segundo pueblo en el camino más corto no es el esperado.");
    }
}

