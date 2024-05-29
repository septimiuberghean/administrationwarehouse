/**
 * The Product class represents a product in the warehouse.
 */
package com.example.warehouse.modelLayer;

public class Product {

    private int id;
    private String name;
    private int stock;

    /**
     * Constructs a new Product object with the specified ID, name, and stock.
     *
     * @param id    The ID of the product.
     * @param name  The name of the product.
     * @param stock The stock of the product.
     */
    public Product(int id, String name, int stock) {
        this.id = id;
        this.name = name;
        this.stock = stock;
    }

    /**
     * Retrieves the ID of the product.
     *
     * @return The ID of the product.
     */
    public int getId() {
        return id;
    }

    /**
     * Sets the ID of the product.
     *
     * @param id The ID to set.
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Retrieves the name of the product.
     *
     * @return The name of the product.
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the name of the product.
     *
     * @param name The name to set.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Retrieves the stock of the product.
     *
     * @return The stock of the product.
     */
    public int getStock() {
        return stock;
    }

    /**
     * Sets the stock of the product.
     *
     * @param stock The stock to set.
     */
    public void setStock(int stock) {
        this.stock = stock;
    }
}
