/**
 * The DatabaseConnection class provides methods to establish a connection to the database.
 */
package com.example.warehouse.databaseLayer;

import java.sql.Connection;
import java.sql.DriverManager;

public class DatabaseConnection {

    public Connection databaseLink;

    /**
     * Constructs a new DatabaseConnection object.
     */
    public DatabaseConnection() {
    }

    /**
     * Establishes a connection to the database.
     *
     * @return The Connection object representing the database connection.
     */
    public Connection getConnection() {
        String databaseName = "clients";
        String databaseUser = "root";
        String databasePassword = "Prietenie.7";
        String url = "jdbc:mysql://localhost/" + databaseName;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            this.databaseLink = DriverManager.getConnection(url, databaseUser, databasePassword);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return this.databaseLink;
    }
}
