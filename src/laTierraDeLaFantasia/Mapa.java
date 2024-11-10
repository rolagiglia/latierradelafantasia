package laTierraDeLaFantasia;
import java.util.*;
//la clase Mapa implementa el patron Singleton

public class Mapa {
	private static Mapa mapaUnico; // Instancia única de la clase Mapa
    private int cantidadPueblos;
    private int puebloInicial;
    private int puebloFinal;
    private Map<Integer,Pueblo> pueblos; // Mapa de nodos Pueblo
    private int[][] matrizAdyacencias; // matriz de adyacencias
    private ArrayList<int[]> caminoMenorCosto;// lista de pueblos a visitar por el camino mas corto
    
    
    private Mapa() {//privado para evitar la creacion de una nueva instancia
        this.pueblos = new HashMap<>();
        
    }
    
    // Estático para obtener la única instancia de Mapa
    public static Mapa obtenerInstancia() {
        if (mapaUnico == null) {   //sino hay instancia creada 
            mapaUnico = new Mapa();  
        }
        return mapaUnico;
    }

    public void setCantidadPueblos(int cantidadPueblos) {
        this.cantidadPueblos = cantidadPueblos;
        this.matrizAdyacencias = new int[cantidadPueblos+1][cantidadPueblos+1];
        for(int i=0;i<cantidadPueblos+1;i++)
        	for(int j=0;j<cantidadPueblos+1;j++)
        		matrizAdyacencias[i][j]=Integer.MAX_VALUE;
    }

    public void setPuebloInicial(int puebloInicial) {
        this.puebloInicial = puebloInicial;
    }

    public void setPuebloFinal(int puebloFinal) {
        this.puebloFinal = puebloFinal;
    }

    public void agregarPueblo(Pueblo pueblo) {    	
    	pueblos.put(pueblo.getId(), pueblo);
    	matrizAdyacencias[pueblo.getId()][pueblo.getId()]=0;
    }

    public void agregarCamino(int origen, int destino, int distancia) {
        if (pueblos.containsKey(origen)&& pueblos.containsKey(destino)) 
        	matrizAdyacencias[origen][destino]=distancia;    
    }

    /*
    public Map<> obtenerCaminos(int idPueblo) {//////////////////
        for(int i=0;i<cantidadPueblos;i++)
        	
    	
    }*/

    public Pueblo obtenerPueblo(int idPueblo) {
        return pueblos.get(idPueblo);
    }
    
    public int getPuebloInicial() {
        return puebloInicial;
    }

    public int getPuebloFinal() {
        return puebloFinal;
    }
	public int getCantidadPueblos() {
		// TODO Auto-generated method stub
		return this.cantidadPueblos;
	}
	
	public int[][] getMatrizAdyacencias() {
		// TODO Auto-generated method stub
		return this.matrizAdyacencias;
	}	
	
	public int getCostoMinimoTotal() {
		int costoMinimoTotal=0;
		if(caminoMenorCosto!=null)
			for(int[] n:Mapa.obtenerInstancia().getCaminoMenorCosto())
				costoMinimoTotal+=n[1];
		return costoMinimoTotal;
	}
	
	public ArrayList<int[]> getCaminoMenorCosto(){		
		if(caminoMenorCosto != null) 
			return this.caminoMenorCosto;			
		this.caminoMenorCosto = calculaCaminoMasCorto();
		return this.caminoMenorCosto;		
	}
	
	public ArrayList<int[]> calculaCaminoMasCorto() {//devuelve lista de pueblos a visitar por el camino mas corto
		
		int[]costosMin = new int[this.matrizAdyacencias.length];  
		int[]pred = new int[this.matrizAdyacencias.length];  
		int anterior=-1;
		Dijkstra dijkstra= new Dijkstra();
		dijkstra.algoritmoDijkstra(this.matrizAdyacencias, this.puebloInicial, costosMin, pred);
		
		caminoMenorCosto = new ArrayList<>();
		
		if(costosMin[puebloFinal]!=Integer.MAX_VALUE) {
			caminoMenorCosto.add(new int[]{this.puebloFinal,costosMin[this.puebloFinal]});
			anterior=pred[this.puebloFinal];
			do {
				caminoMenorCosto.add(new int[]{anterior,costosMin[anterior]});
				anterior=pred[anterior];
			} while(anterior!=this.puebloInicial);
			Collections.reverse(caminoMenorCosto);//invierto la lista para que el camino quede en el orden correcto
			return caminoMenorCosto;
		}
		return null; //no hay camino
		
	
	}
	
	

    
}
