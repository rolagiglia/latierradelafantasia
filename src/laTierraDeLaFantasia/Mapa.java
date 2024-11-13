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
    private ArrayList<Integer> caminoMenorCosto;// lista de pueblos a visitar por el camino mas corto
    private int costoTotal;
    
    private Mapa() {//privado para evitar la creacion de una nueva instancia
        this.pueblos = new HashMap<>();
        
    }
    
    // Estático para get la única instancia de Mapa
    public static Mapa getInstancia() {
        if (mapaUnico == null) {   //sino hay instancia creada 
            mapaUnico = new Mapa();  
        }
        return mapaUnico;
    }
    
    public void borrarMapa() {
    	costoTotal=0;
    	caminoMenorCosto=null;
    	pueblos.clear();
 
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


    public Pueblo getPueblo(int idPueblo) {
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
		return this.costoTotal;  //devuelve km
	}
	
	public ArrayList<Integer> getCaminoMenorCosto(){		
		if(caminoMenorCosto != null) 
			return this.caminoMenorCosto;			
		calculaCaminoMasCorto();
		return this.caminoMenorCosto;		
	}
	
	public void calculaCaminoMasCorto() {//calcula lista de pueblos a visitar por el camino mas corto
		
		int[]costosMin = new int[this.matrizAdyacencias.length];  
		int[]pred = new int[this.matrizAdyacencias.length];  
		int anterior=-1;
		Dijkstra dijkstra= new Dijkstra();
		dijkstra.algoritmoDijkstra(this.matrizAdyacencias, this.puebloInicial, costosMin, pred);
		
		this.costoTotal=costosMin[puebloFinal];
		caminoMenorCosto = new ArrayList<>();
		
		if(costosMin[puebloFinal]!=Integer.MAX_VALUE) {
			caminoMenorCosto.add(this.puebloFinal);
			anterior=pred[this.puebloFinal];
			do {
				caminoMenorCosto.add(anterior);
				anterior=pred[anterior];
			} while(anterior!=this.puebloInicial);
			Collections.reverse(caminoMenorCosto);//invierto la lista para que el camino quede en el orden correcto
		}
		else
			this.caminoMenorCosto=null; //no hay camino
		
	
	}
	
	

    
}
