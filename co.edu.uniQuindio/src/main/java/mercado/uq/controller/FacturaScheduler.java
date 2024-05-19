package mercado.uq.controller;

import mercado.uq.model.Factura;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class FacturaScheduler {
    private final GestorFacturasController controller;
    private int lastReadFileIndex = 0;
    private final List<Factura> nuevasFacturas = new ArrayList<>();

    public FacturaScheduler(GestorFacturasController controller) {
        this.controller = controller;
    }

    public void start() {
        ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);
        scheduler.scheduleAtFixedRate(this::loadNewFacturas, 0, 5, TimeUnit.MINUTES);
    }

    private void loadNewFacturas() {
        File directory = new File("C:\\Proyecto\\txt\\");
        File[] files = directory.listFiles((dir, name) -> name.matches("\\d+\\.factura.*"));

        if (files == null) return;

        // Sort files by numeric order
        Arrays.sort(files, (f1, f2) -> {
            int n1 = Integer.parseInt(f1.getName().split("\\.")[0]);
            int n2 = Integer.parseInt(f2.getName().split("\\.")[0]);
            return Integer.compare(n1, n2);
        });

        for (File file : files) {
            int fileIndex = Integer.parseInt(file.getName().split("\\.")[0]);
            if (fileIndex > lastReadFileIndex) {
                System.out.println("Loading new file: " + file.getName());
                List<Factura> nuevas = controller.cargarFacturasCSV(file.getPath());
                synchronized (nuevasFacturas) {
                    nuevasFacturas.addAll(nuevas);
                }
                lastReadFileIndex = fileIndex;
            }
        }
    }

    public List<Factura> getNuevasFacturas() {
        synchronized (nuevasFacturas) {
            List<Factura> facturas = new ArrayList<>(nuevasFacturas);
            nuevasFacturas.clear();
            return facturas;
        }
    }
}
