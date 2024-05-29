/**
 * The OrderDataBase class provides methods to interact with the orders stored in the database.
 */
package com.example.warehouse.databaseLayer;

import com.example.warehouse.databaseLayer.DatabaseConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class OrderDataBase {

    /**
     * Inserts a new order into the database.
     *
     * @param userId    The ID of the user placing the order.
     * @param productId The ID of the product being ordered.
     * @param quantity  The quantity of the product being ordered.
     */
    public void insertOrder(int userId, int productId, int quantity) {
        DatabaseConnection connectNow = new DatabaseConnection();
        Connection connectDB = connectNow.getConnection();

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
}
