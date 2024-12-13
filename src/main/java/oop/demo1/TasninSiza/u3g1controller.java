package oop.demo1.TasninSiza;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.fxml.FXMLLoader;

public class u3g1controller {

    @FXML
    private ComboBox<String> clientComboBox;

    @FXML
    private TextArea consultationNotesTextArea;

    @FXML
    private Button saveNotesButton;

    @FXML
    private Button backButton;

    // Method to handle saving the consultation notes
    @FXML
    private void handleSaveNotes(ActionEvent event) {
        String selectedClient = clientComboBox.getValue();
        String consultationNotes = consultationNotesTextArea.getText();

        // Here, you can add logic to save these notes (e.g., to a database or file)
        System.out.println("Saving consultation notes for client: " + selectedClient);
        System.out.println("Notes: " + consultationNotes);

        // Provide feedback to the user (this can be done using an alert or a label)
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
