package mercado.uq.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
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
    private void handleCargarFactura(ActionEvent event) {
        try {
            // Carga la vista 'CargarFacturasView.fxml' desde la clase principal 'HelloApplication'
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("CargarFacturasView.fxml"));
            Parent root = fxmlLoader.load();

            // Obtiene el escenario (Stage) actual a través del evento del botón o control
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();

            // Establece la nueva escena en el escenario actual
            Scene scene = stage.getScene();
            scene.setRoot(root);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @FXML
    private void EncolarPremio(ActionEvent event) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("EncolarPremioView.fxml"));
            Parent root = fxmlLoader.load();

            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            Scene scene = stage.getScene();
            scene.setRoot(root);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @FXML
    private void Generarpremio(ActionEvent event) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("GenerarpremioView.fxml"));
            Parent root = fxmlLoader.load();

            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            Scene scene = stage.getScene();
            scene.setRoot(root);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}

