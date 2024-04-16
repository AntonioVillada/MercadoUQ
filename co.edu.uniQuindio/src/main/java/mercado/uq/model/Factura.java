package mercado.uq.model;

import java.util.Date;
import java.util.List;

public class Factura {

    private int numeroDeFactura;
    private Categoria categoria;
    private Producto productos;
    private Cliente cliente;
    private String paisDeEntrega;
    private boolean descuentoAplicado;
    private double valorTotal;
    private Date fechaDeEmision;
    private Date fechaDeCompra;

    public Factura(int numeroDeFactura, Categoria categoria, Producto productos, Cliente cliente, String paisDeEntrega, boolean descuentoAplicado, double valorTotal, Date fechaDeEmision, Date fechaDeCompra) {
        this.numeroDeFactura = numeroDeFactura;
        this.categoria = categoria;
        this.productos = productos;
        this.cliente = cliente;
        this.paisDeEntrega = paisDeEntrega;
        this.descuentoAplicado = descuentoAplicado;
        this.valorTotal = valorTotal;
        this.fechaDeEmision = fechaDeEmision;
        this.fechaDeCompra = fechaDeCompra;
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

    public String getPaisDeEntrega() {
        return paisDeEntrega;
    }

    public void setPaisDeEntrega(String paisDeEntrega) {
        this.paisDeEntrega = paisDeEntrega;
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
