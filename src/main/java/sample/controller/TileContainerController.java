package sample.controller;

import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.TilePane;
import javafx.scene.layout.VBox;
import sample.controller.dto.PersonDTO;
import sample.controller.dto.StatusDTO;
import sample.controller.dto.TaskDTO;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.io.IOException;
import java.net.URL;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.util.*;

/**
 * @author <a href="mailto:maxim.simonenko@masterpayment.com"/>Maxim Simonenko.
 * @since 11.06.2017.
 */
public class TileContainerController {

    @FXML
    private ScrollPane scrollPane;

    @FXML
    private TilePane tilePane;

    private List<TaskDTO> list;

    public Node getNode(TaskDTO task, VBox personsVBox){
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/sample/tile.fxml"));
        VBox root = null;
        try {
            root = fxmlLoader.load();
        } catch (IOException e1) {
            e1.printStackTrace();
        }

        TileController controller = fxmlLoader.getController();
        controller.getLabelStatus().setText(task.getStatus().getName());
        controller.getlClientName().setText(task.getClient().getName());
        controller.getlServiceDate().setText(dateToString(task.getServiceDate()));
        controller.getlEndingDate().setText(dateToString(task.getEndingDate()));
        controller.getlPriority().setText(task.getPriority());
        controller.getlServiceName().setText(task.getServiceType().getName());
        controller.getImgViiew().setImage(new Image(task.getPerson() == null ? "/img/user2.png" : "/img/user.png"));
        controller.getContainer().setOnMouseClicked(e -> {
            controller.getContainer().setStyle("-fx-background-color: antiquewhite");
            if(!personsVBox.getChildren().isEmpty()) {
                personsVBox.getChildren().clear();
            }
            String api = "http://localhost:8080/api/rest/task_controller/persons_by_task/"+task.getId();
            Client client = ClientBuilder.newClient();
            Response response = client
                    .target(api)
                    .request(MediaType.APPLICATION_JSON)
                    .get();
            List<PersonDTO> list1 = response.readEntity(new GenericType<List<PersonDTO>>() {});
            System.out.println(list1);
            for (PersonDTO person : list1) {
                FXMLLoader fxmlLoaderPerson = new FXMLLoader(getClass().getResource("/sample/person.fxml"));
                HBox personRoot = null;
                try {
                    personRoot = fxmlLoaderPerson.load();
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
                PersonController personController = fxmlLoaderPerson.getController();
                personController.getSurname().setText(person.getSurname());
                personController.getName().setText(person.getName());
                personController.getPatronymic().setText(person.getPatronymic());
                if(task.getPerson() != null && task.getPerson().equals(person)) {
                    personController.getContainer().setStyle("-fx-background-color: #FFA07A");
                }
                else {
                    personController.getContainer().setStyle("-fx-background-color: #86A47C");
                }
                personController.getAssignBtn().setOnAction(event -> {
                    if(task.getPerson() != null) return;
                    personController.getContainer().setStyle("-fx-background-color: #FFA07A");
                    task.setPerson(person);
                    StatusDTO status = new StatusDTO();
                    status.setId(2);
                    status.setName("сформирована");
                    task.setStatus(status);
                    controller.getLabelStatus().setText(task.getStatus().getName());
                    controller.getImgViiew().setImage(new Image("/img/user.png"));
                });
                personController.getRemoveBtn().setOnAction(event -> {
                    if(task.getPerson() == null) return;
                    personController.getContainer().setStyle("-fx-background-color: #86A47C");
                    task.setPerson(null);
                    StatusDTO status = new StatusDTO();
                    status.setId(1);
                    status.setName("открыта");
                    task.setStatus(status);
                    controller.getLabelStatus().setText(task.getStatus().getName());
                    controller.getImgViiew().setImage(new Image("/img/user2.png"));
                });
                personsVBox.getChildren().add(personRoot);
            }
        });
        controller.getContainer().setOnMouseExited(event -> {
            controller.getContainer().setStyle("-fx-background-color: #cbe3fb");
        });
        return root;
    }

    public void update(List<TaskDTO> list, TaskDTO task, VBox personsVBox) {
        int index = list.indexOf(task);
        tilePane.getChildren().set(index, getNode(task, personsVBox));
    }

    public List<TaskDTO> getTasksList() {
        return list;
    }

    public void setTasksList(List<TaskDTO> list) {
        this.list = list;
    }

    public void addTasks(VBox personsVBox) {
        tilePane.setHgap(5);
        tilePane.setVgap(5);
        tilePane.getChildren().clear();
        for (TaskDTO task : this.list) {
            tilePane.getChildren().add(getNode(task, personsVBox));
        }
    }

    private String dateToString(final Date date) {
        Instant instant = date.toInstant();
        LocalDateTime ldt = instant.atOffset(ZoneOffset.ofHours(3)).toLocalDateTime();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm", Locale.ENGLISH);
        return ldt.format(formatter);
    }
}
