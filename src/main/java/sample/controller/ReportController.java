package sample.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;

public class ReportController implements Initializable {
    @FXML
    DatePicker date1;
    @FXML
    DatePicker date2;
    @FXML
    ComboBox<String> comboBox;
    @FXML
    ImageView image;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        date1.setValue(LocalDate.now());
        date2.setValue(LocalDate.now());
        ObservableList<String> list = FXCollections.observableArrayList();
        list.add("Министерство образования и науки ДНР");
        comboBox.setItems(list);
//        comboBox.setValue(list.get(0));
//        image.setImage(new Image("/img/report.png"));
    }
}
