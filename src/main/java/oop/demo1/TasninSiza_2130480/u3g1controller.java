package oop.demo1.TasninSiza_2130480;

import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;

public class u3g1controller {

    @FXML
    private ComboBox<String> clientComboBox;

    @FXML
    private TextArea consultationNotesTextArea;


    @FXML
    public void initialize() {

        clientComboBox.getItems().addAll("Client A", "Client B", "Client C");


        consultationNotesTextArea.setPromptText("Select a client to view or add consultation notes...");
    }


    @FXML
    private void handleClientSelection() {

        String selectedClient = clientComboBox.getValue();
        if (selectedClient != null) {
            System.out.println("Selected client: " + selectedClient);


            consultationNotesTextArea.setText("Previous notes for " + selectedClient);
        } else {
            System.out.println("No client selected.");
            consultationNotesTextArea.clear();
        }
    }


    @FXML
    private void handleTextAreaChange() {

        String notes = consultationNotesTextArea.getText();
        System.out.println("Consultation notes updated: " + notes);


    }


    @FXML
    private void handleSaveNotes() {

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


        System.out.println("Saving notes for " + client + ": " + notes);


        System.out.println("Notes saved successfully for " + client + "!");
    }
}
