
public class Radaiteran extends Guerrero{
	int cantAtaques = 0;
	public Radaiteran(int salud, String arma, int rangoMin, int rangoMax, int daño) {
		super(36,"shuriken", 17, 41, 56);
	}

	@Override
	public void atacar(Guerrero contrincante) {
		contrincante.recibirAtaque(daño+(3*cantAtaques));
		cantAtaques++;
	}

	@Override
	public void descansar() {
		// TODO Auto-generated method stub
	}

	@Override
	public void recibirAtaque(int daño) {
		this.salud -= daño;
	}

	
	
}


