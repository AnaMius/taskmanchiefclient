package sample.controller;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;

/**
 * @author <a href="mailto:maxim.simonenko@masterpayment.com"/>Maxim Simonenko.
 * @since 11.06.2017.
 */
public class TileController {

    @FXML
    private Label lPriority;

    @FXML
    private Label lEndingDate;

    @FXML
    private Label lClientName;

    @FXML
    private Label lServiceName;

    @FXML
    private Label lServiceDate;

    @FXML
    private ImageView ImgViiew;

    @FXML
    private Label labelStatus;

    @FXML
    private VBox container;

    public Label getlPriority() {
        return lPriority;
    }

    public void setlPriority(Label lPriority) {
        this.lPriority = lPriority;
    }

    public Label getlEndingDate() {
        return lEndingDate;
    }

    public void setlEndingDate(Label lEndingDate) {
        this.lEndingDate = lEndingDate;
    }

    public Label getlClientName() {
        return lClientName;
    }

    public void setlClientName(Label lClientName) {
        this.lClientName = lClientName;
    }

    public Label getlServiceName() {
        return lServiceName;
    }

    public void setlServiceName(Label lServiceName) {
        this.lServiceName = lServiceName;
    }

    public Label getlServiceDate() {
        return lServiceDate;
    }

    public void setlServiceDate(Label lServiceDate) {
        this.lServiceDate = lServiceDate;
    }

    public ImageView getImgViiew() {
        return ImgViiew;
    }

    public void setImgViiew(ImageView imgViiew) {
        ImgViiew = imgViiew;
    }

    public Label getLabelStatus() {
        return labelStatus;
    }

    public void setLabelStatus(Label labelStatus) {
        this.labelStatus = labelStatus;
    }

    public VBox getContainer() {
        return container;
    }

    public void setContainer(VBox container) {
        this.container = container;
    }
}
