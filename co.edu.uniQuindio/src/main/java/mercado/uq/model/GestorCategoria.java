package mercado.uq.model;

import java.util.ArrayList;
import java.util.List;

//Esta clase es para crear la Lista de categorias que se va a usar en toda la APP
public class GestorCategoria {

    //Unica instancia para esta clase.
    private static GestorCategoria instance;

    //Se declara la lista de categorias
    private List<Categoria> listaCategorias = new ArrayList<>();

    private GestorCategoria() {
        listaCategorias = new ArrayList<>();
    }

    public static synchronized GestorCategoria getInstance() {
        if (instance == null) {
            instance = new GestorCategoria();
        }
        return instance;
    }

    // Método para agregar una categoría a la lista
    public void agregarCategoria(Categoria categoria) {
        listaCategorias.add(categoria);
    }

    // Método para obtener la lista de categorías
    public List<Categoria> getListaCategorias() {
        return listaCategorias;
    }

    //Buscamos en la lista la categoria por ID
    public Categoria buscarCategoriaPorId(int id) {
        for (Categoria categoria : listaCategorias) {
            if (categoria.getIdCategoria() == id) {
                return categoria;
            }
        }
        return null;
    }
}
