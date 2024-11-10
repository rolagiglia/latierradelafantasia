package laTierraDeLaFantasia;
public abstract class Guerrero{
	
	String nombre;
	int salud;
	String arma;
	int rangoMin;
	int rangoMax;
	int daño;
	
	public Guerrero(String nombre,int salud,String arma,int rangoMin,int rangoMax, int daño) {
		this.nombre = nombre;
		this.salud = salud;
		this.rangoMin = rangoMin;
		this.rangoMax = rangoMax;
		this.daño = daño;
		this.arma = arma;
	}
	
	public abstract void atacar(Guerrero contrincante);//abstract por ser la clase base que no se instancia
	
	public abstract void descansar();
	
	public abstract void recibirAtaque(int daño);
	
	public int getSalud() {
		return salud;
	}
	
	public boolean estaVivo() {
		return salud > 0;
	}

}
