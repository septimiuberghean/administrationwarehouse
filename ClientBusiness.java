package com.example.warehouse.businesslogicLayer;

import com.example.warehouse.presentationLayer.Clientspage;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class ClientBusiness {
    public void openthis() {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(this.getClass().getResource("/com/example/warehouse/clients.fxml"));
            Scene scene = new Scene((Parent)fxmlLoader.load(), 642.0, 400.0);
            Stage stage = new Stage();
            stage.setTitle("Hello!");
            stage.setScene(scene);
            stage.show();
        } catch (Exception var4) {
            var4.printStackTrace();
            var4.getCause();
        }
    }
    public void openthat() {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(this.getClass().getResource("/com/example/warehouse/adminpass.fxml"));
            Scene scene = new Scene((Parent)fxmlLoader.load(), 596.0, 369.0);
            Stage stage = new Stage();
            stage.setTitle("Hello!");
            stage.setScene(scene);
            stage.show();
        } catch (Exception var4) {
            var4.printStackTrace();
            var4.getCause();
        }
    }
    public void createOptionsWindow(String username) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(this.getClass().getResource("/com/example/warehouse/clientspage.fxml"));
            Parent root = (Parent)fxmlLoader.load();
            Clientspage clientspage = (Clientspage)fxmlLoader.getController();
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
}
