package com.example.warehouse;


import java.io.File;
import java.io.IOException;
import java.net.URL;

import java.sql.Connection;
import java.sql.Statement;
import java.util.ResourceBundle;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;


public class Adminpass implements Initializable {

    @FXML
    private ImageView passwordImageView;
    @FXML
    private TextField pTextField;
    @FXML
    private Button getinButton;

    public void initialize(URL url, ResourceBundle resourceBundle) {
        File file = new File("psw/pass.png");
        Image image = new Image(file.toURI().toString());
        this.passwordImageView.setImage(image);
    }

    public void getinButtonOnAction(ActionEvent actionEvent) {
        String password = pTextField.getText();
        if ("iphone14".equals(password)) {
            try {
                FXMLLoader fxmlLoader = new FXMLLoader(this.getClass().getResource("/com/example/warehouse/adminpage.fxml"));
                Scene scene = new Scene((Parent) fxmlLoader.load(), 600.0, 412.0);
                Stage stage = new Stage();
                stage.setTitle("Hello!");
                stage.setScene(scene);
                stage.show();
            } catch (Exception var4) {
                var4.printStackTrace();
                var4.getCause();
            }
        }
    }
}
