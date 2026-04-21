module com.github.luantenorio.projetocopatp1 {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires net.synedra.validatorfx;
    requires org.kordamp.bootstrapfx.core;

    opens com.github.luantenorio.projetocopatp1 to javafx.fxml;
    exports com.github.luantenorio.projetocopatp1;
}