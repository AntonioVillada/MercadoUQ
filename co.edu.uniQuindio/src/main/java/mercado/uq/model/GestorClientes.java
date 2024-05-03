package mercado.uq.model;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

//Esta clase es para crear la Lista de clientes que se va a usar en toda la APP
public class GestorClientes {

    private ArrayList<Cliente> listaClientes;
    private static GestorClientes instance;

    // Constructor
    public GestorClientes() {
        listaClientes = new ArrayList<>();
    }

    // Método para registrar un nuevo cliente
    public void agregarCliente(Cliente cliente) {
        listaClientes.add(cliente);
    }

    public static synchronized GestorClientes getInstance() {
        if (instance == null) {
            instance = new GestorClientes();
        }
        return instance;
    }

//    Método para guardar los clientes en un archivo de CSV
//    public void guardarClientesEnCSV(String rutaArchivo) {
//
//        try (PrintWriter printWriter = new PrintWriter(new FileWriter(rutaArchivo, true))) {
//            for (Cliente cliente : listaClientes) {
//                printWriter.println(cliente.getNombre() + "," + cliente.getApellido() + "," + cliente.getCorreo() + "," + cliente.getTelefono());
//            }
//        } catch (IOException e) {
//            System.out.println("Error al guardar clientes en el archivo CSV.");
//            e.printStackTrace();
//        }
//    }


    //Metodo para buscar en la lista de Clientes, un cliente por id
    public Cliente buscarClientePorId(int id) {
        for (Cliente cliente : listaClientes) {
            if (cliente.getIdCliente() == id) {
                return cliente;
            }
        }
        return null;
    }

    // Método para obtener la lista de clientes
    public List<Cliente> getClientes() {
        return listaClientes;
    }
}
