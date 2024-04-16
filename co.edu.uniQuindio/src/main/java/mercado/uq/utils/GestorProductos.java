package mercado.uq.utils;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import mercado.uq.model.Categoria;
import mercado.uq.model.Producto;

    public class GestorProductos {
        // Método para cargar productos desde un archivo CSV
        public List<Producto> cargarProductosCSV(String rutaArchivo) {
            List<Producto> productos = new ArrayList<>();

            try (Scanner scanner = new Scanner(new File(rutaArchivo))) {
                // Saltar la primera línea que contiene la cabecera
                if (scanner.hasNextLine()) {
                    scanner.nextLine();
                }
                // Leer cada línea del archivo CSV
                while (scanner.hasNextLine()) {
                    String linea = scanner.nextLine();
                    // Dividir la línea en campos utilizando la coma como delimitador
                    String[] campos = linea.split(",");
                    // Crear un nuevo objeto Producto con los campos y agregarlo a la lista de productos
                    Producto producto = new Producto();
//                    producto.setCategoria(new Categoria());
                    producto.setValor(Double.parseDouble(campos[1]));
                    producto.setExistencias(Integer.parseInt(campos[2]));
                    producto.setPeso(Double.parseDouble(campos[3]));
                    producto.setTamaño(campos[4]);
                    producto.setNombre(campos[5]);
                    producto.setDescripcionProducto(campos[6]);
                    productos.add(producto);
                }
                System.out.println("Productos cargados desde el archivo CSV.");
            } catch (FileNotFoundException e) {
                System.out.println("Error: Archivo CSV no encontrado.");
                e.printStackTrace();
            }
            return productos;
        }
    }

