package laTierraDeLaFantasia;

public class Pueblo {
    private int id;
    private int habitantes;
    private Raza raza;
    
    private TipoPueblo tipo; // enum: propio, aliado, enemigo

    public Pueblo(int id, int habitantes, Raza raza, TipoPueblo tipo) {
        this.id = id;
        this.habitantes = habitantes;
        this.raza = raza;        
        this.tipo = tipo;
    }

    public int getId() {
        return id;
    }

    
    public int getHabitantes() {
        return habitantes;
    }

    public Raza getRaza() {
        return raza;
    }

    public TipoPueblo getTipo() {
        return tipo;
    }
    
    public String toString() {
    	String concat =new String();
    	return concat.concat(id + " " + habitantes +" "+raza + " "+tipo);
    }
}
