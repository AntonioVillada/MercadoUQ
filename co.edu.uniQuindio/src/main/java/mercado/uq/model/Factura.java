package mercado.uq.model;

import java.util.Date;
import java.util.List;

public class Factura {

    private int numeroDeFactura;
    private Categoria categoria;
    private Producto productos;
    private Cliente cliente;
    private Pais paisEntrega  ;
    private boolean descuentoAplicado;
    private double valorTotal;
    private Date fechaDeEmision;
    private Date fechaDeCompra;

    public Factura(int numeroDeFactura, Categoria categoria, Producto productos, Cliente cliente, Pais paisEntrega, boolean descuentoAplicado, Date fechaDeCompra, Date fechaDeEmision, double valorTotal) {
        this.numeroDeFactura = numeroDeFactura;
        this.categoria = categoria;
        this.productos = productos;
        this.cliente = cliente;
        this.paisEntrega = paisEntrega;
        this.descuentoAplicado = descuentoAplicado;
        this.fechaDeCompra = fechaDeCompra;
        this.fechaDeEmision = fechaDeEmision;
        this.valorTotal = valorTotal;
    }

    public Factura() {
    }


    public int getNumeroDeFactura() {
        return numeroDeFactura;
    }

    public void setNumeroDeFactura(int numeroDeFactura) {
        this.numeroDeFactura = numeroDeFactura;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public Producto getProductos() {
        return productos;
    }

    public void setProductos(Producto productos) {
        this.productos = productos;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Pais getPaisEntrega() {
        return paisEntrega;
    }

    public void setPaisEntrega(Pais paisEntrega) {
        this.paisEntrega = paisEntrega;
    }

    public boolean isDescuentoAplicado() {
        return descuentoAplicado;
    }

    public void setDescuentoAplicado(boolean descuentoAplicado) {
        this.descuentoAplicado = descuentoAplicado;
    }

    public double getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(double valorTotal) {
        this.valorTotal = valorTotal;
    }

    public Date getFechaDeEmision() {
        return fechaDeEmision;
    }

    public void setFechaDeEmision(Date fechaDeEmision) {
        this.fechaDeEmision = fechaDeEmision;
    }

    public Date getFechaDeCompra() {
        return fechaDeCompra;
    }

    public void setFechaDeCompra(Date fechaDeCompra) {
        this.fechaDeCompra = fechaDeCompra;
    }


}
