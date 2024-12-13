package oop.demo1.TasninSiza;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableView;
import javafx.scene.input.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;
import javafx.stage.Stage;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.fxml.FXMLLoader;

public class u3g3controller {

    @FXML
    private ComboBox<String> clientComboBox;

    @FXML
    private TableView<?> progressTableView;

    @FXML
    private Button sendUpdatesButton;

    @FXML
    private Button backButton;

    // Method to handle sending updates
    @FXML
    private void handleSendUpdates(ActionEvent event) {
        String selectedClient = clientComboBox.getValue();

        if (selectedClient != null) {
            System.out.println("Sending updates for client: " + selectedClient);

            // Here you can add the logic to send the progress updates for the selected client
        } else {
            System.out.println("Please select a client to send updates.");
        }
    }

    // Method to handle going back to the previous screen (login screen)
    @FXML
    private void handleBackToLogin(ActionEvent event) {
        System.out.println("Navigating back to the login screen.");

        // Switching to the login screen
        switchScene(event, "Login.fxml");
    }

    // Helper method to switch scenes
    private void switchScene(ActionEvent event, String fxmlFile) {
        try {
            // Load the FXML file for the target scene
            FXMLLoader loader = new FXMLLoader(getClass().getResource(fxmlFile));
            Parent root = loader.load();

            // Get the current stage
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();

            // Set the new scene
            Scene newScene = new Scene(root);
            stage.setScene(newScene);
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
            System.err.println("Error while switching scenes: " + e.getMessage());
        }
    }
}
