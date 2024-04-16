package mercado.uq.controller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import mercado.uq.facturacion.GestorFacturas;
import mercado.uq.model.Categoria;
import mercado.uq.model.Cliente;
import mercado.uq.model.Factura;
import mercado.uq.model.Producto;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static mercado.uq.model.Categoria.buscarCategoriaPorId;
import static mercado.uq.model.Cliente.buscarClientePorId;
import static mercado.uq.model.Producto.buscarProductoPorId;

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
    @FXML
    private TableColumn<Factura, List<Producto>> productosColumna;
    @FXML
    private TableColumn<Factura, Cliente> clienteColumna;
    @FXML
    private TableColumn<Factura, String> paisEntregaColumna;
    @FXML
    private TableColumn<Factura, String> categoriasProductosColumna;
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

                    // Buscar el producto, categoría y cliente en el sistema
                    Producto producto = buscarProductoPorId(idProducto);
                    Categoria categoria = buscarCategoriaPorId(idCategoria);
                    Cliente cliente = buscarClientePorId(idCliente);

                    // Crear la factura con los datos obtenidos
                    Factura factura = new Factura(idFactura, categoria, producto, cliente, paisEntrega, descuentoAplicado, valorTotal, fechaEmision, fechaCompra);

                    // Agregar la factura a la lista
                    facturas.add(factura);
                } catch (NumberFormatException | ParseException | IndexOutOfBoundsException e) {
                    // Manejar el caso en el que alguna parte del archivo esté vacía o no sea válida
                    System.err.println("Error al procesar una línea del archivo CSV: " + e.getMessage());
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
            protected void updateItem(List<Producto> productos, boolean empty) {
                super.updateItem(productos, empty);
                if (empty || productos == null || productos.isEmpty()) {
                    setText(null);
                } else {
                    StringBuilder sb = new StringBuilder();
                    for (Producto producto : productos) {
                        sb.append(producto.getNombre()).append(", ");
                    }
                    // Eliminar la coma y el espacio final
                    setText(sb.delete(sb.length() - 2, sb.length()).toString());
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
        categoriasProductosColumna.setCellValueFactory(new PropertyValueFactory<>("categoriasDeProductos"));
        categoriasProductosColumna.setCellFactory(tc -> new TableCell<Factura, String>() {
            @Override
            protected void updateItem(String categorias, boolean empty) {
                super.updateItem(categorias, empty);
                if (empty || categorias == null || categorias.isEmpty()) {
                    setText(null);
                } else {
                    setText(categorias);
                }
            }
        });

        descuentoAplicadoColum.setCellValueFactory(new PropertyValueFactory<>("descuentoAplicado"));
        fechaCompraColumna.setCellValueFactory(new PropertyValueFactory<>("fechaDeCompra"));
    }
}