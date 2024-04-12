module mercado.uq {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.kordamp.bootstrapfx.core;

    opens mercado.uq to javafx.fxml;
    exports mercado.uq;


}