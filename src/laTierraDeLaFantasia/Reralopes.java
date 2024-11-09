
public class Reralopes extends Guerrero{
	int fallos = 0;
	int ataquePotenciado = 0;
	public Reralopes(int salud, String arma, int rangoMin, int rangoMax, int daño) {
		super(53,"catapulta", 5, 46, 27);
	}

	@Override
	public void atacar(Guerrero contrincante) {
		
		if(fallos%2 == 0) {
			fallos++;
		}
		else if(ataquePotenciado > 0){
			ataquePotenciado--;
			contrincante.recibirAtaque(daño*2);
		}
		else{
			contrincante.recibirAtaque(daño);
		}
	}

	@Override
	public void descansar() {
		ataquePotenciado = 3;
	}

	@Override
	public void recibirAtaque(int daño) {
		this.salud -= daño;
		fallos = 0;
	}

}
