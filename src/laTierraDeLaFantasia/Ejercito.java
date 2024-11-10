package laTierraDeLaFantasia;
import java.util.ArrayList;
import java.util.List;

public class Ejercito {

	private List<Guerrero> unidades;

	public Ejercito(int cantidad, Raza raza) {
		this.unidades = new ArrayList<>();	
		
		for(int i=0; i<=cantidad;i++)
			agregarGuerreroPorRaza(raza);
	}
	
	public void agregarGuerreroPorRaza(Raza raza) {
        switch (raza) {
            case wrives:
                this.unidades.add(new Wrives());
                break;
            case reralopes:
                this.unidades.add(new Reralopes());
                break;
            case radaiteran:
                this.unidades.add(new Radaiteran());
                break;
            case nortaichian:
                this.unidades.add(new Nortaichian());
                break;
            default:
                System.out.println("Raza desconocida: " + raza);
        }
    }
	
    

	public void atacar(Ejercito contrincante) {
		if(unidades.isEmpty() || contrincante.unidades.isEmpty()) {
			Guerrero atacante = unidades.get(0);
			Guerrero defensor = contrincante.unidades.get(0);
			
			atacante.atacar(defensor);
			
			if(!defensor.estaVivo()) {
				contrincante.sacarGuerreroMuerto();
			}
		}
	}

	public void descansar() {
		for(Guerrero unidad: unidades) {
				unidad.descansar();
		}			
	}

	public void sacarGuerreroMuerto() {
		if(!unidades.get(0).estaVivo()) {
			unidades.remove(0);
		}
	}
	
	public int obtenerCantGuerreros() {
		return unidades.size();
	}
	
	public void recibirAtaque(int daño) {
			if(unidades.get(0).estaVivo()) {
				unidades.get(0).recibirAtaque(daño);
		}		
	}
	
	 public boolean estaVivo() {
	        return !unidades.isEmpty();
	    }
		
	public void moverHerido() {
		
		if(!unidades.get(0).estaVivo()) {//en compejidad diria que es O(1) porque toma directamente el primer elemento 
			Guerrero unidad = unidades.remove(0);//y despues lo cambia
			unidades.add(unidad);
		}
	}
    
}


