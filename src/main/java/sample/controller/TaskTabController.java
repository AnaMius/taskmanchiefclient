package sample.controller;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;

import java.net.URL;
import java.util.ResourceBundle;

public class TaskTabController implements Initializable {
    @FXML
    GridPane tasksGridPane;

    public void initialize(URL location, ResourceBundle resources) {
        Button b;
        for (int i = 0; i < 16; i++) {
            for (int j = 0; j < 3; j++) {
                b = new Button("hello"+String.valueOf(i));
                b.setPrefHeight(60);
                b.setPrefWidth(60);
                b.setMinHeight(60);
                b.setMinWidth(60);
                tasksGridPane.add(b, j, i);
            }
        }
    }
}
