package mercado.uq.mainLight;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import mercado.uq.main.Main;

import java.io.IOException;

public class ClienteMainLight extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(ClienteMainLight.class.getResource("RegistrarClienteView.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 320, 240);
        stage.setTitle("Cliente!");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        Main.launchApp(args);
    }
}
