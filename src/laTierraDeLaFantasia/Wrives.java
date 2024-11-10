package laTierraDeLaFantasia;
public class Wrives extends Guerrero{
	int contadorAtaques = 0;
	int ataqueRecibido = 0;
	public Wrives() {
		super("Wrives",108, "magia", 14, 28, 113);
	}

	@Override
	public void atacar(Guerrero contrincante) {
		if(ataqueRecibido == 0) {
			contrincante.recibirAtaque(0);
		}
		
		if(contadorAtaques == 2) {
			contadorAtaques = 0;
			contrincante.recibirAtaque(daño*2);
		}
		else {
			contadorAtaques++;
			contrincante.recibirAtaque(daño);
		}
	}

	@Override
	public void descansar() {
		ataqueRecibido = 0;
		this.saludMaxima+=50;
		this.salud+=50;
	}

	@Override
	public void recibirAtaque(int daño) {
		ataqueRecibido++;
		this.salud -= daño*2;
	}

}
