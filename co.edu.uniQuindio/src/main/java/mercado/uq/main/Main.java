package mercado.uq.main;

import mercado.uq.facturacion.GestorFacturas;
import mercado.uq.model.Cliente;
import mercado.uq.model.Factura;
import mercado.uq.model.GestorClientes;
import mercado.uq.utils.GeneradorReportes;
import java.util.List;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.
        System.out.printf("Hello and welcome! \n");
        Scanner scanner = new Scanner(System.in);
        GestorClientes gestorClientes = new GestorClientes();

        //Cliente cliente = solicitarDatosCliente(scanner);
        //gestorClientes.registrarCliente(cliente);
        //gestorClientes.guardarClientesEnCSV("C:\\Proyecto\\txt\\clientes.txt");

        String rutaFacturas = "C:\\Proyecto\\txt\\facturas.txt";
        GestorFacturas gestorFacturas = new GestorFacturas();
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