package mercado.uq.model;

import java.util.Date;
import java.util.List;

public class Factura {
    private int numeroDeFactura;
    private double valorTotal;
    private Date fechaDeEmision;
    private List<Producto> productos;
    private Cliente cliente;
    private String paisDeEntrega;
    private String categoriasDeProductos;
    private boolean descuentoAplicado;
    private int prioridad;
    private Date fechaDeCompra;

    public Factura() {
        this.numeroDeFactura = numeroDeFactura;
        this.valorTotal = valorTotal;
        this.fechaDeEmision = fechaDeEmision;
        this.productos = productos;
        this.cliente = cliente;
        this.paisDeEntrega = paisDeEntrega;
        this.categoriasDeProductos = categoriasDeProductos;
        this.descuentoAplicado = descuentoAplicado;
        this.prioridad = prioridad;
        this.fechaDeCompra = fechaDeCompra;
    }


    public int getNumeroDeFactura() {
        return numeroDeFactura;
    }

    public void setNumeroDeFactura(int numeroDeFactura) {
        this.numeroDeFactura = numeroDeFactura;
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

    public List<Producto> getProductos() {
        return productos;
    }

    public void setProductos(List<Producto> productos) {
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

    public String getCategoriasDeProductos() {
        return categoriasDeProductos;
    }

    public void setCategoriasDeProductos(String categoriasDeProductos) {
        this.categoriasDeProductos = categoriasDeProductos;
    }

    public boolean isDescuentoAplicado() {
        return descuentoAplicado;
    }

    public void setDescuentoAplicado(boolean descuentoAplicado) {
        this.descuentoAplicado = descuentoAplicado;
    }

    public int getPrioridad() {
        return prioridad;
    }

    public void setPrioridad(int prioridad) {
        this.prioridad = prioridad;
    }

    public Date getFechaDeCompra() {
        return fechaDeCompra;
    }

    public void setFechaDeCompra(Date fechaDeCompra) {
        this.fechaDeCompra = fechaDeCompra;
    }
}
