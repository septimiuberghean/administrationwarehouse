/**
 * The Addproduct class controls the UI for adding a new product.
 */
package com.example.warehouse.presentationLayer;

import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;

import com.example.warehouse.databaseLayer.ProductDataBase;
import com.example.warehouse.modelLayer.ProductModel;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

public class Addproduct implements Initializable {

    @FXML
    private ImageView addproductImageView;
    @FXML
    private TextField npTextField;
    @FXML
    private TextField itemsTextField;
    @FXML
    private Button addpButton;

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
        File file = new File("products/addproduct.jpg");
        Image image = new Image(file.toURI().toString());
        this.addproductImageView.setImage(image);
        this.productDataBase = new ProductDataBase();
        this.productModel = new ProductModel();
    }

    /**
     * Handles the action when the add product button is clicked.
     *
     * @param actionEvent The action event.
     */
    @FXML
    public void addpButtonOnAction(ActionEvent actionEvent) {
        productModel.setProductName(npTextField.getText());
        productModel.setStock(Integer.parseInt(itemsTextField.getText()));
        productDataBase.addProduct(productModel);
        Stage stage = (Stage) addpButton.getScene().getWindow();
        stage.close();
    }
}
