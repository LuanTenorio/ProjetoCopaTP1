package com.github.luantenorio.projetocopatp1;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("view/panel.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 3000, 3000);
        stage.setTitle("Login");
        stage.setScene(scene);
        stage.show();
    }
}
