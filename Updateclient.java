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
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;


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
    public void initialize(URL url, ResourceBundle resourceBundle) {
        File file = new File("update/update.jpg");
        Image image = new Image(file.toURI().toString());
        this.updateImageView.setImage(image);
        this.clientDataBase = new ClientDataBase();
    }

    public void upButtonOnAction(ActionEvent actionEvent) {
        String oldUsername = oldTextField.getText();
        String newUsername = introducenameTextField.getText();
        String newPassword = introducepasswordTextField.getText();

        ClientModel clientModel = new ClientModel(newUsername, newPassword);

        clientDataBase.updateUser(oldUsername, clientModel);
    }
}
