package sample.controller;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import sample.controller.dto.PersonDTO;
import sample.controller.dto.TaskDTO;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;


public class TaskTabController implements Initializable {
    @FXML
    GridPane tasksGridPane;

    public void initialize(URL location, ResourceBundle resources) {
        Button b;
        for (int i = 0; i < 16; i++) {
            for (int j = 0; j < 3; j++) {
                b = new Button("hello" + String.valueOf(i));
                b.setPrefHeight(60);
                b.setPrefWidth(60);
                b.setMinHeight(60);
                b.setMinWidth(60);
                b.setOnMouseClicked((MouseEvent e) -> {
                    String api = "http://localhost:8080/api/rest/task_controller/persons_by_task/1";
                    String api2 = "http://localhost:8080/api/rest/task_controller/save";
                    String api3 = "http://localhost:8080/api/rest/task_controller/tasks_by_person/1";

                    /*
                        Запрашиваем данные
                        немного не красиво, но для примера сойдет.
                     */
                    List<TaskDTO> taskByPerson = new ArrayList<>();
                    taskByPerson = doGET(api3, taskByPerson.getClass());
                    System.out.println(taskByPerson);
                    System.out.println();
                    System.out.println("========");
                    System.out.println();

                    /*
                        делаем пост этих данных как List
                     */
                    Client client = ClientBuilder.newClient();
                    Response response = client
                            .target(api2)
                            .request(MediaType.APPLICATION_JSON)
                            //.header("Content-Type", "application/json; charset=utf-8")
                            .post(Entity.entity(taskByPerson, "application/json; charset=UTF-8"));
                    List<TaskDTO> list = response.readEntity(new GenericType<List<TaskDTO>>() {
                    });
                    System.out.println(list);
                    System.out.println();
                    System.out.println("========");
                    System.out.println();

                    /*
                    сделал generic который делает GET
                     */
                    List<PersonDTO> list1 = new ArrayList<>();
                    System.out.println(doGET(api, list1.getClass()));
                    System.out.println();
                    System.out.println("========");
                    System.out.println();

                    /*
                    тот же дженерик, но для получения одного объекта, а не списка
                     */

                    TaskDTO task = doGET("http://localhost:8080/api/rest/task/1", TaskDTO.class);
                    System.out.println("TASK: " + task);
                    System.out.println();
                    System.out.println("========");
                    System.out.println();
                });
                tasksGridPane.add(b, j, i);
            }
        }
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
