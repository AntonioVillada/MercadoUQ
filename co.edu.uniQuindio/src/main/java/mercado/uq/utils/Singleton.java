package mercado.uq.utils;

public class Singleton {

    private static volatile Singleton instance;  // volatile para prevenir problemas de visibilidad
    public String value;

    private Singleton(String value) {
        try {
            Thread.sleep(1000);  // Simula la inicialización lenta
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
        this.value = value;
    }

    public static Singleton getInstance(String value) {
        if (instance == null) {
            synchronized (Singleton.class) {
                if (instance == null) {
                    instance = new Singleton(value);
                }
            }
        }
        return instance;
    }
}

