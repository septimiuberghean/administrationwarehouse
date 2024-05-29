package com.example.warehouse.businesslogicLayer;

import com.example.warehouse.databaseLayer.DatabaseConnection;
import com.example.warehouse.presentationLayer.Clientspage;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * This class handles client-related operations, including opening various client
 * and admin-related pages and fetching user details from the database.
 */
public class ClientBusiness {

    /**
     * Opens the client page.
     */
    public void openthis() {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(this.getClass().getResource("/com/example/warehouse/clients.fxml"));
            Scene scene = new Scene((Parent) fxmlLoader.load(), 642.0, 400.0);
            Stage stage = new Stage();
            stage.setTitle("Hello!");
            stage.setScene(scene);
            stage.show();
        } catch (Exception var4) {
            var4.printStackTrace();
            var4.getCause();
        }
    }

    /**
     * Opens the admin password page.
     */
    public void openthat() {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(this.getClass().getResource("/com/example/warehouse/adminpass.fxml"));
            Scene scene = new Scene((Parent) fxmlLoader.load(), 596.0, 369.0);
            Stage stage = new Stage();
            stage.setTitle("Hello!");
            stage.setScene(scene);
            stage.show();
        } catch (Exception var4) {
            var4.printStackTrace();
            var4.getCause();
        }
    }

    /**
     * Creates and displays the options window for a logged-in user.
     *
     * @param username The username of the logged-in user.
     */
    public void createOptionsWindow(String username) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(this.getClass().getResource("/com/example/warehouse/clientspage.fxml"));
            Parent root = (Parent) fxmlLoader.load();
            Clientspage clientspage = (Clientspage) fxmlLoader.getController();
            clientspage.setLoggedInUsername(username);
            Scene scene = new Scene(root, 450.0, 527.0);
            Stage stage = new Stage();
            stage.setTitle("Options");
            stage.setScene(scene);
            stage.show();
        } catch (Exception var7) {
            var7.printStackTrace();
        }
    }

    /**
     * Retrieves the user ID from the database based on the username.
     *
     * @param connectDB The database connection object.
     * @param username  The username whose ID needs to be retrieved.
     * @return The user ID if found, otherwise -1.
     */
    public int getUserIdByUsername(Connection connectDB, String username) {
        String selectQuery = "SELECT id FROM info WHERE name = ?";
        int userId = -1;

        try {
            PreparedStatement preparedStatement = connectDB.prepareStatement(selectQuery);
            preparedStatement.setString(1, username);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                userId = resultSet.getInt("id");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return userId;
    }
}
