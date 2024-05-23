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

    public void initialize(URL url, ResourceBundle resourceBundle) {
        File file = new File("update/update.jpg");
        Image image = new Image(file.toURI().toString());
        this.updateImageView.setImage(image);
    }

    public void upButtonOnAction(ActionEvent actionEvent) {
        this.updateUser();
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(this.getClass().getResource("/com/example/warehouse/clientspage.fxml"));
            Scene scene = new Scene((Parent) fxmlLoader.load(), 599.0, 398.0);
            Stage stage = new Stage();
            stage.setTitle("Client Updated!");
            stage.setScene(scene);
            stage.show();
        } catch (Exception var4) {
            var4.printStackTrace();
            var4.getCause();
        }

    }

    public void updateUser() {
        DatabaseConnection connectNow = new DatabaseConnection();
        Connection connectDB = connectNow.getConnection();
        String oldUsername = this.oldTextField.getText();
        String newUsername = this.introducenameTextField.getText();
        String newPassword = this.introducepasswordTextField.getText();

        String updateQuery = "UPDATE info SET ";
        boolean hasSetClause = false;

        if (!newUsername.isEmpty()) {
            updateQuery += "name = '" + newUsername + "'";
            hasSetClause = true;
        }

        if (!newPassword.isEmpty()) {
            if (hasSetClause) {
                updateQuery += ", ";
            }
            updateQuery += "password = '" + newPassword + "'";
        }

        updateQuery += " WHERE name = '" + oldUsername + "'";

        try {
            Statement statement = connectDB.createStatement();
            statement.executeUpdate(updateQuery);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
