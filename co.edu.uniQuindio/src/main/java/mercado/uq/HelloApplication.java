package mercado.uq;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import mercado.uq.main.Main;
import mercado.uq.model.Categoria;
import mercado.uq.model.Cliente;
import mercado.uq.model.Producto;
import mercado.uq.utils.DatosIniciales;

import java.io.IOException;
import java.util.List;

public class HelloApplication extends Application {


    @Override
    public void start(Stage stage) throws IOException {

        DatosIniciales newData = new DatosIniciales();
        newData.inicializarDatos();

        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("PanelPrincipal.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 640, 480);
        stage.setTitle("Panel Principal!");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        Main.launchApp(args);
    }
}