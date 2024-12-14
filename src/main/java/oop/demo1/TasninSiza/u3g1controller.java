package oop.demo1.TasninSiza;

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
     * This method should be called during initialization.
     */
    @FXML
    public void initialize() {
        // Add sample clients to the ComboBox
        clientComboBox.getItems().addAll("Client A", "Client B", "Client C");
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

            // Logic to load previous consultation notes for the selected client can be added here
            consultationNotesTextArea.setText("Notes for " + selectedClient);
        } else {
            System.out.println("No client selected.");
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

        // You can implement logic to auto-save or validate notes
    }

    /**
     * Handles the action of saving consultation notes when the "Save Notes" button is clicked.
     */
    @FXML
    private void handleSaveNotes() {
        // Retrieve the notes from the TextArea
        String notes = consultationNotesTextArea.getText();
        String client = clientComboBox.getValue();

        if (client == null || client.isEmpty()) {
            System.out.println("No client selected. Cannot save notes.");
            return;
        }

        if (notes == null || notes.trim().isEmpty()) {
            System.out.println("No notes entered. Cannot save empty notes.");
            return;
        }

        // Save logic (e.g., saving to a database, file, or server) would go here
        System.out.println("Saving notes for " + client + ": " + notes);

        // Provide feedback to the user
        System.out.println("Notes saved successfully!");
    }
}
