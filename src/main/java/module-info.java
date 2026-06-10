module com.github.luantenorio.projetocopatp1 {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires net.synedra.validatorfx;
    requires org.kordamp.bootstrapfx.core;
    requires java.desktop;
    requires jbcrypt;
    requires static org.jetbrains.annotations;
    requires jdk.hotspot.agent;

    opens com.github.luantenorio.projetocopatp1 to javafx.fxml;
    exports com.github.luantenorio.projetocopatp1;
    exports com.github.luantenorio.projetocopatp1.login;
    opens com.github.luantenorio.projetocopatp1.login to javafx.fxml;
    exports com.github.luantenorio.projetocopatp1.panel;
    opens com.github.luantenorio.projetocopatp1.panel to javafx.fxml;
    exports com.github.luantenorio.projetocopatp1.stadium;
    opens com.github.luantenorio.projetocopatp1.stadium to javafx.fxml;
    exports com.github.luantenorio.projetocopatp1.users;
    opens com.github.luantenorio.projetocopatp1.users to javafx.fxml;
    exports com.github.luantenorio.projetocopatp1.player;
    opens com.github.luantenorio.projetocopatp1.player to javafx.fxml;
    exports com.github.luantenorio.projetocopatp1.team;
    opens com.github.luantenorio.projetocopatp1.team to javafx.fxml;
    exports com.github.luantenorio.projetocopatp1.util;
    opens com.github.luantenorio.projetocopatp1.util to javafx.fxml;
    exports com.github.luantenorio.projetocopatp1.match;
    opens com.github.luantenorio.projetocopatp1.match to javafx.fxml;
    exports com.github.luantenorio.projetocopatp1.referee;
    opens com.github.luantenorio.projetocopatp1.referee to javafx.fxml;
    exports com.github.luantenorio.projetocopatp1.refereeMatch;
    opens com.github.luantenorio.projetocopatp1.refereeMatch to javafx.fxml;
}
