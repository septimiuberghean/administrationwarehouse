package com.example.warehouse.presentationLayer;

import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;

import com.example.warehouse.businesslogicLayer.ClientBusiness;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.control.Button;

public class HelloController implements Initializable {

    @FXML
    private ImageView wImageView;
    @FXML
    private Button clientButton;
    @FXML
    private Button adminButton;

    private ClientBusiness clientBusiness;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        File pic = new File("W/warehouse.png");
        Image startImage = new Image(pic.toURI().toString());
        this.wImageView.setImage(startImage);

        this.clientBusiness = new ClientBusiness();
    }

    @FXML
    public void clientButtonOnAction(ActionEvent actionEvent) {
        clientBusiness.openthis();
    }

    @FXML
    public void adminButtonOnAction(ActionEvent actionEvent) {
        clientBusiness.openthat();
    }
}
