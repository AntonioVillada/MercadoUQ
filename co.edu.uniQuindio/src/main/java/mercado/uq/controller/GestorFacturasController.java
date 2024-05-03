package mercado.uq.controller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import mercado.uq.facturacion.GestorFacturas;
import mercado.uq.model.*;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class GestorFacturasController {
    @FXML
    private Button btnCargarFacturas;
    @FXML
    private TableView<Factura> listaFacturas;
    @FXML
    private TableColumn<Factura, Integer> numeroFacturaColumna;
    @FXML
    private TableColumn<Factura, Double> valorTotalColumna;
    @FXML
    private TableColumn<Factura, Date> fechaEmisionColumna;
    //@FXML
    //private TableColumn<Factura, List<Producto>> productosColumna;
    @FXML
    private TableColumn<Factura, Producto> productosColumna;
    @FXML
    private TableColumn<Factura, Cliente> clienteColumna;
    @FXML
    private TableColumn<Factura, String> paisEntregaColumna;
    @FXML
    private TableColumn<Factura, Categoria> categoriasProductosColumna;
    @FXML
    private TableColumn<Factura, Boolean> descuentoAplicadoColum;
    @FXML
    private TableColumn<Factura, Date> fechaCompraColumna;

    private GestorFacturas gestorFacturas = new GestorFacturas();

    @FXML
    private void onCargarFacturasButtonClick() {
        List<Factura> facturas = cargarFacturasCSV("C:\\Proyecto\\txt\\facturas.txt");
        listaFacturas.getItems().addAll(facturas);
    }

    private List<Factura> cargarFacturasCSV(String rutaArchivo) {

        List<Factura> facturas = new ArrayList<>();

        // Leer el archivo CSV y procesar cada línea
        try (BufferedReader br = new BufferedReader(new FileReader(rutaArchivo))) {
            // Leer y descartar la primera línea si contiene encabezados de columna
            br.readLine();

            // Leer las líneas restantes y procesarlas
            String linea;
            while ((linea = br.readLine()) != null) {
                try {
                    System.out.println("ESTA ES LA LINEA: " + linea);
                    String[] partes = linea.split(",");
                    int idFactura = Integer.parseInt(partes[0]);
                    int idProducto = Integer.parseInt(partes[1]);
                    int idCategoria = Integer.parseInt(partes[2]);
                    int idCliente = Integer.parseInt(partes[3]);
                    String paisEntrega = partes[4];
                    boolean descuentoAplicado = Boolean.parseBoolean(partes[5]);
                    double valorTotal = Double.parseDouble(partes[6]);
                    Date fechaEmision = new SimpleDateFormat("dd/MM/yyyy").parse(partes[7]);
                    Date fechaCompra = new SimpleDateFormat("dd/MM/yyyy").parse(partes[8]);

                    Producto producto = GestorProducto.getInstance().buscarProductoPorId(idProducto);
                    Cliente cliente = GestorClientes.getInstance().buscarClientePorId(idCliente);
                    Categoria categoria = GestorCategoria.getInstance().buscarCategoriaPorId(idCategoria);

                    Factura factura = new Factura(idFactura, categoria, producto, cliente, paisEntrega, descuentoAplicado, valorTotal, fechaEmision, fechaCompra);

                    // Agregar la factura a la lista
                    facturas.add(factura);
                } catch (NumberFormatException | ParseException | IndexOutOfBoundsException e) {
                    System.err.println("Error al procesar una línea del archivo CSV: " + e);
                    continue; // Saltar a la siguiente línea
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return facturas;
    }

    @FXML
    public void initialize() {
        numeroFacturaColumna.setCellValueFactory(new PropertyValueFactory<>("numeroDeFactura"));
        valorTotalColumna.setCellValueFactory(new PropertyValueFactory<>("valorTotal"));
        fechaEmisionColumna.setCellValueFactory(new PropertyValueFactory<>("fechaDeEmision"));

        // Configuramos la celda de productos para mostrar los nombres de los productos
        productosColumna.setCellValueFactory(new PropertyValueFactory<>("productos"));
        productosColumna.setCellFactory(tc -> new TableCell<>() {
            @Override
            protected void updateItem(Producto productos, boolean empty) {
                super.updateItem(productos, empty);
                if (empty || productos == null) {
                    setText(null);
                } else {
                    setText(productos.getNombre());
                }
            }
        });

        // Configuramos la celda de cliente para mostrar el nombre del cliente
        clienteColumna.setCellValueFactory(new PropertyValueFactory<>("cliente"));
        clienteColumna.setCellFactory(tc -> new TableCell<Factura, Cliente>() {
            @Override
            protected void updateItem(Cliente cliente, boolean empty) {
                super.updateItem(cliente, empty);
                if (empty || cliente == null) {
                    setText(null);
                } else {
                    setText(cliente.getNombre()); // Mostrar el nombre del cliente
                }
            }
        });

        paisEntregaColumna.setCellValueFactory(new PropertyValueFactory<>("paisDeEntrega"));

        // Configuramos la celda de categorías para mostrar la lista de nombres de categorías
        categoriasProductosColumna.setCellValueFactory(new PropertyValueFactory<>("categoria"));  // Asegúrate de que la Factura tiene un método getCategoria().

        categoriasProductosColumna.setCellFactory(column -> new TableCell<Factura, Categoria>() {
            @Override
            protected void updateItem(Categoria categoria, boolean empty) {
                super.updateItem(categoria, empty);  // Llamada al método de la clase base
                if (empty || categoria == null) {
                    setText(null);
                } else {
                    setText(categoria.getNombreCategoria());  // Asumiendo que Categoria tiene un método getNombre()
                }
            }
        });

        descuentoAplicadoColum.setCellValueFactory(new PropertyValueFactory<>("descuentoAplicado"));
        fechaCompraColumna.setCellValueFactory(new PropertyValueFactory<>("fechaDeCompra"));
    }
}