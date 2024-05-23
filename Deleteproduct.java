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

public class Deleteproduct implements Initializable{

    @FXML
    private ImageView deleteproductImageView;
    @FXML
    private TextField insertTextField;
    @FXML
    private Button deleteproductButton;
    public void initialize(URL url, ResourceBundle resourceBundle) {
        File file = new File("products/deleteproduct.jpg");
        Image image = new Image(file.toURI().toString());
        this.deleteproductImageView.setImage(image);
    }

    public void deleteproductButtonOnAction(ActionEvent actionEvent) {
        this.deleteProduct();
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(this.getClass().getResource("/com/example/warehouse/adminpage.fxml"));
            Scene scene = new Scene((Parent)fxmlLoader.load(), 652.0, 448.0);
            Stage stage = new Stage();
            stage.setTitle("Hello!");
            stage.setScene(scene);
            stage.show();
        } catch (Exception var4) {
            var4.printStackTrace();
            var4.getCause();
        }
    }

    public void deleteProduct(){
        DatabaseConnection connectNow = new DatabaseConnection();
        Connection connectDB = connectNow.getConnection();
        String nameproduct = this.insertTextField.getText();
        String deleteQuery = "DELETE FROM products WHERE productname = '" + nameproduct + "'";

        try {
            Statement statement = connectDB.createStatement();
            statement.executeUpdate(deleteQuery);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
