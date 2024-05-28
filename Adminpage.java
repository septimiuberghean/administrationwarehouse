package com.example.warehouse.presentationLayer;

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

import com.example.warehouse.businesslogicLayer.AdminBusiness;

public class Adminpage implements Initializable {

    @FXML
    private ImageView bossImageView;
    @FXML
    private Button addproductButton;
    @FXML
    private Button deleteproductButton;
    @FXML
    private Button editproductButton;

    private AdminBusiness adminBusiness;

    public void initialize(URL url, ResourceBundle resourceBundle) {
        File file = new File("Pages/boss.jpg");
        Image image = new Image(file.toURI().toString());
        this.bossImageView.setImage(image);
        this.adminBusiness = new AdminBusiness();
    }

    public void addproductButtonOnAction(ActionEvent actionEvent) {
        adminBusiness.openAddProductPage();
    }

    public void deleteproductButtonOnAction(ActionEvent actionEvent) {
        adminBusiness.openDeleteProductPage();
    }

    public void editproductButtonOnAction(ActionEvent actionEvent) {
        adminBusiness.openEditProductPage();
    }
}
