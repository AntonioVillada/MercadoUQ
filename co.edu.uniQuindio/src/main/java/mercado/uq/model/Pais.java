package mercado.uq.model;

public class Pais {

    private int id;
    private String nombrePais;

    public Pais(int id, String nombrePais) {
        this.id = id;
        this.nombrePais = nombrePais;
    }

    public Pais() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombrePais() {
        return nombrePais;
    }

    public void setNombrePais(String nombrePais) {
        this.nombrePais = nombrePais;
    }
}

