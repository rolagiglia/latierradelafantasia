package laTierraDeLaFantasia;
public class Wrives extends Guerrero{
	int contadorAtaques = 0;
	int ataqueRecivido = 0;
	int saludMax = 108;
	public Wrives() {
		super("Wrives",108, "magia", 14, 28, 113);
	}

	@Override
	public void atacar(Guerrero contrincante) {
		if(ataqueRecivido == 0) {
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
		ataqueRecivido = 0;
		this.saludMax+=50;
		this.salud+=50;
	
	}

	@Override
	public void recibirAtaque(int daño) {
		ataqueRecivido++;
		this.salud -= daño*2;
	}

}
