/**
 * The Adminpage class controls the UI for the admin dashboard.
 */
package com.example.warehouse.presentationLayer;

import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
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

    /**
     * Initializes the controller.
     *
     * @param url            The location used to resolve relative paths for the root object, or null if the location is not known.
     * @param resourceBundle The resources used to localize the root object, or null if the root object was not localized.
     */
    public void initialize(URL url, ResourceBundle resourceBundle) {
        File file = new File("Pages/boss.jpg");
        Image image = new Image(file.toURI().toString());
        this.bossImageView.setImage(image);
        this.adminBusiness = new AdminBusiness();
    }

    /**
     * Handles the action when the add product button is clicked.
     *
     * @param actionEvent The action event.
     */
    public void addproductButtonOnAction(ActionEvent actionEvent) {
        adminBusiness.openAddProductPage();
    }

    /**
     * Handles the action when the delete product button is clicked.
     *
     * @param actionEvent The action event.
     */
    public void deleteproductButtonOnAction(ActionEvent actionEvent) {
        adminBusiness.openDeleteProductPage();
    }

    /**
     * Handles the action when the edit product button is clicked.
     *
     * @param actionEvent The action event.
     */
    public void editproductButtonOnAction(ActionEvent actionEvent) {
        adminBusiness.openEditProductPage();
    }
}
