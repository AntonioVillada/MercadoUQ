package mercado.uq.model;

import java.util.ArrayList;
import java.util.List;

public class GestorCategoria {
    private static List<Categoria> categorias = new ArrayList<>();

    // Método para agregar una categoría a la lista
    public static void agregarCategoria(Categoria categoria) {
        categorias.add(categoria);
    }

    // Método para obtener la lista de categorías
    public static List<Categoria> getCategorias() {
        return categorias;
    }
}
