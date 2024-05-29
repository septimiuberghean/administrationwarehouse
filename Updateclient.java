/**
 * The Updateclient class controls the UI for updating client information.
 */
package com.example.warehouse.presentationLayer;

import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;

import com.example.warehouse.databaseLayer.ClientDataBase;
import com.example.warehouse.modelLayer.ClientModel;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Updateclient implements Initializable {

    @FXML
    private ImageView updateImageView;
    @FXML
    private TextField introducenameTextField;
    @FXML
    private TextField oldTextField;
    @FXML
    private TextField introducepasswordTextField;
    @FXML
    private Button upButton;

    private ClientDataBase clientDataBase;

    /**
     * Initializes the controller.
     *
     * @param url            The location used to resolve relative paths for the root object, or null if the location is not known.
     * @param resourceBundle The resources used to localize the root object, or null if the root object was not localized.
     */
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        File file = new File("update/update.jpg");
        Image image = new Image(file.toURI().toString());
        this.updateImageView.setImage(image);
        this.clientDataBase = new ClientDataBase();
    }

    /**
     * Handles the action when the update button is clicked.
     *
     * @param actionEvent The action event.
     */
    public void upButtonOnAction(ActionEvent actionEvent) {
        String oldUsername = oldTextField.getText();
        String newUsername = introducenameTextField.getText();
        String newPassword = introducepasswordTextField.getText();
        ClientModel clientModel = new ClientModel(newUsername, newPassword);
        clientDataBase.updateUser(oldUsername, clientModel);
    }
}
