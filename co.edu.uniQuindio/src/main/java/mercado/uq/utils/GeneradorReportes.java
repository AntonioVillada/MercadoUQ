package mercado.uq.utils;

import mercado.uq.model.Cliente;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

public class GeneradorReportes {
    // Método para generar un reporte de clientes no registrados

    public void generarReporteClientesNoRegistrados(List<Cliente> clientes, List<Cliente> clientesRegistrados) {
        try (PrintWriter printWriter = new PrintWriter(new FileWriter("dataFiles/reportes/clientes_no_registrados.txt"))) {
            printWriter.println("Clientes no registrados:");
            for (Cliente cliente : clientes) {
                if (!clientesRegistrados.contains(cliente)) {
                    printWriter.println("Nombre: " + cliente.getNombre());
                    printWriter.println("Apellido: " + cliente.getApellido());
                    printWriter.println("Correo: " + cliente.getCorreo());
                    printWriter.println("Teléfono: " + cliente.getTelefono());
                    printWriter.println();
                }
            }
            System.out.println("Reporte de clientes no registrados exportado correctamente.");
        } catch (IOException e) {
            System.out.println("Error al exportar el reporte de clientes no registrados.");
            e.printStackTrace();
        }
    }
}