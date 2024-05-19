package mercado.uq.controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import mercado.uq.HelloApplication;

import java.io.IOException;

public class PanelPrincipalController {


   // Image logo = new Image("file:mercado.uq.docs.Logo.png");

    //ImageView logoView = new ImageView(logo);

    @FXML
    private void handleCargarFactura() {
        try {
            // Carga la vista 'CargarFacturasView.fxml' desde la clase principal 'HelloApplication'
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("CargarFacturasView.fxml"));
            Parent root = fxmlLoader.load();

            // Crea un nuevo escenario (Stage) y escena (Scene) para mostrar la vista cargada
            Stage stage = new Stage();
            stage.setTitle("Cargar Factura");
            stage.setScene(new Scene(root));
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
