package mercado.uq.model;

import java.util.ArrayList;
import java.util.List;

//Esta clase es para crear la Lista de productos que se va a usar en toda la APP
public class GestorProducto {

    //Unica instancia para esta clase.
    private static GestorProducto instance;

    //Se declara la lista de categorias
    private List<Producto> listaProductos;

    private GestorProducto() {
        listaProductos = new ArrayList<>();
    }

    public static synchronized GestorProducto getInstance() {
        if (instance == null) {
            instance = new GestorProducto();
        }
        return instance;
    }

    //Metodo para agregar un producto a la lista.
    public void agregarProducto(Producto producto) {
        listaProductos.add(producto);
    }

    //Metodo para obtener los productos
    public List<Producto> getListaProductos() {
        return listaProductos;
    }

    //Metodo para buscar en la lista un producto por ID
    public Producto buscarProductoPorId(int id) {
        for (Producto producto : listaProductos) {
            if (producto.getIdProducto() == id) {
                return producto;
            }
        }
        return null;
    }
}