package mercado.uq.controller;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import mercado.uq.facturacion.GestorFacturas;
import mercado.uq.model.Cliente;
import mercado.uq.model.Factura;
import mercado.uq.model.Producto;

import java.util.Date;
import java.util.List;

public class GestorFacturasController {
    @FXML private Button btnCargarFacturas;

    @FXML private TableView<Factura> listaFacturas;
    @FXML private TableColumn<Factura, Integer> numeroFacturaColumna;
    @FXML private TableColumn<Factura, Double> valorTotalColumna;
    @FXML private TableColumn<Factura, Date> fechaEmisionColumna;
    @FXML private TableColumn<Factura, List<Producto>> productosColumna;
    @FXML private TableColumn<Factura, Cliente> clienteColumna;
    @FXML private TableColumn<Factura, String> paisEntregaColumna;
    @FXML private TableColumn<Factura, String> categoriasProductosColumna;
    @FXML private TableColumn<Factura, Boolean> descuentoAplicadoColum;
    @FXML private TableColumn<Factura, Integer> prioridadColumna;
    @FXML private TableColumn<Factura, Date> fechaCompraColumna;


    private GestorFacturas gestorFacturas = new GestorFacturas();

        @FXML
        private void onCargarFacturasButtonClick() {
            List<Factura> facturas = gestorFacturas.cargarFacturasCSV("C:\\Proyecto\\txt\\facturas.txt");
            listaFacturas.getItems().clear();
            listaFacturas.getItems().addAll(facturas);
        }

    @FXML
    public void initialize() {
        numeroFacturaColumna.setCellValueFactory(new PropertyValueFactory<>("numeroDeFactura"));
        valorTotalColumna.setCellValueFactory(new PropertyValueFactory<>("valorTotal"));
        fechaEmisionColumna.setCellValueFactory(new PropertyValueFactory<>("fechaDeEmision"));
        productosColumna.setCellValueFactory(new PropertyValueFactory<>("productos"));
        clienteColumna.setCellValueFactory(new PropertyValueFactory<>("cliente"));
        paisEntregaColumna.setCellValueFactory(new PropertyValueFactory<>("paisDeEntrega"));
        categoriasProductosColumna.setCellValueFactory(new PropertyValueFactory<>("categoriasDeProductos"));
        descuentoAplicadoColum.setCellValueFactory(new PropertyValueFactory<>("descuentoAplicado"));
        prioridadColumna.setCellValueFactory(new PropertyValueFactory<>("prioridad"));
        fechaCompraColumna.setCellValueFactory(new PropertyValueFactory<>("fechaDeCompra"));
    }
    }
