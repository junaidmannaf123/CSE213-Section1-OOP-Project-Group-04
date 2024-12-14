package oop.demo1.TasninSiza_2130480;

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

    /**
     * Initializes the ComboBox and confirmation label with default values.
     */
    @FXML
    private void initialize() {
        // Populate the ComboBox with workshop topics
        topicComboBox.getItems().addAll(
                "Immigration Process Overview",
                "Resume Writing for Jobs",
                "Housing and Settling in New Country",
                "Language Training Tips"
        );

        // Set the default confirmation label
        confirmationLabel.setText("Please select a topic and date.");
    }

    /**
     * Handles the selection of a workshop topic from the ComboBox.
     */
    @FXML
    private void handleTopicSelection() {
        String selectedTopic = topicComboBox.getValue();
        if (selectedTopic != null && !selectedTopic.isEmpty()) {
            System.out.println("Selected topic: " + selectedTopic);
            confirmationLabel.setText("Topic selected: " + selectedTopic + ". Now select a date.");
        } else {
            confirmationLabel.setText("Please select a valid topic.");
        }
    }

    /**
     * Handles the selection of a date from the DatePicker.
     */
    @FXML
    private void handleDateSelection() {
        LocalDate selectedDate = workshopDatePicker.getValue();
        if (selectedDate != null) {
            if (selectedDate.isBefore(LocalDate.now())) {
                confirmationLabel.setText("Error: Workshop date cannot be in the past.");
                System.out.println("Error: Invalid workshop date.");
            } else {
                System.out.println("Selected date: " + selectedDate);
                confirmationLabel.setText("Date selected: " + selectedDate + ". Now confirm your workshop.");
            }
        } else {
            confirmationLabel.setText("Please select a valid date.");
        }
    }

    /**
     * Handles the confirmation action when the Confirm button is clicked.
     */
    @FXML
    private void handleConfirm(ActionEvent event) {
        String selectedTopic = topicComboBox.getValue();
        LocalDate selectedDate = workshopDatePicker.getValue();

        // Validate topic selection
        if (selectedTopic == null || selectedTopic.isEmpty()) {
            confirmationLabel.setText("Error: Please select a workshop topic.");
            System.out.println("Error: No topic selected.");
            return;
        }

        // Validate date selection
        if (selectedDate == null) {
            confirmationLabel.setText("Error: Please select a workshop date.");
            System.out.println("Error: No date selected.");
            return;
        }

        // Ensure the selected date is not in the past
        if (selectedDate.isBefore(LocalDate.now())) {
            confirmationLabel.setText("Error: Workshop date cannot be in the past.");
            System.out.println("Error: Workshop date is in the past.");
            return;
        }

        // Confirm the workshop scheduling
        System.out.println("Workshop scheduled: " + selectedTopic);
        System.out.println("Scheduled date: " + selectedDate);

        confirmationLabel.setText("Workshop: " + selectedTopic + " scheduled for " + selectedDate + ".");
    }
}
