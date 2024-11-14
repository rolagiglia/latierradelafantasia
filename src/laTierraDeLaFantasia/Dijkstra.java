package laTierraDeLaFantasia;

import java.util.Comparator;
import java.util.PriorityQueue;

public class Dijkstra { // O(n^2)

	public void algoritmoDijkstra(int[][] matrizAdy, int nodoInicial, int[] costosMin, int[] pred) {
		// Implementacion con cola de prioridad
		PriorityQueue<int[]> colaPrioridad = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));
		int n = matrizAdy.length, nuevoCosto,pesoArista;
		boolean[] visitados = new boolean[n];
		int[] actual = new int[2]; // actual[0]->nodo  actual[1]->costo)
				
		for (int i = 0; i < costosMin.length; i++) {
			costosMin[i] = Integer.MAX_VALUE;
			pred[i] = -1;
		}

		costosMin[nodoInicial] = 0;

		colaPrioridad.add(new int[] { nodoInicial, 0 });

		while (!colaPrioridad.isEmpty()) {
			actual = colaPrioridad.poll();

			if (visitados[actual[0]])//evito procesar nuevamente un nodo que ya fue visitado
				continue;            
			visitados[actual[0]] = true;

			// Actualizar vecinos del nodo actual
			for (int vecino = 0; vecino < n; vecino++) {
				pesoArista = matrizAdy[actual[0]][vecino];
				if (pesoArista != Integer.MAX_VALUE && !visitados[vecino]) {// el nodo no es inalcanzableno y no fue visitado
					nuevoCosto = actual[1] + pesoArista;
					if (nuevoCosto < costosMin[vecino]) {
						costosMin[vecino] = nuevoCosto;
						pred[vecino] = actual[0];
						colaPrioridad.add(new int[] { vecino, nuevoCosto });
					}
				}
			}
		}
	}
}
