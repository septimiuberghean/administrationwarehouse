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

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        File file = new File("products/deleteproduct.jpg");
        Image image = new Image(file.toURI().toString());
        this.deleteproductImageView.setImage(image);
        this.productDataBase = new ProductDataBase();
        this.productModel = new ProductModel();
    }

    @FXML
    public void deleteproductButtonOnAction(ActionEvent actionEvent) {
        productModel.setProductName(insertTextField.getText());
        productDataBase.deleteProduct(productModel);
        Stage stage = (Stage) deleteproductButton.getScene().getWindow();
        stage.close();
    }
}
