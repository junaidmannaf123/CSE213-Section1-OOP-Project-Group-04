package oop.demo1.TasninSiza;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.Button;
import java.time.LocalDate;

public class u3g5controller {

    @FXML
    private ComboBox<String> serviceComboBox;

    @FXML
    private DatePicker followUpDatePicker;

    @FXML
    private Label statusLabel;

    @FXML
    private Button confirmButton;

    @FXML
    private void initialize() {
        // Sample data for ComboBox
        serviceComboBox.getItems().addAll("Service A", "Service B", "Service C");

        // Initialize labels or other UI components if needed
        statusLabel.setText("Select a service and follow-up date.");
    }

    /**
     * Handles the service selection from the ComboBox.
     */
    @FXML
    private void handleServiceSelection() {
        String selectedService = serviceComboBox.getValue();
        if (selectedService != null) {
            System.out.println("Selected service: " + selectedService);
            statusLabel.setText("Follow-up date for " + selectedService + " is required.");
        } else {
            statusLabel.setText("No service selected.");
        }
    }

    /**
     * Handles the date selection from the DatePicker.
     */
    @FXML
    private void handleDateSelection() {
        LocalDate selectedDate = followUpDatePicker.getValue();
        if (selectedDate != null) {
            System.out.println("Follow-up date: " + selectedDate);
            statusLabel.setText("Confirm the follow-up date.");
        } else {
            statusLabel.setText("No follow-up date selected.");
        }
    }

    /**
     * Handles the Confirm button click action.
     */
    @FXML
    private void handleConfirm(ActionEvent event) {
        String selectedService = serviceComboBox.getValue();
        LocalDate selectedDate = followUpDatePicker.getValue();

        if (selectedService == null || selectedService.isEmpty()) {
            statusLabel.setText("Please select a service.");
            return;
        }

        if (selectedDate == null) {
            statusLabel.setText("Please select a follow-up date.");
            return;
        }

        // Logic to confirm the selected service and follow-up date
        System.out.println("Service confirmed: " + selectedService);
        System.out.println("Follow-up date confirmed: " + selectedDate);

        // Update the status label
        statusLabel.setText("Service and follow-up date confirmed.");
    }
}
