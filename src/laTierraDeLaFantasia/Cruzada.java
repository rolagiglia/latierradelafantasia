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
		Mapa.getInstancia().getPueblo(Mapa.getInstancia().getPuebloInicial()).getHabitantes(), 
		Mapa.getInstancia().getPueblo(Mapa.getInstancia().getPuebloInicial()).getRaza());
		
	for(int puebloAVisitar:Mapa.getInstancia().getCaminoMenorCosto())
	{	
		if(puebloAVisitar!=Mapa.getInstancia().getPuebloInicial()) //si no es mi pueblo
		{
			if(Mapa.getInstancia().getPueblo(puebloAVisitar).getTipo()==TipoPueblo.aliado)
			{		
				ejercitoAliado.descansar();
				tiempoTotal+=1;
				ejercitoAliado.agregarGuerreros(Mapa.getInstancia().getPueblo(puebloAVisitar).getHabitantes()/2, Mapa.getInstancia().getPueblo(puebloAVisitar).getRaza());
			}
			else {
				Ejercito ejercitoEnemigo = new Ejercito(
						Mapa.getInstancia().getPueblo(puebloAVisitar).getHabitantes(), 
						Mapa.getInstancia().getPueblo(puebloAVisitar).getRaza());	
				
				tiempoTotal+=1;
				if(CampoDeBatalla.batalla(ejercitoAliado, ejercitoEnemigo)==0)
					return 0;
			}
		}
		
	}
	cantidadGuerrerosRestantes=ejercitoAliado.getCantGuerreros();
	return 1;
}
}