/**
 * The EditProduct class controls the UI for editing product details.
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
        File file = new File("products/editproduct.jpg");
        Image image = new Image(file.toURI().toString());
        this.restockImageView.setImage(image);
        this.productDataBase = new ProductDataBase();
        this.productModel = new ProductModel();
    }

    /**
     * Handles the action when the restock button is clicked.
     *
     * @param actionEvent The action event.
     */
    @FXML
    public void restockButtonOnAction(ActionEvent actionEvent) {
        productModel.setProductName(selectTextField.getText());
        productModel.setStock(Integer.parseInt(nrTextField.getText()));
        productDataBase.updateStock(productModel);

        Stage stage = (Stage) restockButton.getScene().getWindow();
        stage.close();

        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/com/example/warehouse/adminpage.fxml"));
            Scene scene = new Scene(fxmlLoader.load(), 652.0, 448.0);
            Stage newStage = new Stage();
            newStage.setTitle("Admin Page");
            newStage.setScene(scene);
            newStage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
