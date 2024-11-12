package laTierraDeLaFantasia;
public class Reralopes extends Guerrero{
	private int fallos = 0;
	private boolean ultimoAtaqueExitoso = false;
	private int ataquePotenciado = 0;
	public Reralopes() {
		super(Raza.reralopes,53,"catapulta", 5, 46, 27);
	}
	
	public boolean getUltimoAtaqueExitoso() {
		return this.ultimoAtaqueExitoso;
	}
	
	@Override
	public void atacar(Combatible contrincante) {
	    if (Math.random() < 0.5) { // 50% de probabilidad de errar
	        ultimoAtaqueExitoso = false;
	        setFallos(getFallos() + 1);
	        contrincante.recibirAtaque(0); // No hace daño
	    } else if (ataquePotenciado > 0) {
	        ataquePotenciado--;
	        contrincante.recibirAtaque(daño * 2); // Daño potenciado
	        ultimoAtaqueExitoso = true;
	    } else {
	        contrincante.recibirAtaque(daño); // Daño normal
	        ultimoAtaqueExitoso = true;
	    }
	}

	@Override
	public void descansar() {
		ataquePotenciado = 3;
	}

	@Override
	public void recibirAtaque(int daño) {
		this.salud -= daño;
		setFallos(0);
	}

	public int getFallos() {
		return fallos;
	}

	public void setFallos(int fallos) {
		this.fallos = fallos;
	}

}
