package sample.controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import sample.controller.dto.PersonDTO;
import sample.controller.dto.TaskDTO;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.ResourceBundle;


public class TaskTabController implements Initializable {
    @FXML
    VBox verticalBox;

    @FXML
    DatePicker beginDatePicker;

    @FXML
    DatePicker endDatePicker;

    @FXML
    TextField beginHoursTextField;

    @FXML
    TextField beginMinutesTextField;

    @FXML
    TextField endHoursTextField;

    @FXML
    TextField endMinutesTextField;

    @FXML
    VBox personsVBox;

    @FXML
    Button saveBtn;

    private List<TaskDTO> tasks;

    public void initialize(URL location, ResourceBundle resources) {
        setDefaultPeriodParams();
        setDynamicPeriodChoice();
        initSaveBtn();
//        showTasks(getTaskListByPeriod());
//        System.out.println(tasks);
//        tileContainerController.setTasksList(tasks);
//        tileContainerController.initialize(location,resources);
//        Button b;
//        for (int i = 0; i < 16; i++) {
//            for (int j = 0; j < 3; j++) {
//                b = new Button("hello" + String.valueOf(i));
//                b.setPrefHeight(60);
//                b.setPrefWidth(60);
//                b.setMinHeight(60);
//                b.setMinWidth(60);
//                b.setOnMouseClicked((MouseEvent e) -> {
//                    String api = "http://91.241.186.117/api/rest/task_controller/persons_by_task/1";
//                    String api2 = "http://localhost:8080/api/rest/task_controller/save";
//                    String api3 = "http://localhost:8080/api/rest/task_controller/tasks_by_person/1";
//
//                    /*
//                        Запрашиваем данные
//                        немного не красиво, но для примера сойдет.
//                     */
//                    List<TaskDTO> taskByPerson = new ArrayList<>();
//                    taskByPerson = doGET(api3, taskByPerson.getClass());
//                    System.out.println(taskByPerson);
//                    System.out.println();
//                    System.out.println("========");
//                    System.out.println();
//
//                    /*
//                        делаем пост этих данных как List
//                     */
//                    Client client = ClientBuilder.newClient();
//                    Response response = client
//                            .target(api2)
//                            .request(MediaType.APPLICATION_JSON)
//                            .post(Entity.entity(taskByPerson, "application/json; charset=UTF-8"));
//                    List<TaskDTO> list = response.readEntity(new GenericType<List<TaskDTO>>() {
//                    });
//                    System.out.println(list);
//                    System.out.println();
//                    System.out.println("========");
//                    System.out.println();
//
//                    /*
//                    сделал generic который делает GET
//                     */
//                    List<PersonDTO> list1 = new ArrayList<>();
//                    System.out.println(doGET(api, list1.getClass()));
//                    System.out.println();
//                    System.out.println("========");
//                    System.out.println();
//
//                    /*
//                    тот же дженерик, но для получения одного объекта, а не списка
//                     */
//
//                    TaskDTO task = doGET("http://localhost:8080/api/rest/task/1", TaskDTO.class);
//                    System.out.println("TASK: " + task);
//                    System.out.println();
//                    System.out.println("========");
//                    System.out.println();
//                });
//                tasksGridPane.add(b, j, i);
//            }
//        }
    }

    private void initSaveBtn() {
        saveBtn.setOnAction(event -> {
            String api2 = "http://localhost:8080/api/rest/task_controller/save";
            Client client = ClientBuilder.newClient();
            Response response = client
                    .target(api2)
                    .request(MediaType.APPLICATION_JSON)
                    .post(Entity.entity(tasks, "application/json; charset=UTF-8"));
            List<TaskDTO> tasks2 = response.readEntity(new GenericType<List<TaskDTO>>() {
            });
        });
    }

    private List<TaskDTO> getTaskListByPeriod() {
        String api = "http://localhost:8080/api/rest/task_controller/tasks_by_period/"+parsePeriod()+"/";
        System.out.println(api);
        Client client = ClientBuilder.newClient();
        Response response = client
                .target(api)
                .request(MediaType.APPLICATION_JSON)
                .get();
        tasks = response.readEntity(new GenericType<List<TaskDTO>>() {});
        return tasks;
    }

    private void showTasks(List<TaskDTO> list) {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/sample/tileContainer.fxml"));
        ScrollPane root = null;
        try {
            root = fxmlLoader.load();
        } catch (IOException e1) {
            e1.printStackTrace();
        }
        TileContainerController tileContainerController = fxmlLoader.getController();
        tileContainerController.setTasksList(list);
        tileContainerController.addTasks(personsVBox);
        if (verticalBox.getChildren().size() > 1) {
            for (int i = verticalBox.getChildren().size(); i > 1; i--) {
                verticalBox.getChildren().remove(i);
            }
        }
        verticalBox.getChildren().add(root);
    }

    private void setDefaultPeriodParams() {
        beginDatePicker.setValue(LocalDate.now());
        endDatePicker.setValue(LocalDate.now());
        beginHoursTextField.setText("08");
        beginMinutesTextField.setText("00");
        endHoursTextField.setText("17");
        endMinutesTextField.setText("00");
    }

    private String parsePeriod() {
        String string = "";
        string += beginDatePicker.getValue().format(DateTimeFormatter.ofPattern("ddMMyyyy"))
                + beginHoursTextField.getText() + beginMinutesTextField.getText() + "/"
                + endDatePicker.getValue().format(DateTimeFormatter.ofPattern("ddMMyyyy"))
                + endHoursTextField.getText() + endMinutesTextField.getText();
        return string;
    }

    private void setDynamicPeriodChoice() {
        beginDatePicker.setOnAction(e -> {
            showTasks(getTaskListByPeriod());
        });
        beginHoursTextField.setOnAction(e -> {
            showTasks(getTaskListByPeriod());
        });
        beginMinutesTextField.setOnAction(e -> {
            showTasks(getTaskListByPeriod());
        });
        endDatePicker.setOnAction(e -> {
            showTasks(getTaskListByPeriod());
        });
        endHoursTextField.setOnAction(e -> {
            showTasks(getTaskListByPeriod());
        });
        endMinutesTextField.setOnAction(e -> {
            showTasks(getTaskListByPeriod());
        });
    }

    private <T> T doGET(String path, final Class<T> tClass) {
        /*
           Client client = ClientBuilder.newClient();
           Response response = client
                   .target(api)
                   .request(MediaType.APPLICATION_JSON)
                   .get();
           List<PersonDTO> list = response.readEntity(new GenericType<List<PersonDTO>>() {
           });
         */
        Client client = ClientBuilder.newClient();
        Response response = client
                .target(path)
                .request(MediaType.APPLICATION_JSON)
                .get();
        return response.readEntity(tClass);
    }
}
