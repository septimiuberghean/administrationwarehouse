package com.example.warehouse;

import java.io.File;
import java.net.URL;

import java.sql.Connection;
import java.sql.Statement;
import java.util.ResourceBundle;

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


public class Clients implements Initializable{

    @FXML
    private ImageView clientsImageView;
    @FXML
    private TextField nameTextField;
    @FXML
    private TextField passwordTextField;
    @FXML
    private Button shopButton;



    public void initialize(URL url, ResourceBundle resourceBundle) {
        File file = new File("Use/client.jpg");
        Image image = new Image(file.toURI().toString());
        this.clientsImageView.setImage(image);
    }

    public void shopButtonOnAction(ActionEvent actionEvent) {
            this.registerUser();
    }

    public void registerUser() {
        DatabaseConnection connectNow = new DatabaseConnection();
        Connection connectDB = connectNow.getConnection();
        String username = this.nameTextField.getText();
        String password = this.passwordTextField.getText();
        String insertFields = "INSERT INTO info (name, password) VALUES ('";
        String insertValues = username + "', '" + password + "')";
        String insertToRegister = insertFields + insertValues;
        this.createOptionsWindow(username);
        try {
            Statement statement = connectDB.createStatement();
            statement.executeUpdate(insertToRegister);
        } catch (Exception var9) {
            var9.printStackTrace();
            var9.getCause();
        }
    }

    public void createOptionsWindow(String username) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(this.getClass().getResource("/com/example/warehouse/clientspage.fxml"));
            Parent root = (Parent)fxmlLoader.load();
            Clientspage clientspage = (Clientspage)fxmlLoader.getController();
            clientspage.setLoggedInUsername(username);
            Scene scene = new Scene(root, 450.0, 527.0);
            Stage stage = new Stage();
            stage.setTitle("Options");
            stage.setScene(scene);
            stage.show();
        } catch (Exception var7) {
            var7.printStackTrace();
        }

    }


}
