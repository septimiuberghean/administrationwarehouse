/**
 * The ProductModel class represents the model for a product.
 */
package com.example.warehouse.modelLayer;

public class ProductModel {

    private String productName;
    private int stock;

    /**
     * Retrieves the name of the product.
     *
     * @return The name of the product.
     */
    public String getProductName() {
        return productName;
    }

    /**
     * Sets the name of the product.
     *
     * @param productName The name to set.
     */
    public void setProductName(String productName) {
        this.productName = productName;
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
