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
    private TextField ppTextField;
    @FXML
    private TextField deleteButton;

    public void initialize(URL url, ResourceBundle resourceBundle) {
        File file = new File("sad/sad.jpg");
        Image image = new Image(file.toURI().toString());
        this.sadImageView.setImage(image);
    }

    public void deletedButtonOnAction(ActionEvent actionEvent) {
        this.deleteUser();
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(this.getClass().getResource("/com/example/warehouse/hello-view.fxml"));
            Scene scene = new Scene((Parent)fxmlLoader.load(), 599.0, 398.0);
            Stage stage = new Stage();
            stage.setTitle("Hello!");
            stage.setScene(scene);
            stage.show();
        } catch (Exception var4) {
            var4.printStackTrace();
            var4.getCause();
        }
    }

    public void deleteUser(){
        DatabaseConnection connectNow = new DatabaseConnection();
        Connection connectDB = connectNow.getConnection();
        String username = this.nTextField.getText();
        String deleteQuery = "DELETE FROM info WHERE name = '" + username + "'";

        try {
            Statement statement = connectDB.createStatement();
            statement.executeUpdate(deleteQuery);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
