package com.example.warehouse.databaseLayer;

import com.example.warehouse.businesslogicLayer.ClientBusiness;
import com.example.warehouse.modelLayer.ClientModel;
import java.sql.Connection;
import java.sql.Statement;

public class ClientDataBase {

    private ClientBusiness clientBusiness;

    public ClientDataBase() {
        this.clientBusiness = new ClientBusiness();
    }

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
