package sample.controller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;

public class PersonController {
    @FXML
    private HBox container;
    @FXML
    private Label surname;
    @FXML
    private Label name;
    @FXML
    private Label patronymic;
    @FXML
    private Button assignBtn;
    @FXML
    private Button removeBtn;

    public Button getRemoveBtn() {
        return removeBtn;
    }

    public void setRemoveBtn(Button removeBtn) {
        this.removeBtn = removeBtn;
    }

    public HBox getContainer() {
        return container;
    }

    public void setContainer(HBox container) {
        this.container = container;
    }

    public Label getSurname() {
        return surname;
    }

    public void setSurname(Label surname) {
        this.surname = surname;
    }

    public Label getName() {
        return name;
    }

    public void setName(Label name) {
        this.name = name;
    }

    public Label getPatronymic() {
        return patronymic;
    }

    public void setPatronymic(Label patronymic) {
        this.patronymic = patronymic;
    }

    public Button getAssignBtn() {
        return assignBtn;
    }

    public void setAssignBtn(Button assignBtn) {
        this.assignBtn = assignBtn;
    }
}
