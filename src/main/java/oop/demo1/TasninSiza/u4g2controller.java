package oop.demo1.TasninSiza;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;

public class u4g2controller {

    @FXML
    private ComboBox<String> timeSlotComboBox;

    @FXML
    private DatePicker datePicker;

    /**
     * This method handles the selection of a date from the DatePicker.
     */
    @FXML
    private void handleDateSelection(ActionEvent event) {
        if (datePicker.getValue() != null) {
            String selectedDate = datePicker.getValue().toString();
            System.out.println("Selected Date: " + selectedDate);

            // Example logic: Populate time slots for the selected date
            populateTimeSlots(selectedDate);
        } else {
            System.out.println("No date selected.");
        }
    }

    /**
     * This method handles the selection of a time slot from the ComboBox.
     */
    @FXML
    private void handleTimeSlotSelection(ActionEvent event) {
        String selectedTimeSlot = timeSlotComboBox.getValue();
        System.out.println("Selected Time Slot: " + selectedTimeSlot);
    }

    /**
     * This method handles the confirmation action when the "Confirm" button is clicked.
     */
    @FXML
    private void handleConfirm(ActionEvent event) {
        if (datePicker.getValue() == null) {
            System.out.println("Please select a date before confirming.");
            return;
        }

        String selectedDate = datePicker.getValue().toString();
        String selectedTimeSlot = timeSlotComboBox.getValue();

        if (selectedTimeSlot == null || selectedTimeSlot.isEmpty()) {
            System.out.println("Please select a time slot before confirming.");
            return;
        }

        System.out.println("Appointment Confirmed:");
        System.out.println("Date: " + selectedDate);
        System.out.println("Time Slot: " + selectedTimeSlot);

        // You can add logic here to save the appointment details in a database or file
    }

    /**
     * Initializes the ComboBox with available time slots.
     * You can call this method dynamically when a date is selected.
     */
    private void populateTimeSlots(String date) {
        timeSlotComboBox.getItems().clear();

        // Example: Add time slots dynamically based on the selected date
        timeSlotComboBox.getItems().addAll(
                "10:00 AM - 11:00 AM",
                "11:00 AM - 12:00 PM",
                "2:00 PM - 3:00 PM",
                "3:00 PM - 4:00 PM"
        );

        System.out.println("Time slots populated for the date: " + date);
    }

    /**
     * Initialize method to set up initial configurations when the controller is loaded.
     */
    @FXML
    public void initialize() {
        // Optional: Set default time slots or other configurations
        System.out.println("Controller initialized.");
    }
}
