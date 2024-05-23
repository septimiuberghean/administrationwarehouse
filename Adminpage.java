package com.example.warehouse;

import java.io.File;
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

public class Adminpage implements Initializable {

    @FXML
    private ImageView bossImageView;
    @FXML
    private Button addproductButton;
    @FXML
    private Button deleteproductButton;
    @FXML
    private Button editproductButton;
    public void initialize(URL url, ResourceBundle resourceBundle) {
        File file = new File("Pages/boss.jpg");
        Image image = new Image(file.toURI().toString());
        this.bossImageView.setImage(image);
    }

    public void addproductButtonOnAction(ActionEvent actionEvent) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(this.getClass().getResource("/com/example/warehouse/addproduct.fxml"));
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

    public void deleteproductButtonOnAction(ActionEvent actionEvent) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(this.getClass().getResource("/com/example/warehouse/deleteproduct.fxml"));
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

    public void editproductButtonOnAction(ActionEvent actionEvent) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(this.getClass().getResource("/com/example/warehouse/editproduct.fxml"));
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





}
