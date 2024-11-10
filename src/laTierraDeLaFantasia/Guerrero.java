package laTierraDeLaFantasia;
public abstract class Guerrero implements Combatible{
	
	String raza;
	int saludMaxima;
	int salud;
	String arma;
	int rangoMin;
	int rangoMax;
	int daño;
	
	public Guerrero(String raza, int saludMaxima, String arma, int rangoMin, int rangoMax, int daño) {
		this.raza = raza;
		this.saludMaxima = saludMaxima;
		this.salud = saludMaxima;
		this.arma = arma;
		this.rangoMin = rangoMin;
		this.rangoMax = rangoMax;
		this.daño = daño;
	}
	
	public String getRaza() {
		return raza;
	}	
	
	public int getSaludMaxima() {
		return saludMaxima;
	}	
	
	public int getSalud() {
		return salud;
	}
	
	public String getArma() {
		return arma;
	}
	
	public int getRangoMin() {
		return rangoMin;
	}
	
	public int getRangoMax() {
		return rangoMax;
	}
	
	public int getDaño() {
		return daño;
	}
	
	public boolean estaVivo() {
		return salud > 0;
	}
	
	public abstract void atacar(Combatible contrincante);//abstract por ser la clase base que no se instancia
	
	public abstract void descansar();
	
	public abstract void recibirAtaque(int daño);
}
