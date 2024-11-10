package laTierraDeLaFantasia;
public class CampoDeBatalla{

	public static int batalla(Ejercito aliado, Ejercito enemigo) {
		boolean turnoAliado = true;
		
		
		while(aliado.estaVivo() && enemigo.estaVivo()) {
			
			if(turnoAliado) {
				aliado.atacar(enemigo);
			}
			else {
				enemigo.atacar(aliado);
			}
		
			//cambio turno
			turnoAliado = !turnoAliado;
		}
		
		
		if(aliado.estaVivo()) {
			
			aliado.moverHerido();
			
			return 1;//ganaron los aliados
		}
		
		return 0;// ganaron los enemigos
	}
}
