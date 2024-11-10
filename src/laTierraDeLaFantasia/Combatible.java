package laTierraDeLaFantasia;

public interface Combatible {
    void atacar(Combatible contrincante);
    void recibirAtaque(int daño);
    void descansar();
}
