/**
 * The Deleteclient class controls the UI for deleting a client.
 */
package com.example.warehouse.presentationLayer;

import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;

import com.example.warehouse.databaseLayer.ClientDataBase;
import com.example.warehouse.modelLayer.ClientModel;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

public class Deleteclient implements Initializable {

    @FXML
    private ImageView sadImageView;
    @FXML
    private TextField nTextField;
    @FXML
    private TextField pTextField;
    @FXML
    private TextField deleteButton;

    private ClientDataBase clientDataBase;

    /**
     * Initializes the controller.
     *
     * @param url            The location used to resolve relative paths for the root object, or null if the location is not known.
     * @param resourceBundle The resources used to localize the root object, or null if the root object was not localized.
     */
    public void initialize(URL url, ResourceBundle resourceBundle) {
        File file = new File("sad/sad.jpg");
        Image image = new Image(file.toURI().toString());
        this.sadImageView.setImage(image);
        this.clientDataBase = new ClientDataBase();
    }

    /**
     * Handles the action when the delete button is clicked.
     *
     * @param actionEvent The action event.
     */
    public void deletedButtonOnAction(ActionEvent actionEvent) {
        String username = nTextField.getText();
        String password = pTextField.getText();
        ClientModel clientToDelete = new ClientModel(username, password);
        clientDataBase.deleteUser(clientToDelete);
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/com/example/warehouse/hello-view.fxml"));
            Scene scene = new Scene(fxmlLoader.load(), 611.0, 388.0);
            Stage newStage = new Stage();
            newStage.setTitle("Admin Page");
            newStage.setScene(scene);
            newStage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
