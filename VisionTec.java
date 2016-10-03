package chomy;

public class VisionTec {

    String clasificacion, genero, nombre, propietario, mesInicio, diaInicio, diaFin;
    int nip, añoInicio, lanzamiento, encontrar;
    float precio;

    public VisionTec(String clasificacion, String genero, String nombre, String propietario, int nip, int añoInicio, int lanzamiento, String diaInicio, String diaFin, String mesInicio, float precio) {
        this.clasificacion = clasificacion;
        this.genero = genero;
        this.nombre = nombre;
        this.propietario = propietario;
        this.nip = nip;
        this.añoInicio = añoInicio;
        this.lanzamiento = lanzamiento;
        this.diaInicio = diaInicio;
        this.diaFin = diaFin;
        this.mesInicio = mesInicio;
        this.precio = precio;
    }

    VisionTec(String nombre, int encontrar, int nip, String propietario, String diaFin) {
        this.nombre = nombre;
        this.encontrar = encontrar;
        this.nip = nip;
        this.propietario = propietario;
        this.diaFin = diaFin;
    }

    public int getEncontrar() {
        return encontrar;
    }

    public void setEncontrar(int encontrar) {
        this.encontrar = encontrar;
    }

    public float getPrecio() {
        return precio;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }

    public String getClasificacion() {
        return clasificacion;
    }

    public void setClasificacion(String clasificacion) {
        this.clasificacion = clasificacion;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPropietario() {
        return propietario;
    }

    public void setPropietario(String propietario) {
        this.propietario = propietario;
    }

    public int getNip() {
        return nip;
    }

    public void setNip(int nip) {
        this.nip = nip;
    }

    public int getAñoInicio() {
        return añoInicio;
    }

    public void setAñoInicio(int añoInicio) {
        this.añoInicio = añoInicio;
    }

    public int getLanzamiento() {
        return lanzamiento;
    }

    public void setLanzamiento(int lanzamiento) {
        this.lanzamiento = lanzamiento;
    }

    public String getDiaInicio() {
        return diaInicio;
    }

    public void setDiaInicio(String diaInicio) {
        this.diaInicio = diaInicio;
    }

    public String getDiaFin() {
        return diaFin;
    }

    public void setDiaFin(String diaFin) {
        this.diaFin = diaFin;
    }

    public String getMesInicio() {
        return mesInicio;
    }

    public void setMesInicio(String mesInicio) {
        this.mesInicio = mesInicio;
    }

    public void mostrar() {

    }

    public void mostrarAlta() {

    }

    public void mostrarDevolucion() {

    }
}
