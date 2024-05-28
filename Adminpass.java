package com.example.warehouse.presentationLayer;

import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;

import com.example.warehouse.businesslogicLayer.AdminBusiness;
import com.example.warehouse.modelLayer.AdminModel;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class Adminpass implements Initializable {

    @FXML
    private ImageView passwordImageView;
    @FXML
    private TextField pTextField;
    @FXML
    private Button getinButton;

    private AdminBusiness adminbusiness;
    private AdminModel adminModel;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        File file = new File("psw/pass.png");
        Image image = new Image(file.toURI().toString());
        this.passwordImageView.setImage(image);
        this.adminbusiness = new AdminBusiness();
        this.adminModel = new AdminModel();
    }

    @FXML
    public void getinButtonOnAction(ActionEvent actionEvent) {
        adminModel.setPassword(pTextField.getText());
        String password = adminModel.getPassword();
        adminbusiness.checkAndOpenPage(password);
    }
}
