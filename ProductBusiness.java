package com.example.warehouse.businesslogicLayer;

import com.example.warehouse.databaseLayer.DatabaseConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * The {@code ProductBusiness} class handles the business logic related to products,
 * including retrieving product IDs from the database.
 */
public class ProductBusiness {

    /**
     * Retrieves the product ID from the database based on the product name.
     *
     * @param productName the name of the product
     * @return the product ID, or -1 if the product is not found or an error occurs
     */
    public int getProductId(String productName) {
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
}
