package mercado.uq.model;

public class Producto {

    private String categoria;
    private double valor;
    private int existencias;
    private double peso;
    private String tamaño;
    private String nombre;
    private String descripcionProducto;

    // Constructor
    public Producto(String categoria, double valor, int existencias, double peso, String tamaño, String nombre, String descripcionProducto) {
        this.categoria = categoria;
        this.valor = valor;
        this.existencias = existencias;
        this.peso = peso;
        this.tamaño = tamaño;
        this.nombre = nombre;
        this.descripcionProducto = descripcionProducto;
    }

    public Producto() {

    }

    // geter y seter
    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public int getExistencias() {
        return existencias;
    }

    public void setExistencias(int existencias) {
        this.existencias = existencias;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public String getTamaño() {
        return tamaño;
    }

    public void setTamaño(String tamaño) {
        this.tamaño = tamaño;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcionProducto() {
        return descripcionProducto;
    }

    public void setDescripcionProducto(String descripcionProducto) {
        this.descripcionProducto = descripcionProducto;
    }
}
