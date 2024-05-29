/**
 * The HelloController class controls the main UI of the application.
 */
package com.example.warehouse.presentationLayer;

import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;

import com.example.warehouse.businesslogicLayer.ClientBusiness;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.control.Button;

public class HelloController implements Initializable {

    @FXML
    private ImageView wImageView;
    @FXML
    private Button clientButton;
    @FXML
    private Button adminButton;

    private ClientBusiness clientBusiness;

    /**
     * Initializes the controller.
     *
     * @param url            The location used to resolve relative paths for the root object, or null if the location is not known.
     * @param resourceBundle The resources used to localize the root object, or null if the root object was not localized.
     */
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        File pic = new File("W/warehouse.png");
        Image startImage = new Image(pic.toURI().toString());
        this.wImageView.setImage(startImage);

        this.clientBusiness = new ClientBusiness();
    }

    /**
     * Handles the action when the client button is clicked.
     *
     * @param actionEvent The action event.
     */
    @FXML
    public void clientButtonOnAction(ActionEvent actionEvent) {
        clientBusiness.openthis();
    }

    /**
     * Handles the action when the admin button is clicked.
     *
     * @param actionEvent The action event.
     */
    @FXML
    public void adminButtonOnAction(ActionEvent actionEvent) {
        clientBusiness.openthat();
    }
}
