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
     * This method handles the action of selecting a client from the ComboBox.
     */
    @FXML
    private void handleClientSelection() {
        // Retrieve the selected client
        String selectedClient = clientComboBox.getValue();
        System.out.println("Selected client: " + selectedClient);

        // You can implement logic here, e.g., load previous consultation notes for the selected client
    }

    /**
     * This method handles changes in the TextArea where consultation notes are entered.
     */
    @FXML
    private void handleTextAreaChange() {
        // Retrieve the text entered in the TextArea
        String notes = consultationNotesTextArea.getText();
        System.out.println("Consultation notes updated: " + notes);

        // Implement logic to validate or auto-save notes if needed
    }

    /**
     * This method handles the action of saving consultation notes when the "Save Notes" button is clicked.
     */
    @FXML
    private void handleSaveNotes() {
        // Retrieve the notes from the TextArea
        String notes = consultationNotesTextArea.getText();

        // Save the notes (e.g., save to a database, file, or send to a server)
        System.out.println("Saving notes: " + notes);

        // Provide user feedback (e.g., show a success message or alert)
    }
}
