package com.example.warehouse.businesslogicLayer;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
public class AdminBusiness {

    private static final String ADMIN_PASSWORD = "iphone14";

    public void checkAndOpenPage(String password) {
        if (ADMIN_PASSWORD.equals(password)) {
            openthispage();
        } else {
            System.out.println("Invalid password");
        }
    }
    public void openthispage() {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/com/example/warehouse/adminpage.fxml"));
            Parent root = fxmlLoader.load();
            Scene scene = new Scene(root, 600.0, 412.0);
            Stage stage = new Stage();
            stage.setTitle("Admin Page");
            stage.setScene(scene);
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void openAddProductPage() {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/com/example/warehouse/addproduct.fxml"));
            Parent root = fxmlLoader.load();
            Scene scene = new Scene(root, 599.0, 398.0);
            Stage stage = new Stage();
            stage.setTitle("Add Product");
            stage.setScene(scene);
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void openDeleteProductPage() {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/com/example/warehouse/deleteproduct.fxml"));
            Parent root = fxmlLoader.load();
            Scene scene = new Scene(root, 599.0, 398.0);
            Stage stage = new Stage();
            stage.setTitle("Delete Product");
            stage.setScene(scene);
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void openEditProductPage() {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/com/example/warehouse/editproduct.fxml"));
            Parent root = fxmlLoader.load();
            Scene scene = new Scene(root, 599.0, 398.0);
            Stage stage = new Stage();
            stage.setTitle("Edit Product");
            stage.setScene(scene);
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
