package mercado.uq.model;

import java.util.List;

public class Producto {

    private int idProducto;
    private Categoria categoria;
    private double valor;
    private int existencias;
    private double peso;
    private String tamaño;
    private String nombre;
    private String descripcionProducto;

    public Producto(int idProducto, Categoria categoria, double valor, int existencias, double peso, String tamaño, String nombre, String descripcionProducto) {
        this.idProducto = idProducto;
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

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public int getExistencias() {
        return existencias;
    }

    public void setExistencias(int existencias) {
        this.existencias = existencias;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTamaño() {
        return tamaño;
    }

    public void setTamaño(String tamaño) {
        this.tamaño = tamaño;
    }

    public String getDescripcionProducto() {
        return descripcionProducto;
    }

    public void setDescripcionProducto(String descripcionProducto) {
        this.descripcionProducto = descripcionProducto;
    }

    public int getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(int idProducto) {
        this.idProducto = idProducto;
    }
}
