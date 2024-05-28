package com.example.warehouse.databaseLayer;
import java.sql.Connection;
import java.sql.DriverManager;

public class DatabaseConnection {
    public Connection databaseLink;
    public DatabaseConnection() {
    }
    public Connection getConnection () {
        String databaseName = "clients";
        String databaseUser = "root";
        String databasePassword = "Prietenie.7";
        String url = "jdbc:mysql://localhost/" + databaseName;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            this.databaseLink = DriverManager.getConnection(url, databaseUser, databasePassword);
        } catch (Exception var6) {
            var6.printStackTrace();
        }

        return this.databaseLink;
    }
}
