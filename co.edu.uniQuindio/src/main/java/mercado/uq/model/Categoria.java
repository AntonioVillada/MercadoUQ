package mercado.uq.model;

import java.util.List;

public class Categoria {

    private int idCategoria;
    private String nombreCategoria;

    public Categoria(int idCategoria, String nombreCategoria) {
        this.idCategoria = idCategoria;
        this.nombreCategoria = nombreCategoria;
    }

    public Categoria() {
    }

    public int getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(int idCategoria) {
        this.idCategoria = idCategoria;
    }

    public String getNombreCategoria() {
        return nombreCategoria;
    }

    public void setNombreCategoria(String nombreCategoria) {
        this.nombreCategoria = nombreCategoria;
    }

    public static Categoria buscarCategoriaPorId(int id) {
        // Supongamos que tienes una lista estática de categorías en alguna clase de gestión
        List<Categoria> categorias = GestorCategoria.getCategorias(); // Obtenemos la lista de categorías
        for (Categoria categoria : categorias) {
            if (categoria.getIdCategoria() == id) {
                return categoria;
            }
        }
        return null; // Si no se encuentra la categoría con el ID especificado
    }
}
