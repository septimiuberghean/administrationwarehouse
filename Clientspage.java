package com.example.warehouse;

import java.io.File;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

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
    }

    public void setLoggedInUsername(String username) {
        this.loggedInUsername = username;
    }

    @FXML
    public void deleteButtonOnAction(ActionEvent actionEvent) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(this.getClass().getResource("/com/example/warehouse/deleteclient.fxml"));
            Scene scene = new Scene((Parent) fxmlLoader.load(), 400.0, 399.0);
            Stage stage = new Stage();
            stage.setTitle("Hello!");
            stage.setScene(scene);
            stage.show();
        } catch (Exception var4) {
            var4.printStackTrace();
            var4.getCause();
        }
    }

    @FXML
    public void updateButtonOnAction(ActionEvent actionEvent) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(this.getClass().getResource("/com/example/warehouse/updateclient.fxml"));
            Scene scene = new Scene((Parent) fxmlLoader.load(), 400.0, 399.0);
            Stage stage = new Stage();
            stage.setTitle("Hello!");
            stage.setScene(scene);
            stage.show();
        } catch (Exception var4) {
            var4.printStackTrace();
            var4.getCause();
        }
    }

    @FXML
    public void orderButtonOnAction(ActionEvent actionEvent) {
        if (!this.selectproductTextField.getText().isBlank() && !this.selectquantityTextField.getText().isBlank()) {
            placeOrder();
        }
    }

    private void placeOrder() {
        DatabaseConnection connectNow = new DatabaseConnection();
        Connection connectDB = connectNow.getConnection();

        String productName = selectproductTextField.getText();
        String quantityString = selectquantityTextField.getText();
        int quantity = Integer.parseInt(quantityString);

        int productId = getProductId(productName);
        int user_id = this.getUserIdByUsername(connectDB, this.loggedInUsername);
        insertOrder(connectDB, user_id, productId, quantity);
        updateStock(productName, quantity);
    }

    private void updateStock(String productName, int quantity) {
        DatabaseConnection connectNow = new DatabaseConnection();
        Connection connectDB = connectNow.getConnection();

        int currentStock = getCurrentStock(connectDB, productName);
        int updatedStock = currentStock - quantity;

        if (updatedStock >= 0) {
            String updateQuery = "UPDATE products SET stock = ? WHERE productname = ?";

            try {
                PreparedStatement preparedStatement = connectDB.prepareStatement(updateQuery);
                preparedStatement.setInt(1, updatedStock);
                preparedStatement.setString(2, productName);

                preparedStatement.executeUpdate();
                System.out.println("Stock updated successfully.");
                loadProducts();  // Reload products to refresh the table
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("Insufficient stock.");
        }
    }

    private int getCurrentStock(Connection connectDB, String productName) {
        String query = "SELECT stock FROM products WHERE productname = ?";
        int currentStock = -1;

        try {
            PreparedStatement preparedStatement = connectDB.prepareStatement(query);
            preparedStatement.setString(1, productName);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                currentStock = resultSet.getInt("stock");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return currentStock;
    }

    private int getProductId(String productName) {
        DatabaseConnection connectNow = new DatabaseConnection();
        Connection connectDB = connectNow.getConnection();

        String query = "SELECT id FROM products WHERE productname = ?";
        try {
            PreparedStatement preparedStatement = connectDB.prepareStatement(query);
            preparedStatement.setString(1, productName);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                return resultSet.getInt("id");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return -1;
    }

    private void insertOrder(Connection connectDB, int userId, int productId, int quantity) {
        String insertOrderQuery = "INSERT INTO orders (user_id, product_id, quantity) VALUES (?, ?, ?)";

        try {
            PreparedStatement preparedStatement = connectDB.prepareStatement(insertOrderQuery);
            preparedStatement.setInt(1, userId);
            preparedStatement.setInt(2, productId);
            preparedStatement.setInt(3, quantity);

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private int getUserIdByUsername(Connection connectDB, String username) {
        String selectQuery = "SELECT id FROM info WHERE name = ?";
        int user_id = -1;

        try {
            PreparedStatement preparedStatement = connectDB.prepareStatement(selectQuery);
            preparedStatement.setString(1, username);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                user_id = resultSet.getInt("id");
            }
        } catch (Exception var7) {
            var7.printStackTrace();
        }
        return user_id;
    }

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
}
