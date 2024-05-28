package com.example.warehouse.databaseLayer;

import java.sql.Connection;
import java.sql.PreparedStatement;

import com.example.warehouse.modelLayer.ProductModel;

public class ProductDataBase {
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
