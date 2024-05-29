/**
 * The ClientDataBase class provides methods to interact with the client information stored in the database.
 */
package com.example.warehouse.databaseLayer;

import com.example.warehouse.businesslogicLayer.ClientBusiness;
import com.example.warehouse.modelLayer.ClientModel;
import java.sql.Connection;
import java.sql.Statement;

public class ClientDataBase {

    private ClientBusiness clientBusiness;

    /**
     * Constructs a new ClientDataBase object.
     */
    public ClientDataBase() {
        this.clientBusiness = new ClientBusiness();
    }

    /**
     * Registers a new user in the database.
     *
     * @param clientModel The ClientModel object containing the user information to be registered.
     */
    public void registerUser(ClientModel clientModel) {
        DatabaseConnection connectNow = new DatabaseConnection();
        Connection connectDB = connectNow.getConnection();
        String username = clientModel.getUsername();
        String password = clientModel.getPassword();
        String insertFields = "INSERT INTO info (name, password) VALUES ('";
        String insertValues = username + "', '" + password + "')";
        String insertToRegister = insertFields + insertValues;

        try {
            Statement statement = connectDB.createStatement();
            statement.executeUpdate(insertToRegister);
            clientBusiness.createOptionsWindow(username);
        } catch (Exception e) {
            e.printStackTrace();
            e.getCause();
        }
    }

    /**
     * Deletes a user from the database.
     *
     * @param clientModel The ClientModel object containing the user information to be deleted.
     */
    public void deleteUser(ClientModel clientModel) {
        DatabaseConnection connectNow = new DatabaseConnection();
        Connection connectDB = connectNow.getConnection();
        String username = clientModel.getUsername();
        String deleteQuery = "DELETE FROM info WHERE name = '" + username + "'";

        try {
            Statement statement = connectDB.createStatement();
            statement.executeUpdate(deleteQuery);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Updates a user's information in the database.
     *
     * @param oldUsername       The old username of the user to be updated.
     * @param updatedClientModel The updated ClientModel object containing the new user information.
     */
    public void updateUser(String oldUsername, ClientModel updatedClientModel) {
        DatabaseConnection connectNow = new DatabaseConnection();
        Connection connectDB = connectNow.getConnection();

        String newUsername = updatedClientModel.getUsername();
        String newPassword = updatedClientModel.getPassword();

        String updateQuery = "UPDATE info SET ";
        boolean hasSetClause = false;

        if (!newUsername.isEmpty()) {
            updateQuery += "name = '" + newUsername + "'";
            hasSetClause = true;
        }

        if (!newPassword.isEmpty()) {
            if (hasSetClause) {
                updateQuery += ", ";
            }
            updateQuery += "password = '" + newPassword + "'";
        }

        updateQuery += " WHERE name = '" + oldUsername + "'";

        try {
            Statement statement = connectDB.createStatement();
            statement.executeUpdate(updateQuery);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
