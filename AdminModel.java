/**
 * The AdminModel class represents the model for an admin user.
 */
package com.example.warehouse.modelLayer;

public class AdminModel {

    private String password;

    /**
     * Retrieves the password of the admin user.
     *
     * @return The password of the admin user.
     */
    public String getPassword() {
        return password;
    }

    /**
     * Sets the password of the admin user.
     *
     * @param password The password to set.
     */
    public void setPassword(String password) {
        this.password = password;
    }
}
