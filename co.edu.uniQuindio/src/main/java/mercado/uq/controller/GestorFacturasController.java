package mercado.uq.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import mercado.uq.HelloApplication;
import mercado.uq.facturacion.GestorFacturas;
import mercado.uq.model.*;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class GestorFacturasController {
    @FXML
    private Button btnCargarFacturas;
    @FXML
    public TableView<Factura> listaFacturas;
    @FXML
    private TableColumn<Factura, Integer> numeroFacturaColumna;
    @FXML
    private TableColumn<Factura, Double> valorTotalColumna;
    @FXML
    private TableColumn<Factura, Date> fechaEmisionColumna;
    @FXML
    private TableColumn<Factura, Producto> productosColumna;
    @FXML
    private TableColumn<Factura, Cliente> clienteColumna;
    @FXML
    private TableColumn<Factura, Pais> paisEntregaColumna;
    @FXML
    private TableColumn<Factura, Categoria> categoriasProductosColumna;
    @FXML
    private TableColumn<Factura, Boolean> descuentoAplicadoColum;
    @FXML
    private TableColumn<Factura, Date> fechaCompraColumna;

    private GestorFacturas gestorFacturas = GestorFacturas.getInstance();
    private GestorPais gestorPaises = GestorPais.getInstance();
    private FacturaScheduler scheduler;

    @FXML
    private void cargarMenu(ActionEvent event) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("PanelPrincipal.fxml"));
            Parent root = fxmlLoader.load();

            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();

            Scene scene = stage.getScene();
            scene.setRoot(root);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void onCargarFacturasButtonClick() {
        System.out.println("Button clicked. Loading new invoices...");
        List<Factura> nuevasFacturas = scheduler.getNuevasFacturas();
        System.out.println("New invoices to add: " + nuevasFacturas.size());
        listaFacturas.getItems().clear();
        listaFacturas.getItems().addAll(nuevasFacturas);
        System.out.println("Cantidad nueva de facturas es: " + gestorFacturas.cantidadFacturas());
    }

    public List<Factura> cargarFacturasCSV(String rutaArchivo) {
        System.out.println("Cargando archivo CSV: " + rutaArchivo);
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
                    Pais pais = gestorPaises.buscarPaisNombre(partes[4]);
                    boolean descuentoAplicado = Boolean.parseBoolean(partes[5]);
                    double valorTotal = Double.parseDouble(partes[6]);
                    Date fechaEmision = new SimpleDateFormat("dd/MM/yyyy").parse(partes[7]);
                    Date fechaCompra = new SimpleDateFormat("dd/MM/yyyy").parse(partes[8]);

                    Producto producto = GestorProducto.getInstance().buscarProductoPorId(idProducto);
                    Cliente cliente = GestorClientes.getInstance().buscarClientePorId(idCliente);
                    Categoria categoria = GestorCategoria.getInstance().buscarCategoriaPorId(idCategoria);

                    boolean facturaExiste = gestorFacturas.existeFactura(idFactura);
                    if(!facturaExiste){
                        Factura factura = new Factura(idFactura, categoria, producto, cliente, pais, descuentoAplicado, fechaCompra, fechaEmision, valorTotal);
                        gestorFacturas.agregarFactura(factura);
                    }

                } catch (NumberFormatException | ParseException | IndexOutOfBoundsException e) {
                    System.err.println("Error al procesar una línea del archivo CSV: " + e);
                    continue; // Saltar a la siguiente línea
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return gestorFacturas.getListaFacturas();
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

        paisEntregaColumna.setCellValueFactory(new PropertyValueFactory<>("paisEntrega"));
        paisEntregaColumna.setCellFactory(tc -> new TableCell<Factura, Pais>() {
            @Override
            protected void updateItem(Pais pais, boolean empty) {
                super.updateItem(pais, empty);
                if (empty || pais == null) {
                    setText(null);
                } else {
                    setText(pais.getNombrePais());
                }
            }
        });

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

        // Iniciar el FacturaScheduler
        scheduler = new FacturaScheduler(this);
        scheduler.start();
    }
}
