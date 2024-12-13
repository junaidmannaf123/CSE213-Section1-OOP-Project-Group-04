package oop.demo1.TasninSiza;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;

public class u3g6controller {

    @FXML
    private TableView<?> queryTableView; // TableView to display queries

    @FXML
    private TextArea responseTextArea; // TextArea to input response to a query

    @FXML
    private Button updateButton; // Button to update response

    @FXML
    private Button backButton; // Button to go back to the previous screen

    @FXML
    private Label statusLabel; // Status label

    // Method to handle updating the response
    @FXML
    private void handleUpdate(ActionEvent event) {
        String response = responseTextArea.getText().trim();

        if (!response.isEmpty()) {
            // Logic to handle updating the response
            System.out.println("Response updated: " + response);
            // You can add further logic to update the query status or save the response
        } else {
            System.out.println("Please enter a response before updating.");
        }
    }

    // Method to handle going back to the previous screen (login screen)
    @FXML
    private void handleBackToLogin(ActionEvent event) {
        System.out.println("Navigating back to the login screen.");

        // Switch to the login screen
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
