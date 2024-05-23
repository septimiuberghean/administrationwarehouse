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


public class Addproduct implements Initializable{

    @FXML
    private ImageView addproductImageView;
    @FXML
    private TextField npTextField;
    @FXML
    private TextField itemsTextField;
    @FXML
    private Button addpButton;

    public void initialize(URL url, ResourceBundle resourceBundle) {
        File file = new File("products/addproduct.jpg");
        Image image = new Image(file.toURI().toString());
        this.addproductImageView.setImage(image);
    }

    public void addpButtonOnAction(ActionEvent actionEvent) {
        this.addProduct();
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


    public void addProduct() {
        DatabaseConnection connectNow = new DatabaseConnection();
        Connection connectDB = connectNow.getConnection();
        String np = this.npTextField.getText();
        String items = this.itemsTextField.getText();
        String insertFields = "INSERT INTO products (productname, stock) VALUES ('";
        String insertValues = np + "', '" + items + "')";
        String insertToRegister = insertFields + insertValues;

        try {
            Statement statement = connectDB.createStatement();
            statement.executeUpdate(insertToRegister);
        } catch (Exception var9) {
            var9.printStackTrace();
            var9.getCause();
        }

    }

}
