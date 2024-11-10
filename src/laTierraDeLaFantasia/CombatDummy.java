package laTierraDeLaFantasia;

//Clase auxuliar para realizar pruebas
public class CombatDummy implements Combatible {
    private int salud = 100;

    @Override
    public void atacar(Combatible contrincante) {}

    @Override
    public void recibirAtaque(int daño) {
        salud -= daño;
    }

    @Override
    public void descansar() {
    	salud = 100;
    }

    public int getSalud() {
        return salud;
    }
}
