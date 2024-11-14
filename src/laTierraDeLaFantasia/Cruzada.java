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
	Mapa mapa = Mapa.getInstancia();
	
	Ejercito ejercitoAliado = new Ejercito(
		mapa.getPueblo(mapa.getPuebloInicial()).getHabitantes(), 
		mapa.getPueblo(mapa.getPuebloInicial()).getRaza());
		
	for(int puebloAVisitar:mapa.getCaminoMenorCosto())
	{	
		if(puebloAVisitar!=mapa.getPuebloInicial()) //verifico que no sea el pueblo de origen
		{
			if(mapa.getPueblo(puebloAVisitar).getTipo()==TipoPueblo.aliado)
			{		
				ejercitoAliado.descansar();
				tiempoTotal+=1;
				ejercitoAliado.agregarGuerreros(mapa.getPueblo(puebloAVisitar).getHabitantes()/2, 
													mapa.getPueblo(puebloAVisitar).getRaza());
			}
			else {
				Ejercito ejercitoEnemigo = new Ejercito(
						mapa.getPueblo(puebloAVisitar).getHabitantes(), 
						mapa.getPueblo(puebloAVisitar).getRaza());	
				
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