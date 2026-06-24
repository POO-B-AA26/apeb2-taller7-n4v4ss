/**
 * Problema_4: Sistema de nómina para trabajadores.
 * Implementación de herencia para gestionar diferentes tipos de trabajadores
 * y el cálculo de sus sueldos mensuales.
 * @author Jhandry Navarrete
 * @version 1.0
 */

public class Problema_4_EjecutorTrabajador {
    public static void main(String[] args) {
        // Instancias de prueba
        Jefe jefe = new Jefe("Ana", "Perez", "Calle Falsa 123", "12345678A", 3000.0);
        
        FijoMensual t1 = new FijoMensual("Luis", "Garcia", "Av. Siempre Viva 1", "87654321B", 1200.0);
        t1.setJefe(jefe);
        
        PorHoras t2 = new PorHoras("Maria", "Lopez", "Plaza Central 5", "11223344C", 10.0, 15.0);
        t2.setHoras(45.0); // 40 normales + 5 extras
        t2.setJefe(jefe);

        Comisionista t3 = new Comisionista("Carlos", "Ruiz", "Calle Real 10", "55667788D", 0.10);
        t3.setVentas(5000.0);
        t3.setJefe(jefe);

        // Imprimir nóminas
        System.out.println("Nómina de " + t1.getNombre() + ": $" + t1.calcularSueldo());
        System.out.println("Nómina de " + t2.getNombre() + ": $" + t2.calcularSueldo());
        System.out.println("Nómina de " + t3.getNombre() + ": $" + t3.calcularSueldo());
    }
}

abstract class Trabajador {
    protected String nombre, apellidos, direccion, dni;
    protected Jefe jefe;

    public Trabajador(String nombre, String apellidos, String direccion, String dni) {
        this.nombre = nombre; this.apellidos = apellidos;
        this.direccion = direccion; this.dni = dni;
    }
    public void setJefe(Jefe j) { this.jefe = j; }
    public String getNombre() { return nombre; }
    public abstract double calcularSueldo();
}

class Jefe extends Trabajador {
    private double sueldoFijo;
    public Jefe(String n, String a, String d, String dn, double s) { super(n, a, d, dn); this.sueldoFijo = s; }
    @Override public double calcularSueldo() { return sueldoFijo; }
}

class FijoMensual extends Trabajador {
    private double sueldo;
    public FijoMensual(String n, String a, String d, String dn, double s) { super(n, a, d, dn); this.sueldo = s; }
    @Override public double calcularSueldo() { return sueldo; }
}

class Comisionista extends Trabajador {
    private double porcentajeComision, ventasRealizadas;
    public Comisionista(String n, String a, String d, String dn, double p) { super(n, a, d, dn); this.porcentajeComision = p; }
    public void setVentas(double v) { this.ventasRealizadas = v; }
    @Override public double calcularSueldo() { return ventasRealizadas * porcentajeComision; }
}

class PorHoras extends Trabajador {
    private double precioHora, precioExtra, horas;
    public PorHoras(String n, String a, String d, String dn, double ph, double pe) { 
        super(n, a, d, dn); this.precioHora = ph; this.precioExtra = pe; 
    }
    public void setHoras(double h) { this.horas = h; }
    @Override public double calcularSueldo() {
        if (horas <= 40) return horas * precioHora;
        return (40 * precioHora) + ((horas - 40) * precioExtra);
    }
}

/**
 * run:
 * Nómina de Luis: $1200.0
 * Nómina de Maria: $475.0
 * Nómina de Carlos: $500.0
 */