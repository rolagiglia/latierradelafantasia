package laTierraDeLaFantasia;
public class Nortaichian extends Guerrero{

    int enfurecido = 0;
	int turnosPiedra=0;
	public Nortaichian() {
		super("Nortaichian",66, "arco", 16, 22, 18);
	}

	@Override
	public void atacar(Combatible contrincante) {
		if(turnosPiedra != 0) {
			turnosPiedra--;
			contrincante.recibirAtaque(0);
		}
			
		if(enfurecido > 0) {
			enfurecido--;
			contrincante.recibirAtaque(daño*2);
		}
		else {
			contrincante.recibirAtaque(daño);
		}
		
		this.salud *=0.04;
		if(this.salud > this.saludMaxima) {
			this.salud = this.saludMaxima;
		}
	}

	@Override
	public void descansar() {
		this.salud = saludMaxima;
		turnosPiedra = 2;
		enfurecido = 0;
	}

	@Override
	public void recibirAtaque(int daño) {
		this.salud -= daño;
		enfurecido = 2;
	}
}
