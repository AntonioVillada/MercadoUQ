package mercado.uq.facturacion;

import mercado.uq.model.Categoria;
import mercado.uq.model.Factura;
import mercado.uq.model.GestorCategoria;

import java.io.File;
import java.io.FileNotFoundException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class GestorFacturas {

    private static GestorFacturas instance;

    private List<Factura> listaFacturas;

    public GestorFacturas() {
        listaFacturas = new ArrayList<>();
    }

    public static synchronized GestorFacturas getInstance() {
        if (instance == null) {
            instance = new GestorFacturas();
        }
        return instance;
    }

    public void agregarFactura(Factura factura) {
        listaFacturas.add(factura);
    }

    public List<Factura> getListaFacturas() {
        return listaFacturas;
    }

    public Factura buscarFacturaId(int id) {
        for (Factura factura : listaFacturas) {
            if (factura.getNumeroDeFactura() == id) {
                return factura;
            }
        }
        return null;
    }

    public boolean existeFactura(int id) {
        for (Factura factura : listaFacturas) {
            if (factura.getNumeroDeFactura() == id) {
                return true;
            }
        }
        return false;
    }

    public int cantidadFacturas() {
        return listaFacturas.size();
    }


}
