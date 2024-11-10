package laTierraDeLaFantasia;
import java.util.ArrayList;
import java.util.List;

public class Ejercito implements Combatible {

	private List<Combatible> unidades;

	public Ejercito(int cantidad, Raza raza) {
		this.unidades = new ArrayList<>();	
		
		for(int i=0; i<cantidad;i++)
			agregarGuerreroPorRaza(raza);
	}
	
	public void agregarGuerreros(int cantidad, Raza raza) {
		for(int i=0; i<cantidad; i++)
			agregarGuerreroPorRaza(raza);
	}
	
	private void agregarGuerreroPorRaza(Raza raza) {
        switch (raza) {
            case wrives:
                this.unidades.add(0, new Wrives());
                break;
            case reralopes:
                this.unidades.add(0, new Reralopes());
                break;
            case radaiteran:
                this.unidades.add(0, new Radaiteran());
                break;
            case nortaichian:
                this.unidades.add(0, new Nortaichian());
                break;
            default:
                System.out.println("Raza desconocida: " + raza);
        }
    }
	
    

	public void atacar(Combatible contrincante) {
	    if (!unidades.isEmpty()) {
	        unidades.get(0).atacar(contrincante);
	        sacarGuerreroMuerto();
	    }
	}

	public void descansar() {
	    for (Combatible unidad : unidades) {
	        unidad.descansar();
	    }
	}

	public void sacarGuerreroMuerto() {
	    if (!unidades.isEmpty()) {
	        Combatible primeraUnidad = unidades.get(0);

	        //Si el primero es un guerrero lo saca
	        if (primeraUnidad instanceof Guerrero && !((Guerrero) primeraUnidad).estaVivo()) {
	            unidades.remove(0);
	        }
	        //Si el primero es un ejercito vuelve a llamar al metodo recursivamente
	        else if (primeraUnidad instanceof Ejercito) {
	            ((Ejercito) primeraUnidad).sacarGuerreroMuerto();
	            //si el ejercito quedo vacio lo saca
	            if(!((Ejercito) primeraUnidad).estaVivo()) {
		        	unidades.remove(0);         	
	            }
	        }
	    }
	}

	public int obtenerCantGuerreros() {
	    int total = 0;
	    for (Combatible unidad : unidades) {
	        if (unidad instanceof Ejercito) {
	            total += ((Ejercito) unidad).obtenerCantGuerreros();
	        } else {
	            total += 1;
	        }
	    }
	    return total;
	}

	public void recibirAtaque(int daño) {
	    if (!unidades.isEmpty()) {
	        unidades.get(0).recibirAtaque(daño);
	    }
	}

	public boolean estaVivo() {
	    return !unidades.isEmpty();
	}

	public void moverHerido() {
	    if (!unidades.isEmpty()) {
	        Combatible primeraUnidad = unidades.get(0);

	        // Si la primera unidad es un Guerrero herido
	        if (primeraUnidad instanceof Guerrero && ((Guerrero) primeraUnidad).getSalud() < ((Guerrero) primeraUnidad).getSaludMaxima()) {
	            Combatible unidad = unidades.remove(0);
	            unidades.add(unidad);
	        }
	        // Si la primera unidad es un Ejercito aplica recursividad
	        else if (primeraUnidad instanceof Ejercito) {
	            ((Ejercito) primeraUnidad).moverHerido();
	        }
	    }
	}

    
}


