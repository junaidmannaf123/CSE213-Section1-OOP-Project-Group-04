package oop.demo1.TasninSiza_2130480;

import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;

public class u3g1controller {

    @FXML
    private ComboBox<String> clientComboBox;

    @FXML
    private TextArea consultationNotesTextArea;

    /**
     * Initializes the ComboBox with sample client data.
     */
    @FXML
    public void initialize() {
        // Add sample clients to the ComboBox
        clientComboBox.getItems().addAll("Client A", "Client B", "Client C");

        // Provide placeholder text in the TextArea when no client is selected
        consultationNotesTextArea.setPromptText("Select a client to view or add consultation notes...");
    }

    /**
     * Handles the selection of a client from the ComboBox.
     */
    @FXML
    private void handleClientSelection() {
        // Retrieve the selected client
        String selectedClient = clientComboBox.getValue();
        if (selectedClient != null) {
            System.out.println("Selected client: " + selectedClient);

            // Logic to load previous consultation notes for the selected client
            // For this example, setting a mock previous note
            consultationNotesTextArea.setText("Previous notes for " + selectedClient);
        } else {
            System.out.println("No client selected.");
            consultationNotesTextArea.clear();
        }
    }

    /**
     * Handles changes made in the consultation notes TextArea.
     */
    @FXML
    private void handleTextAreaChange() {
        // Retrieve the updated notes from the TextArea
        String notes = consultationNotesTextArea.getText();
        System.out.println("Consultation notes updated: " + notes);

        // Optional: Logic to auto-save or validate notes can be added here
    }

    /**
     * Handles the action of saving consultation notes when the "Save Notes" button is clicked.
     */
    @FXML
    private void handleSaveNotes() {
        // Retrieve the notes and client from the TextArea and ComboBox
        String notes = consultationNotesTextArea.getText();
        String client = clientComboBox.getValue();

        if (client == null || client.isEmpty()) {
            System.out.println("Error: No client selected. Cannot save notes.");
            return;
        }

        if (notes == null || notes.trim().isEmpty()) {
            System.out.println("Error: No notes entered. Cannot save empty notes.");
            return;
        }

        // Simulate saving the notes (e.g., save to a database, file, or server)
        System.out.println("Saving notes for " + client + ": " + notes);

        // Simulated feedback for successful saving
        System.out.println("Notes saved successfully for " + client + "!");
    }
}
