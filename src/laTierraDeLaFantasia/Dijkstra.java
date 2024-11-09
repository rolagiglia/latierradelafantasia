package laTierraDeLaFantasia;

public class Dijkstra {  //O(n^2)
	int[] costosMin;
	int[] Predecesores;
	int flag=0;
	public void algoritmoDijkstra(int[][] matrizAdy, int nodoInicial,int[]costosMin,int[]pred) {
				   			 
		boolean [] vectorS = new boolean[matrizAdy.length];         //vector nodos visitados
		int nodoMenorCosto=nodoInicial;
		int menorCosto;
		
		//C:\Users\Ivi\Desktop\FACU 2024\PROGRAAVANZADA\archivo.txt
		/*
		System.out.println("Matriz: "+ matrizAdy.length + "inicial "+ nodoInicial);
		for(int i=0;i<matrizAdy.length;i++) {
			System.out.println("");
			for(int j=0;j<matrizAdy.length;j++)
			  System.out.print(" " + matrizAdy[i][j]);
		}*/
		
		for(int i=0;i<vectorS.length;i++)       //inicializo el vector de visitados 
			vectorS[i]=false;	
		
		for(int i=0;i<costosMin.length;i++)   //inicializo el vector de costosMin con las distancias al nodoInicial
			costosMin[i]=matrizAdy[nodoInicial][i];
		
		for(int i=0;i<pred.length;i++)      //inicialializo predecesor de todos es el nodo inicial
			pred[i]=nodoInicial;
				
		vectorS[nodoInicial]=true;  
	
		for(int n=0;n<matrizAdy.length;n++)   //
		{			
			menorCosto=Integer.MAX_VALUE;
			for(int i=0;i<costosMin.length;i++) {
				if(costosMin[i]<menorCosto && vectorS[i]==false) {
					menorCosto=costosMin[i];
					nodoMenorCosto=i;	
				}	
			
			}			
			
			vectorS[nodoMenorCosto]=true;  //agregamos el nodo como visitado						
			for(int i=0;i<costosMin.length;i++)   
		    //para cada nodo que no fue visitado buscamos si hay un mejor camino pasando por el nodoMenorCosto
			{
				if(vectorS[i]==false && matrizAdy[nodoMenorCosto][i] != Integer.MAX_VALUE)
					if(costosMin[i]>(costosMin[nodoMenorCosto]+ matrizAdy[nodoMenorCosto][i])) {
					
					costosMin[i] = costosMin[nodoMenorCosto]+ matrizAdy[nodoMenorCosto][i];
					
					pred[i]=nodoMenorCosto;  //actualizamos el costo y el predecesor si encontramos un mejor camino
				}					
			}				
		}		
		
	} 
}
	
	


