package mercado.uq.model;

import java.util.ArrayList;
import java.util.List;

public class GestorProducto {
    private static List<Producto> productos = new ArrayList<>();

    // Método para agregar un producto a la lista
    public static void agregarProducto(Producto producto) {
        productos.add(producto);
    }

    // Método para obtener la lista de productos
    public static List<Producto> getProductos() {
        return productos;
    }
}