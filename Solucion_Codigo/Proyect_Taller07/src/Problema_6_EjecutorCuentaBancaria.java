/**
 * Problema_6: Sistema de gestión bancaria.
 * Implementación de herencia para cuentas bancarias con reglas de negocio específicas
 * para Cheques, Ahorros y Platino.
 * @author Jhandry Navarrete
 * @version 1.0
 */

public class Problema_6_EjecutorCuentaBancaria {
    public static void main(String[] args) {
        // Pruebas con diferentes tipos de cuenta
        Cuenta ch = new Cheques("101", "Juan Perez");
        ch.depositar(500);
        ch.retirar(600); // Permite sobregiro

        Cuenta ah = new Ahorros("202", "Maria Lopez", 0.05); // 5% interés
        ah.depositar(1000);
        ((Ahorros) ah).aplicarInteres();

        Cuenta pl = new Platino("303", "Carlos Ruiz");
        pl.depositar(2000);
        ((Platino) pl).aplicarInteres();

        System.out.println("Balance " + ch.nombre + ": $" + ch.getBalance());
        System.out.println("Balance " + ah.nombre + ": $" + ah.getBalance());
        System.out.println("Balance " + pl.nombre + ": $" + pl.getBalance());
    }
}

abstract class Cuenta {
    protected String numeroCuenta, nombre;
    protected double balance;

    public Cuenta(String num, String nom) { this.numeroCuenta = num; this.nombre = nom; this.balance = 0; }
    public void depositar(double cant) { balance += cant; }
    public abstract void retirar(double cant);
    public double getBalance() { return balance; }
}

class Cheques extends Cuenta {
    public Cheques(String num, String nom) { super(num, nom); }
    @Override public void retirar(double cant) { balance -= cant; }
}

class Ahorros extends Cuenta {
    private double tasa;
    public Ahorros(String num, String nom, double tasa) { super(num, nom); this.tasa = tasa; }
    @Override public void retirar(double cant) { 
        if (balance >= cant) balance -= cant; 
        else System.out.println("Fondos insuficientes"); 
    }
    public void aplicarInteres() { balance += (balance * tasa); }
}

class Platino extends Cuenta {
    public Platino(String num, String nom) { super(num, nom); }
    @Override public void retirar(double cant) { balance -= cant; }
    public void aplicarInteres() { balance += (balance * 0.10); }
}

/**
 * run:
 * Balance Juan Perez: $-100.0
 * Balance Maria Lopez: $1050.0
 * Balance Carlos Ruiz: $2200.0
 */