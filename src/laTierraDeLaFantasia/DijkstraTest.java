package laTierraDeLaFantasia;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class DijkstraTest {

    @Test
    void testAlgoritmoDijkstraGrafoSimple() {
        Dijkstra dijkstra = new Dijkstra();
        int[][] matrizAdy = {
            {0, 10, Integer.MAX_VALUE, 30},
            {10, 0, 50, Integer.MAX_VALUE},
            {Integer.MAX_VALUE, 50, 0, 20},
            {30, Integer.MAX_VALUE, 20, 0}
        };
        int nodoInicial = 0;
        int[] costosMin = new int[matrizAdy.length];
        int[] predecesores = new int[matrizAdy.length];

        dijkstra.algoritmoDijkstra(matrizAdy, nodoInicial, costosMin, predecesores);

        int[] costosMinEsperados = {0, 10, 50, 30};
        int[] predecesoresEsperados = {0, 0, 3, 0};
        assertArrayEquals(costosMinEsperados, costosMin);
        assertArrayEquals(predecesoresEsperados, predecesores);
    }

    @Test
    void testAlgoritmoDijkstraNodoAislado() {
        Dijkstra dijkstra = new Dijkstra();
        int[][] matrizAdy = {
            {0, 10, Integer.MAX_VALUE, Integer.MAX_VALUE},
            {10, 0, Integer.MAX_VALUE, Integer.MAX_VALUE},
            {Integer.MAX_VALUE, Integer.MAX_VALUE, 0, 20},
            {Integer.MAX_VALUE, Integer.MAX_VALUE, 20, 0}
        };
        int nodoInicial = 0;
        int[] costosMin = new int[matrizAdy.length];
        int[] predecesores = new int[matrizAdy.length];

        dijkstra.algoritmoDijkstra(matrizAdy, nodoInicial, costosMin, predecesores);

        int[] costosMinEsperados = {0, 10, Integer.MAX_VALUE, Integer.MAX_VALUE};
        int[] predecesoresEsperados = {0, 0, 0, 0};
        assertArrayEquals(costosMinEsperados, costosMin);
        assertArrayEquals(predecesoresEsperados, predecesores);
    }

    @Test
    void testAlgoritmoDijkstraGrafoComplejo() {
        Dijkstra dijkstra = new Dijkstra();
        int[][] matrizAdy = {
            {0, 5, 15, Integer.MAX_VALUE, Integer.MAX_VALUE},
            {5, 0, 10, 20, Integer.MAX_VALUE},
            {15, 10, 0, 25, 35},
            {Integer.MAX_VALUE, 20, 25, 0, 5},
            {Integer.MAX_VALUE, Integer.MAX_VALUE, 35, 5, 0}
        };
        int nodoInicial = 0;
        int[] costosMin = new int[matrizAdy.length];
        int[] predecesores = new int[matrizAdy.length];

        dijkstra.algoritmoDijkstra(matrizAdy, nodoInicial, costosMin, predecesores);

        int[] costosMinEsperados = {0, 5, 15, 25, 30};
        int[] predecesoresEsperados = {0, 0, 0, 1, 3};
        assertArrayEquals(costosMinEsperados, costosMin);
        assertArrayEquals(predecesoresEsperados, predecesores);
    }

    @Test
    void testAlgoritmoDijkstraNodoInicialDesconectado() {
        Dijkstra dijkstra = new Dijkstra();
        int[][] matrizAdy = {
            {0, Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE},
            {Integer.MAX_VALUE, 0, 10, Integer.MAX_VALUE},
            {Integer.MAX_VALUE, 10, 0, 5},
            {Integer.MAX_VALUE, Integer.MAX_VALUE, 5, 0}
        };
        int nodoInicial = 0;
        int[] costosMin = new int[matrizAdy.length];
        int[] predecesores = new int[matrizAdy.length];

        dijkstra.algoritmoDijkstra(matrizAdy, nodoInicial, costosMin, predecesores);

        int[] costosMinEsperados = {0, Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE};
        int[] predecesoresEsperados = {0, 0, 0, 0};
        assertArrayEquals(costosMinEsperados, costosMin);
        assertArrayEquals(predecesoresEsperados, predecesores);
    }
}