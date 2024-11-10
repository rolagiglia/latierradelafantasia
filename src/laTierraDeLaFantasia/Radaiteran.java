package laTierraDeLaFantasia;
public class Radaiteran extends Guerrero{
	int cantAtaques = 0;
	public Radaiteran() {
		super("Radaiteran",36,"shuriken", 17, 41, 56);
	}

	@Override
	public void atacar(Combatible contrincante) {
		contrincante.recibirAtaque(daño+(3*cantAtaques));
		cantAtaques++;
	}

	@Override
	public void descansar() {}

	@Override
	public void recibirAtaque(int daño) {
		this.salud -= daño;
	}
}


