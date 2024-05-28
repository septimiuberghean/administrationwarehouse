package com.example.warehouse.presentationLayer;
import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;
import com.example.warehouse.databaseLayer.ClientDataBase;
import com.example.warehouse.modelLayer.ClientModel;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
public class Clients implements Initializable {
    @FXML
    private ImageView clientsImageView;
    @FXML
    private TextField nameTextField;
    @FXML
    private TextField passwordTextField;
    @FXML
    private Button shopButton;
    private ClientDataBase clientdatabase;
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        File file = new File("Use/client.jpg");
        Image image = new Image(file.toURI().toString());
        this.clientsImageView.setImage(image);
        this.clientdatabase = new ClientDataBase();
    }
    @FXML
    public void shopButtonOnAction(ActionEvent actionEvent) {
        String username = nameTextField.getText();
        String password = passwordTextField.getText();
        ClientModel clientModel = new ClientModel(username, password);
        clientdatabase.registerUser(clientModel);
    }
}
