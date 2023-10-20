package com.example.fxfx;

import com.example.fxfx.Models.Pearson;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;


public class EditController {
    @FXML
    private TextField firstName;
    @FXML
    private TextField lastName;
    @FXML
    private TextField age;
    @FXML
    private ChoiceBox<String> gender;
    private int  id ;
    private Parent root;

    public void setAttribute(Pearson p){
        this.id = p.getId();
        firstName.setText(p.getFirstName());
        lastName.setText(p.getLastName());
        age.setText(String.valueOf(p.getAge()));
        gender.setValue(p.getGender());
    }
    public void update(ActionEvent e){
        Pearson pearson = new Pearson(
                id,
                firstName.getText(),
                lastName.getText(),
                Integer.parseInt(age.getText()),
                gender.getValue()
        );
        try {
            pearson.update();
            FXMLLoader loader = new FXMLLoader(
                    getClass().getResource("Edit.fxml")
            );
            root = loader.load();
           SceneController sceneController = new SceneController();
           sceneController.homeScene(e);
        }catch (Exception ex){
            System.out.println("gaasxa");
        }
    }

}
