package oop.demo1.TasninSiza_2130480;

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

        serviceComboBox.getItems().addAll("Language Training", "Job Assistance", "Housing Support");


        statusLabel.setText("Please select a service and follow-up date.");
    }


    @FXML
    private void handleServiceSelection() {
        String selectedService = serviceComboBox.getValue();
        if (selectedService != null) {
            System.out.println("Selected service: " + selectedService);
            statusLabel.setText("Selected service: " + selectedService + ". Now select a follow-up date.");
        } else {
            statusLabel.setText("No service selected. Please select a service.");
        }
    }


    @FXML
    private void handleDateSelection() {
        LocalDate selectedDate = followUpDatePicker.getValue();
        if (selectedDate != null) {
            System.out.println("Follow-up date selected: " + selectedDate);
            statusLabel.setText("Follow-up date selected: " + selectedDate + ". Now confirm your selection.");
        } else {
            statusLabel.setText("No follow-up date selected. Please select a date.");
        }
    }


    @FXML
    private void handleConfirm(ActionEvent event) {
        String selectedService = serviceComboBox.getValue();
        LocalDate selectedDate = followUpDatePicker.getValue();


        if (selectedService == null || selectedService.isEmpty()) {
            statusLabel.setText("Error: Please select a service.");
            System.out.println("Error: No service selected.");
            return;
        }


        if (selectedDate == null) {
            statusLabel.setText("Error: Please select a follow-up date.");
            System.out.println("Error: No follow-up date selected.");
            return;
        }


        if (selectedDate.isBefore(LocalDate.now())) {
            statusLabel.setText("Error: Follow-up date cannot be in the past.");
            System.out.println("Error: Invalid follow-up date.");
            return;
        }


        System.out.println("Service confirmed: " + selectedService);
        System.out.println("Follow-up date confirmed: " + selectedDate);


        statusLabel.setText("Service confirmed: " + selectedService + " on " + selectedDate + ".");
    }
}
