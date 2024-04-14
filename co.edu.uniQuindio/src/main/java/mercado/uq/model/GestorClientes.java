package mercado.uq.model;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class GestorClientes {
    private ArrayList<Cliente> listaClientes;

    // Constructor
    public GestorClientes() {
        listaClientes = new ArrayList<>();
    }

    // Método para registrar un nuevo cliente
    public void registrarCliente(Cliente cliente) {
        listaClientes.add(cliente);
        System.out.println("Cliente registrado:");
        System.out.println("Nombre: " + cliente.getNombre());
        System.out.println("Apellido: " + cliente.getApellido());
        System.out.println("Correo: " + cliente.getCorreo());
        System.out.println("Teléfono: " + cliente.getTelefono());
    }

    // Método para guardar los clientes en un archivo de CSV

    public void guardarClientesEnCSV(String rutaArchivo) {

        try (PrintWriter printWriter = new PrintWriter(new FileWriter(rutaArchivo, true))) {
            // Escribir los datos de cada cliente
            for (Cliente cliente : listaClientes) {
                printWriter.println(cliente.getNombre() + "," + cliente.getApellido() + "," + cliente.getCorreo() + "," + cliente.getTelefono());
            }
        } catch (IOException e) {
            System.out.println("Error al guardar clientes en el archivo CSV.");
            e.printStackTrace();
        }
    }
}
