package oop.demo1.TasninSiza;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;

import java.time.LocalDate;

public class u3g8controller {

    @FXML
    private ComboBox<String> topicComboBox;

    @FXML
    private DatePicker workshopDatePicker;

    @FXML
    private Button confirmButton;

    @FXML
    private Label confirmationLabel;

    @FXML
    private Label dateLabel;

    @FXML
    private Label topicLabel;

    @FXML
    private void initialize() {
        // Populate the ComboBox with workshop topics (could be dynamic or static values)
        topicComboBox.getItems().addAll("Topic 1", "Topic 2", "Topic 3", "Topic 4");

        // Initialize the confirmation label with a message
        confirmationLabel.setText("Please select a topic and date.");
    }

    /**
     * Handle the selection of a workshop topic from the ComboBox.
     */
    @FXML
    private void handleTopicSelection() {
        String selectedTopic = topicComboBox.getSelectionModel().getSelectedItem();
        if (selectedTopic != null && !selectedTopic.isEmpty()) {
            confirmationLabel.setText("Topic: " + selectedTopic + " selected.");
        } else {
            confirmationLabel.setText("Please select a topic.");
        }
    }

    /**
     * Handle the selection of the workshop date.
     */
    @FXML
    private void handleDateSelection() {
        LocalDate selectedDate = workshopDatePicker.getValue();
        if (selectedDate != null) {
            confirmationLabel.setText("Date: " + selectedDate.toString() + " selected.");
        } else {
            confirmationLabel.setText("Please select a date.");
        }
    }

    /**
     * Handle the confirmation action when the confirm button is clicked.
     */
    @FXML
    private void handleConfirm(ActionEvent event) {
        String selectedTopic = topicComboBox.getSelectionModel().getSelectedItem();
        LocalDate selectedDate = workshopDatePicker.getValue();

        if (selectedTopic != null && !selectedTopic.isEmpty() && selectedDate != null) {
            // Confirm the selection (this could involve saving the data or triggering further logic)
            // For now, just update the confirmation label as a placeholder for actual logic.
            confirmationLabel.setText("Workshop: " + selectedTopic + " scheduled for " + selectedDate.toString());
        } else {
            // If either the topic or date is missing, show an error message
            confirmationLabel.setText("Please select both a topic and a date.");
        }
    }
}
