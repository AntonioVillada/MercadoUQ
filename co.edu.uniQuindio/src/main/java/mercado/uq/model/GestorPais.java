package mercado.uq.model;

import java.util.ArrayList;
import java.util.List;

public class GestorPais {
    //Unica instancia para esta clase.
    private static GestorPais instance;

    //Se declara la lista de paises
    private List<Pais> listaPaises = new ArrayList<>();

    public GestorPais() {
        listaPaises = new ArrayList<>();
    }

    public static synchronized GestorPais getInstance() {
        if (instance == null) {
            instance = new GestorPais();
        }
        return instance;
    }

    // Método para agregar un pais a la lista
    public void agregarPais(Pais pais) {
        listaPaises.add(pais);
    }

    // Método para obtener la lista de paises
    public List<Pais> getListaPaises() {
        return listaPaises;
    }

    //Buscamos en la lista el pais por ID
    public Pais buscarPaisId(int id) {
        for (Pais pais : listaPaises) {
            if (pais.getId() == id) {
                return pais;
            }
        }
        return null;
    }

    //Buscamos en la lista la Pais por nombre
    public Pais buscarPaisNombre(String nombrePais) {
        for (Pais pais : listaPaises) {
            if (pais.getNombrePais().equalsIgnoreCase(nombrePais)) {
                return pais;
            }
        }
        return null;
    }
}
