package chomy;

import javax.swing.JOptionPane;

public class Peliculas extends VisionTec {

    String calidad, director;
    int duracion;

    public Peliculas(String calidad, String director, int duracion, String clasificacion, String genero, String nombre, String propietario, int nip, int añoInicio, int lanzamiento, String diaInicio, String diaFin, String mesInicio, float precio) {
        super(clasificacion, genero, nombre, propietario, nip, añoInicio, lanzamiento, diaInicio, diaFin, mesInicio, precio);
        this.calidad = calidad;
        this.director = director;
        this.duracion = duracion;
    }

    Peliculas(String calidad, String director, int duracion, String clasificacion, String genero, String nombre, int lanzamiento, String propietario, int nip, int añoInicio, String diaInicio, String diaFin, String mesInicio, float precio) {
        super(clasificacion, genero, nombre, propietario, nip, añoInicio, lanzamiento, diaInicio, diaFin, mesInicio, precio);
        this.calidad = calidad;
        this.duracion = duracion;
        this.clasificacion = clasificacion;
        this.genero = genero;
        this.nombre = nombre;
        this.lanzamiento = lanzamiento;
        this.director = director;
    }

    Peliculas(String nombre, int encontrar, int nip, String propietario, String diaFin) {
        super(nombre, encontrar, nip, propietario, diaFin);
    }

    public String getCalidad() {
        return calidad;
    }

    public void setCalidad(String calidad) {
        this.calidad = calidad;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public int getDuracion() {
        return duracion;
    }

    public void setDuracion(int duracion) {
        this.duracion = duracion;
    }

    @Override

    public void mostrar() {
        JOptionPane.showMessageDialog(null, " La pelicula: " + nombre + "\n Con Duración de: " + duracion + " minutos\n Con Género: " + genero + "\n Clasificación: " + clasificacion + "\n Fue rentada por: " + propietario + "\n NIP: " + nip + "\n Con Calidad: " + calidad + "\n --------------------------\n Fecha inicio: " + diaInicio + " / " + mesInicio + " / " + añoInicio + "\n Se devolverá en: " + diaFin + " dias\n SUB-TOTAL: $ " + precio + " pesos", "INFORMACIÓN", JOptionPane.INFORMATION_MESSAGE);
    }

    @Override
    public void mostrarAlta() {
        JOptionPane.showMessageDialog(null, "------------PELICULA------------\n Nombre: " + nombre + "\n Lanzamiento: " + lanzamiento + "\n Director: " + director + "\n Género: " + genero + "\n Clasificación: " + clasificacion + "\n Duración: " + duracion + " minutos\n Calidad: " + calidad, "INFORMACIÓN", JOptionPane.INFORMATION_MESSAGE);
    }

    public void mostrarDevolucion(float precio) {
        JOptionPane.showMessageDialog(null, " TOTAL A PAGAR: $ " + precio + " pesos", "INFORMACIÓN", JOptionPane.INFORMATION_MESSAGE);
        JOptionPane.showMessageDialog(null, "DEVOLUCIÓN EXITOSA", "INFORMACIÓN", JOptionPane.INFORMATION_MESSAGE);
    }
}
