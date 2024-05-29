/**
 * The ProductDataBase class provides methods to interact with the products stored in the database.
 */
package com.example.warehouse.databaseLayer;

import java.sql.Connection;
import java.sql.PreparedStatement;
import com.example.warehouse.modelLayer.ProductModel;

public class ProductDataBase {

    /**
     * Adds a new product to the database.
     *
     * @param productModel The ProductModel object representing the product to be added.
     */
    public void addProduct(ProductModel productModel) {
        DatabaseConnection connectNow = new DatabaseConnection();
        Connection connectDB = connectNow.getConnection();

        String insertQuery = "INSERT INTO products (productname, stock) VALUES (?, ?)";
        try {
            PreparedStatement preparedStatement = connectDB.prepareStatement(insertQuery);
            preparedStatement.setString(1, productModel.getProductName());
            preparedStatement.setInt(2, productModel.getStock());
            preparedStatement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Deletes a product from the database.
     *
     * @param productModel The ProductModel object representing the product to be deleted.
     */
    public void deleteProduct(ProductModel productModel) {
        DatabaseConnection connectNow = new DatabaseConnection();
        Connection connectDB = connectNow.getConnection();

        String deleteQuery = "DELETE FROM products WHERE productname = ?";
        try {
            PreparedStatement preparedStatement = connectDB.prepareStatement(deleteQuery);
            preparedStatement.setString(1, productModel.getProductName());
            preparedStatement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Updates the stock of a product in the database.
     *
     * @param productModel The ProductModel object representing the product whose stock is to be updated.
     */
    public void updateStock(ProductModel productModel) {
        DatabaseConnection connectNow = new DatabaseConnection();
        Connection connectDB = connectNow.getConnection();

        String updateQuery = "UPDATE products SET stock = ? WHERE productname = ?";
        try {
            PreparedStatement preparedStatement = connectDB.prepareStatement(updateQuery);
            preparedStatement.setInt(1, productModel.getStock());
            preparedStatement.setString(2, productModel.getProductName());
            preparedStatement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
