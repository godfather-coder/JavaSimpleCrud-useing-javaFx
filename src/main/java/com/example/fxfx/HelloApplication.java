package com.example.fxfx;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {

        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("AddScene.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), Color.LIGHTSKYBLUE);
        stage.setScene(scene);
        stage.setTitle("CRUD VIA GODFATHER");
        Image icon = new Image("http://t1.gstatic.com/licensed-image?q=tbn:ANd9GcRs1x98b7mpfDH7X7oC2mEKVZmbB9cYNii47WG0PHXAUrW4COQRfgS2iT1bGikWATVyzfOrqEV0q3Q3n5NLZBs");

        stage.getIcons().add(icon);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}