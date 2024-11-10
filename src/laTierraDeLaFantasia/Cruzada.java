package laTierraDeLaFantasia;

public class Cruzada {
	private int cantidadGuerrerosRestantes;
	private int tiempoTotal;
	
	public int getCantidadGuerrerosRestantes() {
		return cantidadGuerrerosRestantes;
	}
	
	public int getTiempoTotal() {
		return tiempoTotal;
	}
	
	public int cruzada() {
		
	tiempoTotal = 0;
	
	Ejercito ejercitoAliado = new Ejercito(
		Mapa.obtenerInstancia().obtenerPueblo(Mapa.obtenerInstancia().getPuebloInicial()).getHabitantes(), 
		Mapa.obtenerInstancia().obtenerPueblo(Mapa.obtenerInstancia().getPuebloInicial()).getRaza());
		
	for(int[] puebloAVisitar:Mapa.obtenerInstancia().getCaminoMenorCosto())
	{		
		//tiempoTotal += 
		if(Mapa.obtenerInstancia().obtenerPueblo(puebloAVisitar[0]).getTipo()==TipoPueblo.aliado)
		{		
			ejercitoAliado.descansar();
			tiempoTotal+=1;
			
			ejercitoAliado.agregarGuerreros(Mapa.obtenerInstancia().obtenerPueblo(puebloAVisitar[0]).getHabitantes()/2, Mapa.obtenerInstancia().obtenerPueblo(puebloAVisitar[0]).getRaza());
		}
		else {
			Ejercito ejercitoEnemigo = new Ejercito(
					Mapa.obtenerInstancia().obtenerPueblo(puebloAVisitar[0]).getHabitantes(), 
					Mapa.obtenerInstancia().obtenerPueblo(puebloAVisitar[0]).getRaza());	
			
			tiempoTotal+=1;
			if(CampoDeBatalla.batalla(ejercitoAliado, ejercitoEnemigo)==0)
				return 0;
		}
	}
	cantidadGuerrerosRestantes=ejercitoAliado.obtenerCantGuerreros();
	return 1;
}
}