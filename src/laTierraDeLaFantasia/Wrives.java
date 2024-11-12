package laTierraDeLaFantasia;
public class Wrives extends Guerrero{
	int contadorAtaques = 0;
	boolean ataqueRecibido = false;
	public Wrives() {
		super(Raza.wrives,108, "magia", 14, 28, 113);
	}

	@Override
	public void atacar(Combatible contrincante) {
		if(ataqueRecibido) {
			if(contadorAtaques == 2) {
				contadorAtaques = 0;
				contrincante.recibirAtaque(daño*2);
			}
			else {
				contadorAtaques++;
				contrincante.recibirAtaque(daño);
			}
		}
	}

	@Override
	public void descansar() {
		ataqueRecibido = false;
		this.saludMaxima+=50;
		this.salud+=50;
	}

	@Override
	public void recibirAtaque(int daño) {
		ataqueRecibido = true;
		this.salud -= daño*2;
	}

}
