/**
 * The Clientspage class controls the UI for the client dashboard.
 */
package com.example.warehouse.presentationLayer;

import java.io.File;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

import com.example.warehouse.businesslogicLayer.OrderBusiness;
import com.example.warehouse.databaseLayer.DatabaseConnection;
import com.example.warehouse.modelLayer.Product;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import javafx.scene.control.cell.PropertyValueFactory;

public class Clientspage implements Initializable {

    @FXML
    private Button deleteButton;
    @FXML
    private Button updateButton;
    @FXML
    private Button orderButton;
    @FXML
    private TextField selectproductTextField;
    @FXML
    private TextField selectquantityTextField;

    @FXML
    private ImageView clientsImageView;

    @FXML
    private TableView<Product> productsTableView;
    @FXML
    private TableColumn<Product, Integer> productIdColumn;
    @FXML
    private TableColumn<Product, String> productNameColumn;
    @FXML
    private TableColumn<Product, Integer> productStockColumn;

    private String loggedInUsername;
    private ObservableList<Product> productList;
    private OrderBusiness orderBusiness;

    /**
     * Initializes the controller.
     *
     * @param url            The location used to resolve relative paths for the root object, or null if the location is not known.
     * @param resourceBundle The resources used to localize the root object, or null if the root object was not localized.
     */
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        File file = new File("Pages/buy.jpg");
        Image image = new Image(file.toURI().toString());
        this.clientsImageView.setImage(image);
        productIdColumn.setCellValueFactory(new PropertyValueFactory<>("id"));
        productNameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
        productStockColumn.setCellValueFactory(new PropertyValueFactory<>("stock"));
        productList = FXCollections.observableArrayList();
        productsTableView.setItems(productList);
        loadProducts();
        orderBusiness = new OrderBusiness();
    }

    /**
     * Loads the products into the TableView.
     */
    private void loadProducts() {
        DatabaseConnection connectNow = new DatabaseConnection();
        Connection connectDB = connectNow.getConnection();
        String query = "SELECT id, productname, stock FROM products";
        try {
            PreparedStatement preparedStatement = connectDB.prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();
            productList.clear();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("productname");
                int stock = resultSet.getInt("stock");
                Product product = new Product(id, name, stock);
                productList.add(product);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Sets the username of the logged-in user.
     *
     * @param username The username of the logged-in user.
     */
    public void setLoggedInUsername(String username) {
        this.loggedInUsername = username;
    }

    /**
     * Handles the action when the delete button is clicked.
     *
     * @param actionEvent The action event.
     */
    @FXML
    public void deleteButtonOnAction(ActionEvent actionEvent) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(this.getClass().getResource("/com/example/warehouse/deleteclient.fxml"));
            Scene scene = new Scene((Parent) fxmlLoader.load(), 400.0, 399.0);
            Stage stage = new Stage();
            stage.setTitle("Hello!");
            stage.setScene(scene);
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Handles the action when the update button is clicked.
     *
     * @param actionEvent The action event.
     */
    @FXML
    public void updateButtonOnAction(ActionEvent actionEvent) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(this.getClass().getResource("/com/example/warehouse/updateclient.fxml"));
            Scene scene = new Scene((Parent) fxmlLoader.load(), 400.0, 399.0);
            Stage stage = new Stage();
            stage.setTitle("Hello!");
            stage.setScene(scene);
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Handles the action when the order button is clicked.
     *
     * @param actionEvent The action event.
     */
    @FXML
    public void orderButtonOnAction(ActionEvent actionEvent) {
        if (!this.selectproductTextField.getText().isBlank() && !this.selectquantityTextField.getText().isBlank()) {
            String productName = selectproductTextField.getText();
            int quantity = Integer.parseInt(selectquantityTextField.getText());
            orderBusiness.placeOrder(productName, quantity, loggedInUsername);
            loadProducts();
        }
    }
}
