package chomy;

import javax.swing.JOptionPane;

public class Videojuegos extends VisionTec {

    String plataforma;

    public Videojuegos(String plataforma, String clasificacion, String genero, String nombre, String propietario, int nip, int añoInicio, int lanzamiento, String diaInicio, String diaFin, String mesInicio, float precio) {
        super(clasificacion, genero, nombre, propietario, nip, añoInicio, lanzamiento, diaInicio, diaFin, mesInicio, precio);
        this.plataforma = plataforma;
    }

    Videojuegos(String nombre, int encontrar, int nip, String propietario, String diaFin) {
        super(nombre, encontrar, nip, propietario, diaFin);
    }

    public String getPlataforma() {
        return plataforma;
    }

    public void setPlataforma(String plataforma) {
        this.plataforma = plataforma;
    }

    @Override
    public void mostrar() {
        JOptionPane.showMessageDialog(null, " El videojuego: " + nombre + "\n Con Género: " + genero + "\n Clasificación: " + clasificacion + "\n Para la plataforma: " + plataforma + "\n Fue rentado por: " + propietario + "\n NIP: " + nip + "\n --------------------------\n Fecha inicio: " + diaInicio + " / " + mesInicio + " / " + añoInicio + "\n Se devolverá en: " + diaFin + " dias\n SUB-TOTAL: $ " + precio + " pesos");
    }

    @Override
    public void mostrarAlta() {
        JOptionPane.showMessageDialog(null, "------------VIDEOJUEGO------------\n Nombre: " + nombre + "\n Lanzamiento: " + lanzamiento + "\n Plataforma: " + plataforma + "\n Género: " + genero + "\n Clasificación: " + clasificacion, "INFORMACIÓN", JOptionPane.INFORMATION_MESSAGE);
    }

    public void mostrarDevolucion(float precio) {
        JOptionPane.showMessageDialog(null, " TOTAL A PAGAR: $ " + precio + " pesos", "INFORMACIÓN", JOptionPane.INFORMATION_MESSAGE);
        JOptionPane.showMessageDialog(null, "DEVOLUCIÓN EXITOSA", "INFORMACIÓN", JOptionPane.INFORMATION_MESSAGE);
    }
}
