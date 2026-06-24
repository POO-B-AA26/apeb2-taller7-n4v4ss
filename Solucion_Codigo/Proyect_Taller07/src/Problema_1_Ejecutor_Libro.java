import java.util.ArrayList;

/**
 * Problema_1:Dibuje un diagrama de clases que muestre la estructura
 * de un capítulo de libro; un capítulo está compuesto por
 * varias secciones, cada una de las cuales 
 * comprende varios párrafos y figuras. Un párrafo incluye 
 * varias sentencias, cada una de las cuales contiene varias palabras.
 * @author Jhandry Navarrete
 * @version 1.0
 */

public class Problema_1_Ejecutor_Libro {
    public static void main(String[] args) {
        Problema_1_CapituloLibro cap = new Problema_1_CapituloLibro("Arquitectura de Software", 1);
        Problema_1_SeccionLibro sec = new Problema_1_SeccionLibro("Introducción");
        
        Problema_1_ParrafoLibro p = new Problema_1_ParrafoLibro();
        Problema_1_SentenciaLibro s = new Problema_1_SentenciaLibro();
        s.agregarPalabra(new Problema_1_PalabraLibro("Hola"));
        s.agregarPalabra(new Problema_1_PalabraLibro("Mundo"));
        p.agregarSentencia(s);
        
        sec.agregarComponente(p);
        sec.agregarComponente(new Problema_1_FiguraLibro("Diagrama UML"));
        cap.agregarSeccion(sec);
        
        System.out.println(cap.toString());
        for (Problema_1_SeccionLibro seccion : cap.getSecciones()) {
            System.out.println(seccion.toString());
        }
    }
}

class Problema_1_PalabraLibro {
    private String valor;
    public Problema_1_PalabraLibro(String valor) { this.valor = valor; }
    @Override public String toString() { return valor; }
}

class Problema_1_SentenciaLibro {
    private ArrayList<Problema_1_PalabraLibro> palabras = new ArrayList<>();
    public void agregarPalabra(Problema_1_PalabraLibro p) { this.palabras.add(p); }
    @Override public String toString() { return "Sentencia con " + palabras.size() + " palabras."; }
}

abstract class Problema_1_ComponenteContenidoLibro {
    public abstract String mostrar();
}

class Problema_1_ParrafoLibro extends Problema_1_ComponenteContenidoLibro {
    private ArrayList<Problema_1_SentenciaLibro> sentencias = new ArrayList<>();
    public void agregarSentencia(Problema_1_SentenciaLibro s) { this.sentencias.add(s); }
    @Override public String mostrar() { return "Parrafo con " + sentencias.size() + " sentencias."; }
}

class Problema_1_FiguraLibro extends Problema_1_ComponenteContenidoLibro {
    private String titulo;
    public Problema_1_FiguraLibro(String titulo) { this.titulo = titulo; }
    @Override public String mostrar() { return "Figura: " + titulo; }
}

class Problema_1_SeccionLibro {
    private String titulo;
    private ArrayList<Problema_1_ComponenteContenidoLibro> componentes = new ArrayList<>();
    public Problema_1_SeccionLibro(String titulo) { this.titulo = titulo; }
    public void agregarComponente(Problema_1_ComponenteContenidoLibro c) { this.componentes.add(c); }
    @Override public String toString() { return "Seccion: " + titulo; }
}

class Problema_1_CapituloLibro {
    private String titulo;
    private int numero;
    private ArrayList<Problema_1_SeccionLibro> secciones = new ArrayList<>();
    public Problema_1_CapituloLibro(String titulo, int numero) { this.titulo = titulo; this.numero = numero; }
    public ArrayList<Problema_1_SeccionLibro> getSecciones() { return secciones; }
    public void agregarSeccion(Problema_1_SeccionLibro s) { this.secciones.add(s); }
    @Override public String toString() { return "Capitulo " + numero + ": " + titulo; }
}

/**
 * run:
 * Capitulo 1: Arquitectura de Software
 * Seccion: Introducción
 */