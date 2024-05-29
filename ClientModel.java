/**
 * The ClientModel class represents the model for a client user.
 */
package com.example.warehouse.modelLayer;

public class ClientModel {

    private String username;
    private String password;

    /**
     * Constructs a new ClientModel object with the specified username and password.
     *
     * @param username The username of the client.
     * @param password The password of the client.
     */
    public ClientModel(String username, String password) {
        this.username = username;
        this.password = password;
    }

    /**
     * Retrieves the username of the client.
     *
     * @return The username of the client.
     */
    public String getUsername() {
        return username;
    }

    /**
     * Sets the username of the client.
     *
     * @param username The username to set.
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * Retrieves the password of the client.
     *
     * @return The password of the client.
     */
    public String getPassword() {
        return password;
    }

    /**
     * Sets the password of the client.
     *
     * @param password The password to set.
     */
    public void setPassword(String password) {
        this.password = password;
    }
}
