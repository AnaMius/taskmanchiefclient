package sample.controller;

import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.TilePane;
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
public class TileContainerController implements Initializable {

    @FXML
    private ScrollPane scrollPane;

    @FXML
    private TilePane tilePane;


    @Override
    public void initialize(URL location, ResourceBundle resources) {

        ObservableList list = tilePane.getChildren();

        tilePane.setHgap(5);
        tilePane.setVgap(5);

        String api = "http://localhost:8080/api/rest/task";
        Client client = ClientBuilder.newClient();
        Response response = client
                .target(api)
                .request(MediaType.APPLICATION_JSON)
                .get();
        List<TaskDTO> tasks = response.readEntity(new GenericType<List<TaskDTO>>() {
        });
       // System.out.println(tasks);
        tasks.forEach(t -> build(t, list));
    }

    private void build(TaskDTO task, ObservableList list) {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/sample/tile.fxml"));

        AnchorPane root = null;
        try {
            root = fxmlLoader.load();
        } catch (IOException e1) {
            e1.printStackTrace();
        }
        Random r = new Random();
        String s = (r.nextInt(89) + 10) + "" + (r.nextInt(89) + 10) + "" + (r.nextInt(89) + 10);
       // System.out.println(s);


        //root.setBackground(new Background(new BackgroundFill(Color.web("#" + s), CornerRadii.EMPTY, Insets.EMPTY)));
        TileController controller = fxmlLoader.getController();
        controller.getLabelStatus().setText(task.getStatus().getName());

        controller.getlClientName().setText(task.getClient().getName());
        controller.getlServiceDate().setText(dateToString(task.getServiceDate()));
        controller.getlEndingDate().setText(dateToString(task.getEndingDate()));
        controller.getlPriority().setText(task.getPriority());
        controller.getlServiceName().setText(task.getServiceType().getName());

        controller.getImgViiew().setImage(new Image(task.getPerson() == null ? "/img/user2.png" : "/img/user.png"));
        list.add(root);
    }

    private String dateToString(final Date date) {
        Instant instant = date.toInstant();
        LocalDateTime ldt = instant.atOffset(ZoneOffset.ofHours(3)).toLocalDateTime();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy HH:mm:ss", Locale.ENGLISH);
        return ldt.format(formatter);
    }
}
