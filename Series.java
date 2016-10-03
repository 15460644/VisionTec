package chomy;

import javax.swing.JOptionPane;

public class Series extends VisionTec {

    byte discos, temporada;
    String director;

    public Series(byte discos, byte temporada, String director, String clasificacion, String genero, String nombre, String propietario, int nip, int añoInicio, int lanzamiento, String diaInicio, String diaFin, String mesInicio, float precio) {
        super(clasificacion, genero, nombre, propietario, nip, añoInicio, lanzamiento, diaInicio, diaFin, mesInicio, precio);
        this.discos = discos;
        this.temporada = temporada;
        this.director = director;
    }

    Series(String nombre, int encontrar, int nip, String propietario, String diaFin) {
        super(nombre, encontrar, nip, propietario, diaFin);
    }

    public byte getDiscos() {
        return discos;
    }

    public void setDiscos(byte discos) {
        this.discos = discos;
    }

    public byte getTemporada() {
        return temporada;
    }

    public void setTemporada(byte temporada) {
        this.temporada = temporada;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    @Override
    public void mostrar() {
        JOptionPane.showMessageDialog(null, " La serie: " + nombre + "\n Cuyo Director es: " + director + "\n Con lanzamiento en " + lanzamiento + "\n Temporada: " + temporada + "\n Con la cantidad de: " + discos + " discos\n Con Género: " + genero + "\n Clasificación: " + clasificacion + "\n Fue rentada por: " + propietario + "\n NIP: " + nip + "\n --------------------------\n Fecha inicio: " + diaInicio + " / " + mesInicio + " / " + añoInicio + "\n Se devolverá en: " + diaFin + " dias\n SUB-TOTAL: $ " + precio + " pesos", "INFORMACIÓN", JOptionPane.INFORMATION_MESSAGE);
    }

    @Override
    public void mostrarAlta() {
        JOptionPane.showMessageDialog(null, "------------SERIE------------\n Nombre: " + nombre + "\n Director: " + director + "\n Temporada: " + temporada + "\n Género: " + genero + "\n Clasificación: " + clasificacion + "\n Discos: " + discos + " disco(s)", "INFORMACIÓN", JOptionPane.INFORMATION_MESSAGE);
    }

    public void mostrarDevolucion(float precio) {
        JOptionPane.showMessageDialog(null, " TOTAL A PAGAR: $ " + precio + " pesos", "INFORMACIÓN", JOptionPane.INFORMATION_MESSAGE);
        JOptionPane.showMessageDialog(null, "DEVOLUCIÓN EXITOSA", "INFORMACIÓN", JOptionPane.INFORMATION_MESSAGE);
    }
}
