package com.example.warehouse;


import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;




public class HelloController implements Initializable {

    @FXML
    private ImageView wImageView;

    public void initialize(URL url, ResourceBundle resourceBundle) {
        File pic = new File("W/warehouse.png");
        Image startImage = new Image(pic.toURI().toString());
        this.wImageView.setImage(startImage);
    }

    public void clientButtonOnAction(ActionEvent actionEvent) {
        this.openthis();
    }

    public void adminButtonOnAction(ActionEvent actionEvent) {
        this.openthat();
    }

    public void openthis() {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(this.getClass().getResource("/com/example/warehouse/clients.fxml"));
            Scene scene = new Scene((Parent)fxmlLoader.load(), 642.0, 400.0);
            Stage stage = new Stage();
            stage.setTitle("Hello!");
            stage.setScene(scene);
            stage.show();
        } catch (Exception var4) {
            var4.printStackTrace();
            var4.getCause();
        }
    }

    public void openthat() {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(this.getClass().getResource("/com/example/warehouse/adminpass.fxml"));
            Scene scene = new Scene((Parent)fxmlLoader.load(), 596.0, 369.0);
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