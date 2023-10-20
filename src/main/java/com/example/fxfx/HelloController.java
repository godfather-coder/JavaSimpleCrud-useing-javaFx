package com.example.fxfx;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.shape.Circle;

public class HelloController {
    @FXML
    private Circle circle ;
    private double x;
    private double y;

    public void onHelloButtonClick(){
        System.out.println("ds");
    }
    public void up(ActionEvent e){
        circle.setCenterY(y-=10);
    }
    public void down(ActionEvent e){
        circle.setCenterY(y+=10);
    }
    public void left(ActionEvent e){
        circle.setCenterX(x-=10);    }
    public void right(ActionEvent e){
        circle.setCenterX(x+=10);
    }

}