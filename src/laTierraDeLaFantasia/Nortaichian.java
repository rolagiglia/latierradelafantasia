package laTierraDeLaFantasia;
public class Nortaichian extends Guerrero{

    int enfurecido = 0;
	int turnosPiedra=0;
	int saludMax = 66;
	public Nortaichian(int salud, String arma, int rangoMin, int rangoMax, int daño) {
		super(66, "arco", 16, 22, 18);
	}

	@Override
	public void atacar(Guerrero contrincante) {
		if(turnosPiedra != 0) {
			turnosPiedra--;
			return;
		}
			
		if(enfurecido > 0) {
			enfurecido--;
			contrincante.recibirAtaque(daño*2);
		}
		else {
			contrincante.recibirAtaque(daño);
		}
		
		this.salud *=0.04;
		if(this.salud > this.saludMax) {
			this.salud = this.saludMax;
		}
	}

	@Override
	public void descansar() {
		this.salud = saludMax;
		turnosPiedra = 2;
		enfurecido = 0;
	}

	@Override
	public void recibirAtaque(int daño) {
	
		this.salud -= daño;
		enfurecido = 2;
	}


}
