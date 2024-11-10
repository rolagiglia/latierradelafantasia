package laTierraDeLaFantasia;
public class CampoDeBatalla{

	public static int batalla(Ejercito aliado, Ejercito enemigo) {
		int turno = 1;// 1 para aliados , 2 para enemigos
		
		
		while(aliado.estaVivo() && enemigo.estaVivo()) {
			
			if(turno == 1) {
				aliado.atacar(enemigo);
			}
			else {
				enemigo.atacar(aliado);
			}
		
			//cambio turno
			turno = (turno==1) ? 2 : 1;
		}
		
		
		if(!enemigo.estaVivo()) {
			
			aliado.moverHerido();
			
			return 1;//gano aliados
		}
		
		return 0;// gano enemigos
	}
}
