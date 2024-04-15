module mercado.uq {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.kordamp.bootstrapfx.core;

    opens mercado.uq to javafx.fxml;
    exports mercado.uq;

    opens mercado.uq.controller to javafx.fxml;
    exports mercado.uq.controller to javafx.graphics;

    opens mercado.uq.mainLight to javafx.fxml;
    exports mercado.uq.mainLight;

    opens mercado.uq.model to javafx.base;
    exports mercado.uq.model to javafx.graphics;


}