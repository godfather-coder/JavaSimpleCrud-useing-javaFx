package com.example.fxfx;

import com.example.fxfx.Models.Pearson;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;
import java.io.IOException;
import java.sql.SQLException;

public class SceneController{
    @FXML
    private TextField firstName;
    @FXML
    private TextField lastName;
    @FXML
    private TextField age;
    @FXML
    private ChoiceBox<String> gender;
    private Parent root;
    private Scene scene;
    private Stage stage;
    public void homeScene(ActionEvent e) throws IOException, SQLException {
        root = FXMLLoader.load(getClass().getResource("ProductsScene.fxml"));
        stage = (Stage) ((Node)e.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    public void clear(){
        firstName.clear();
        lastName.clear();
        age.clear();
        gender.valueProperty().set(null);
    }
    public void saveData(ActionEvent e){
        Pearson pearson = new Pearson(
                firstName.getText(),
                lastName.getText(),
                Integer.parseInt(age.getText()),
                gender.getValue()
        );
        try {
            pearson.create();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());;
        } finally {
            clear();
        }
    }

}
