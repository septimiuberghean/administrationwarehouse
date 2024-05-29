package com.example.warehouse.businesslogicLayer;
import com.example.warehouse.databaseLayer.DatabaseConnection;
import com.example.warehouse.databaseLayer.OrderDataBase;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * The {@code OrderBusiness} class handles the business logic related to placing orders,
 * updating stock, and retrieving necessary information from the database.
 */
public class OrderBusiness {

    /**
     * Places an order for a product, updates the stock, and inserts the order into the database.
     *
     * @param productName       the name of the product to order
     * @param quantity          the quantity of the product to order
     * @param loggedInUsername  the username of the logged-in user placing the order
     */
    public void placeOrder(String productName, int quantity, String loggedInUsername) {
        DatabaseConnection connectNow = new DatabaseConnection();
        Connection connectDB = connectNow.getConnection();
        ProductBusiness productBusiness = new ProductBusiness();
        int productId = productBusiness.getProductId(productName);
        ClientBusiness clientBusiness = new ClientBusiness();
        int userId = clientBusiness.getUserIdByUsername(connectDB, loggedInUsername);
        OrderDataBase orderDataBase = new OrderDataBase();
        orderDataBase.insertOrder(userId, productId, quantity);
        updateStock(connectDB, productName, quantity);
    }

    /**
     * Updates the stock of a product in the database.
     *
     * @param connectDB    the database connection object
     * @param productName  the name of the product to update stock for
     * @param quantity     the quantity to subtract from the current stock
     */
    private void updateStock(Connection connectDB, String productName, int quantity) {
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
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("Insufficient stock.");
        }
    }

    /**
     * Retrieves the current stock of a product from the database.
     *
     * @param connectDB    the database connection object
     * @param productName  the name of the product to get the stock for
     * @return the current stock of the product, or -1 if an error occurs
     */
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
}
