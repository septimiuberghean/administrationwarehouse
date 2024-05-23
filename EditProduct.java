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


public class EditProduct implements Initializable {

    @FXML
    private ImageView restockImageView;
    @FXML
    private TextField selectTextField;
    @FXML
    private TextField nrTextField;
    @FXML
    private Button restockButton;

    public void initialize(URL url, ResourceBundle resourceBundle) {
        File file = new File("products/editproduct.jpg");
        Image image = new Image(file.toURI().toString());
        this.restockImageView.setImage(image);
    }

    public void restockButtonOnAction(ActionEvent actionEvent) {
        this.updateStock();
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(this.getClass().getResource("/com/example/warehouse/adminpage.fxml"));
            Scene scene = new Scene((Parent) fxmlLoader.load(), 652.0, 448.0);
            Stage stage = new Stage();
            stage.setTitle("Hello!");
            stage.setScene(scene);
            stage.show();
        } catch (Exception var4) {
            var4.printStackTrace();
            var4.getCause();
        }
    }

    public void updateStock() {
        DatabaseConnection connectNow = new DatabaseConnection();
        Connection connectDB = connectNow.getConnection();
        String nameproduct = this.selectTextField.getText();
        String stock = this.nrTextField.getText();

        String updateQuery = "UPDATE products SET ";
        boolean hasSetClause = false;

        if (!nameproduct.isEmpty()) {
            updateQuery += "productname = '" + nameproduct + "'";
            hasSetClause = true;
        }

        if (!stock.isEmpty()) {
            if (hasSetClause) {
                updateQuery += ", ";
            }
            updateQuery += "stock = '" + stock + "'";
        }

        updateQuery += " WHERE productname = '" + nameproduct + "'";

        try {
            Statement statement = connectDB.createStatement();
            statement.executeUpdate(updateQuery);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
