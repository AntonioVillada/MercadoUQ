package mercado.uq.main;
import javafx.application.Application;
import mercado.uq.mainLight.ClienteMainLight;
import mercado.uq.HelloApplication;
//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.


public class Main {
    public static void main(String[] args) {
        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.



        launchApp(args);







         /*
        System.out.printf("Hello and welcome! \n");
        Scanner scanner = new Scanner(System.in);

        GestorProductos gestor = new GestorProductos();
        //GestorClientes gestorClientes = new GestorClientes();
        //GestorFacturas gestorFacturas = new GestorFacturas();

        List<Producto> productos = gestor.cargarProductosCSV
                ("C:\\Proyecto\\txt\\productos.txt");
        for (Producto producto : productos) {
            System.out.println("producto: " + producto.getNombre());
            System.out.println("peso en kg: "+producto.getPeso());
            System.out.println("valor: "+producto.getValor());
            System.out.println();
        }




        Cliente cliente = solicitarDatosCliente(scanner);
        gestorClientes.registrarCliente(cliente);
        gestorClientes.guardarClientesEnCSV("C:\\Proyecto\\txt\\clientes.txt");


        String rutaFacturas = "C:\\Proyecto\\txt\\facturas.txt";
        List<Factura> facturas = gestorFacturas.cargarFacturasCSV(rutaFacturas);
        System.out.println("la cantidad de facturas cargadas son:  " + facturas.size());



       for (Factura factura : facturas) {
            System.out.println("Número de factura: " + factura.getNumeroDeFactura());
            System.out.println("fecha De Compra: " + factura.getFechaDeCompra());
            System.out.println("Cliente: " + factura.getCliente());
            System.out.println("valor Total: " + factura.getValorTotal());
            System.out.println();
        }

        // GeneradorReportes generadorReportes = new GeneradorReportes();
        // generadorReportes.generarReporteClientesNoRegistrados(clientesCargados, clientesRegistrados);

    }

    private static Cliente solicitarDatosCliente(Scanner scanner) {
        System.out.println("Ingrese el nombre del cliente:");
        String nombre = scanner.nextLine();
        System.out.println("Ingrese el apellido del cliente:");
        String apellido = scanner.nextLine();
        System.out.println("Ingrese el correo electronico del cliente:");
        String correo = scanner.nextLine();
        System.out.println("Ingrese el telefono del cliente:");
        String telefono = scanner.nextLine();
        return new Cliente(nombre, apellido, correo, telefono);
    }
    }
*/
    }
    public static void launchApp(String[] args) {
        new Thread(() -> {
            HelloApplication.launch(HelloApplication.class, args);
        }).start();
    }



}