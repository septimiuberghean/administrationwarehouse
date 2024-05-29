/**
 * The Deleteproduct class controls the UI for deleting a product.
 */
package com.example.warehouse.presentationLayer;

import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;

import com.example.warehouse.databaseLayer.ProductDataBase;
import com.example.warehouse.modelLayer.ProductModel;

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

public class Deleteproduct implements Initializable {

    @FXML
    private ImageView deleteproductImageView;
    @FXML
    private TextField insertTextField;
    @FXML
    private Button deleteproductButton;

    private ProductDataBase productDataBase;
    private ProductModel productModel;

    /**
     * Initializes the controller.
     *
     * @param url            The location used to resolve relative paths for the root object, or null if the location is not known.
     * @param resourceBundle The resources used to localize the root object, or null if the root object was not localized.
     */
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        File file = new File("products/deleteproduct.jpg");
        Image image = new Image(file.toURI().toString());
        this.deleteproductImageView.setImage(image);
        this.productDataBase = new ProductDataBase();
        this.productModel = new ProductModel();
    }

    /**
     * Handles the action when the delete product button is clicked.
     *
     * @param actionEvent The action event.
     */
    @FXML
    public void deleteproductButtonOnAction(ActionEvent actionEvent) {
        productModel.setProductName(insertTextField.getText());
        productDataBase.deleteProduct(productModel);
        Stage stage = (Stage) deleteproductButton.getScene().getWindow();
        stage.close();
    }
}
