package mercado.uq.facturacion;

import mercado.uq.model.Factura;
import java.io.File;
import java.io.FileNotFoundException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class GestorFacturas {
    // Método para cargar facturas desde un archivo CSV
    public List<Factura> cargarFacturasCSV(String rutaArchivo) {
        List<Factura> facturas = new ArrayList<>();

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
                // Crear un nuevo objeto Factura con los campos y agregarlo a la lista de facturas
                Factura factura = new Factura();
                factura.setNumeroDeFactura(Integer.parseInt(campos[0]));
                factura.setValorTotal(Double.parseDouble(campos[1]));
                factura.setFechaDeEmision(parseDate(campos[2]));
                // Ajustar la lógica para cargar productos, cliente y otros atributos según sea necesario
                facturas.add(factura);
            }
            System.out.println("Facturas cargadas desde el archivo CSV.");
        } catch (FileNotFoundException e) {
            System.out.println("Error: Archivo CSV no encontrado.");
            e.printStackTrace();
        }

        return facturas;
    }

    // convierte la cadena de fecha en un objeto Date
    private Date parseDate(String dateString) {
        try {
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
            return dateFormat.parse(dateString);
        } catch (ParseException e) {
            System.out.println("Error al convertir la fecha: " + dateString);
            e.printStackTrace();
            return null;
        }
    }
}
