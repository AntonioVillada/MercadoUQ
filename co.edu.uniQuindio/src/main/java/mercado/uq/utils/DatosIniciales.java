package mercado.uq.utils;

import mercado.uq.model.*;

import java.util.ArrayList;
import java.util.List;

//Clase donde creo DATOS QUEMADOS. Para tener clientes, productos y categorias en sus GESTORES.
//En esta clase cargamos inicialmente la info de los clientes registrados, los paises y la informacion de los productos con sus categorias.
public class DatosIniciales {

    public void inicializarDatos() {
        List<Categoria> categorias = crearCategorias();
        List<Cliente> clientes = crearClientes();
        List<Producto> productos = crearProductos(categorias);
        List<Pais> paises = crearPaises();

        // Añadiendo paises al gestor
        GestorPais gestorPaises = GestorPais.getInstance();
        for (Pais pais : paises) {
            gestorPaises.agregarPais(pais);
        }

        System.out.println("Se crearon correctamente los paises.");

        // Añadiendo categorías al gestor
        GestorCategoria gestorCategoria = GestorCategoria.getInstance();
        for (Categoria categoria : categorias) {
            gestorCategoria.agregarCategoria(categoria);
        }

        System.out.println("Se crearon correctamente las categorias.");

        // Añadiendo clientes al gestor
        GestorClientes gestorClientes = GestorClientes.getInstance();
        for (Cliente cliente : clientes) {
            gestorClientes.agregarCliente(cliente);
        }

        System.out.println("Se crearon correctamente los clientes.");

        // Añadiendo productos al gestor
        GestorProducto gestorProducto = GestorProducto.getInstance();
        for (Producto producto : productos) {
            gestorProducto.agregarProducto(producto);
        }

        System.out.println("Se crearon correctamente los productos.");
    }

    private List<Pais> crearPaises() {
        List<Pais> paises = new ArrayList<>();
        paises.add(new Pais(1, "Colombia"));
        paises.add(new Pais(2, "Argentina"));
        paises.add(new Pais(3, "Espania"));
        paises.add(new Pais(4, "Uruguay"));
        paises.add(new Pais(5, "Chile"));
        return paises;
    }

    public static List<Categoria> crearCategorias() {
        List<Categoria> categorias = new ArrayList<>();
        categorias.add(new Categoria(4, "Alimentos"));
        categorias.add(new Categoria(3, "Tecnologia"));
        categorias.add(new Categoria(2, "Electrodomesticos."));
        categorias.add(new Categoria(1, "Cosmeticos"));
        return categorias;
    }

    public static List<Cliente> crearClientes() {
        List<Cliente> clientes = new ArrayList<>();
        clientes.add(new Cliente(1, "Juan", "Pérez", "juan@example.com", "123456789", true));
        clientes.add(new Cliente(2, "María", "García", "maria@example.com", "987654321", false));
        clientes.add(new Cliente(3, "Pedro", "Gómez", "pedro@example.com", "456123789", true));
        clientes.add(new Cliente(4, "Ana", "Martínez", "ana@example.com", "789123456", false));
        clientes.add(new Cliente(5, "Sofía", "López", "sofia@example.com", "321654987", true));
        return clientes;
    }

    public static List<Producto> crearProductos(List<Categoria> categorias) {
        List<Producto> productos = new ArrayList<>();
        productos.add(new Producto(1, categorias.get(0), 10.50, 100, 0.5, "Pequeño", "Leche", "Leche fresca pasteurizada"));
        productos.add(new Producto(2, categorias.get(0), 2.50, 200, 0.3, "Pequeño", "Pan", "Pan integral recién horneado"));
        productos.add(new Producto(3, categorias.get(0), 3.00, 150, 0.4, "Pequeño", "Huevos", "Huevos orgánicos de gallinas felices"));
        productos.add(new Producto(4, categorias.get(1), 499.99, 50, 0.2, "Pequeño", "Smartphone", "Teléfono inteligente con última tecnología"));
        productos.add(new Producto(5, categorias.get(1), 99.99, 100, 0.1, "Pequeño", "Auriculares", "Auriculares inalámbricos de alta calidad"));
        productos.add(new Producto(6, categorias.get(2), 799.99, 30, 20.0, "Grande", "Refrigeradora", "Refrigeradora con dispensador de agua y hielo"));
        productos.add(new Producto(7, categorias.get(2), 49.99, 80, 3.0, "Pequeño", "Licuadora", "Licuadora de alta potencia para smoothies"));
        productos.add(new Producto(8, categorias.get(3), 15.00, 200, 0.1, "Pequeño", "Crema facial", "Crema hidratante con SPF 30"));
        productos.add(new Producto(9, categorias.get(3), 20.00, 150, 0.1, "Pequeño", "Maquillaje", "Base de maquillaje de larga duración"));
        productos.add(new Producto(10, categorias.get(3), 30.00, 100, 0.2, "Pequeño", "Perfume", "Fragancia floral con notas de jazmín"));
        return productos;
    }
}
