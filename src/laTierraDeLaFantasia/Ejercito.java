import java.util.ArrayList;
import java.util.List;

public class Ejercito {

	private List<Guerrero> unidades = new ArrayList<>();

    public void agregarGuerrero(Guerrero guerrero) {
    	unidades.add(guerrero);
    }

	public void atacar(Guerrero contrincante) {
		if(unidades.get(0).estaVivo()) {
			unidades.get(0).atacar(contrincante);;
			return;	
		}	
	}

	public void descansar() {
		for(Guerrero unidad: unidades) {
			if(unidad.estaVivo()) {
				unidad.descansar();;
			}
			else{
				return;
			}
		}
			
	}

	public void sacarGuerreroDesmayado() {
		if(!unidades.get(0).estaVivo()) {
			unidades.remove(0);
		}

	}
	
	public void recibirAtaque(int daño) {
			if(unidades.get(0).estaVivo()) {
				unidades.get(0).recibirAtaque(daño);
				return;	
		}		
	}
	
	//habria que crear otra para ponerla a lo ultimo de los sobrevivientes
	
	public void moverHerido() {
		
		if(!unidades.get(0).estaVivo()) {//en compejidad diria que es O(1) porque toma directamente el primer elemento 
			Guerrero unidad = unidades.remove(0);//y despues lo cambia
			unidades.add(unidad);
		}
	}
    
    
}


