/**
 * Problema_5: Gestión de venta de entradas al teatro.
 * Implementación de herencia para distintos tipos de tarifas (Normal, Reducida, Abonado).
 * @author Jhandry Navarrete
 * @version 1.0
 */

public class Problema_5_EjecutorEntrada {
    public static void main(String[] args) {
        Zona principal = new Zona("Principal", 200, 25.0, 17.5);
        
        // Simulación: Venta de tipos de entrada
        Entrada e1 = new EntradaNormal(1, "Juan Perez", principal);
        Entrada e2 = new EntradaReducida(2, "Maria Lopez", principal);
        
        System.out.println("Entrada 1: " + e1.getDatos() + " | Precio: $" + e1.getPrecio());
        System.out.println("Entrada 2: " + e2.getDatos() + " | Precio: $" + e2.getPrecio());
    }
}

class Zona {
    private String nombre;
    private int numLocalidades, vendidas;
    private double pNormal, pAbonado;

    public Zona(String n, int cap, double pn, double pa) {
        this.nombre = n; this.numLocalidades = cap; this.pNormal = pn; this.pAbonado = pa;
    }
    public double getPrecioNormal() { return pNormal; }
    public double getPrecioAbonado() { return pAbonado; }
    public String getNombre() { return nombre; }
}

abstract class Entrada {
    protected int id;
    protected String nombre;
    protected Zona zona;

    public Entrada(int id, String nombre, Zona zona) {
        this.id = id; this.nombre = nombre; this.zona = zona;
    }
    public abstract double getPrecio();
    public String getDatos() { return "ID: " + id + ", Comprador: " + nombre + ", Zona: " + zona.getNombre(); }
}

class EntradaNormal extends Entrada {
    public EntradaNormal(int id, String n, Zona z) { super(id, n, z); }
    @Override public double getPrecio() { return zona.getPrecioNormal(); }
}

class EntradaReducida extends Entrada {
    public EntradaReducida(int id, String n, Zona z) { super(id, n, z); }
    @Override public double getPrecio() { return zona.getPrecioNormal() * 0.85; }
}

class EntradaAbonado extends Entrada {
    public EntradaAbonado(int id, String n, Zona z) { super(id, n, z); }
    @Override public double getPrecio() { return zona.getPrecioAbonado(); }
}

/**
 * run:
 * Entrada 1: ID: 1, Comprador: Juan Perez, Zona: Principal | Precio: $25.0
 * Entrada 2: ID: 2, Comprador: Maria Lopez, Zona: Principal | Precio: $21.25
 */