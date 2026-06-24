import java.util.ArrayList;

/**
 * Problema_3: Sistema de envío de mensajes a móviles.
 * Implementación de un sistema de mensajería (SMS y MMS) con una jerarquía
 * de herencia, permitiendo el envío y visualización de mensajes entre móviles.
 * @author Jhandry Navarrete
 * @version 1.0
 */

public class Problema_3_EjecutorMensaje {
    public static void main(String[] args) {
        Movil remitente = new Movil("999111222", "Juan");
        Movil destinatario = new Movil("999333444", "Maria");

        SMS sms = new SMS(remitente, destinatario, "Hola, ¿cómo estás?");
        MMS mms = new MMS(remitente, destinatario, "foto_vacaciones.jpg");

        sms.enviarMensaje();
        System.out.println(sms.visualizarMensaje());

        mms.enviarMensaje();
        System.out.println(mms.visualizarMensaje());
    }
}

class Movil {
    private String numero;
    private String nombre;

    public Movil(String numero, String nombre) { 
        this.numero = numero; 
        this.nombre = nombre; 
    }

    @Override 
    public String toString() { 
        return nombre + " (" + numero + ")"; 
    }
}

abstract class Mensaje {
    protected Movil remitente;
    protected Movil destinatario;

    public Mensaje(Movil remitente, Movil destinatario) { 
        this.remitente = remitente; 
        this.destinatario = destinatario; 
    }

    public void enviarMensaje() { 
        System.out.println("Enviando mensaje de " + remitente + " a " + destinatario + "..."); 
    }

    public abstract String visualizarMensaje();
}

class SMS extends Mensaje {
    private String texto;

    public SMS(Movil rem, Movil dest, String texto) { 
        super(rem, dest); 
        this.texto = texto; 
    }

    @Override 
    public String visualizarMensaje() { 
        return "SMS [Texto: " + texto + "]"; 
    }
}

class MMS extends Mensaje {
    private String nombreFichero;

    public MMS(Movil rem, Movil dest, String nombreFichero) { 
        super(rem, dest); 
        this.nombreFichero = nombreFichero; 
    }

    @Override 
    public String visualizarMensaje() { 
        return "MMS [Imagen: " + nombreFichero + "]"; 
    }
}

/**
 * run:
 * Enviando mensaje de Juan (999111222) a Maria (999333444)...
 * SMS [Texto: Hola, ¿cómo estás?]
 * Enviando mensaje de Juan (999111222) a Maria (999333444)...
 * MMS [Imagen: foto_vacaciones.jpg]
 */