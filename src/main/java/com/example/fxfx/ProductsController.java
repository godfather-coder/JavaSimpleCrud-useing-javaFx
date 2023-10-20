package com.example.fxfx;

import com.example.fxfx.Models.Pearson;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.stage.Stage;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class ProductsController implements Initializable {
    public static class HBoxCell extends HBox {
        Label label = new Label();
        Button button = new Button();
        Button edit = new Button();
        HBoxCell(Pearson p, String buttonText) {
            super();
            ProductsController pc=new ProductsController();
            label.setText(p.toString());
            label.setMaxWidth(Double.MAX_VALUE);
            HBox.setHgrow(label, Priority.ALWAYS);

            button.setText(buttonText);
            edit.setText("Edit");
            edit.setOnAction(
                    event -> {
                        try {
                            pc.editScene(event, p);
                        } catch (IOException e) {
                            throw new RuntimeException(e);
                        }
                    } );
            button.setOnAction(event -> {
                try {
                    p.delete();
                    FXMLLoader loader = new FXMLLoader(
                            getClass().getResource("Edit.fxml")
                    );
                    try {
                       Parent root = loader.load();
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                    SceneController sceneController = new SceneController();
                    sceneController.homeScene(event);
                } catch (SQLException | IOException e) {
                    System.out.println(e.getMessage());
                }

            });
            this.getChildren().addAll(label, button,edit);
        }
    }
    @FXML
    private ListView<HBoxCell> listView;
    private List<Pearson> lst = null;
    private Parent root;
    private Scene scene;
    private Stage stage;
    public void addScene(ActionEvent e) throws IOException {
        root = FXMLLoader.load(getClass().getResource("AddScene.fxml"));
        stage = (Stage) ((Node)e.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    public void editScene(ActionEvent e, Pearson p) throws IOException {
        FXMLLoader loader = new FXMLLoader(
                getClass().getResource("Edit.fxml")
        );
        root = loader.load();
        EditController editController = loader.getController();
        editController.setAttribute(p);
        stage = (Stage) ((Node)e.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    private void getPearsons(){
        try {
            lst = new ArrayList<>(Pearson.get());
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        getPearsons();
        List<HBoxCell> list = new ArrayList<>();
        for(Pearson p : lst){
            list.add(new HBoxCell(p, "Delete"));
        }
        listView.getItems().addAll(list);
    }
}
