package oop.demo1.TasninSiza_2130480;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;

import java.time.LocalDate;

public class u4g2controller {

    @FXML
    private ComboBox<String> timeSlotComboBox;

    @FXML
    private DatePicker datePicker;


    @FXML
    private void handleDateSelection(ActionEvent event) {
        if (datePicker.getValue() != null) {
            LocalDate selectedDate = datePicker.getValue();
            if (selectedDate.isBefore(LocalDate.now())) {
                System.out.println("Error: Selected date cannot be in the past.");
                timeSlotComboBox.getItems().clear();
                return;
            }
            System.out.println("Selected Date: " + selectedDate);


            populateTimeSlots(selectedDate);
        } else {
            System.out.println("No date selected.");
        }
    }


    @FXML
    private void handleTimeSlotSelection(ActionEvent event) {
        String selectedTimeSlot = timeSlotComboBox.getValue();
        if (selectedTimeSlot != null && !selectedTimeSlot.isEmpty()) {
            System.out.println("Selected Time Slot: " + selectedTimeSlot);
        } else {
            System.out.println("No time slot selected.");
        }
    }


    @FXML
    private void handleConfirm(ActionEvent event) {
        if (datePicker.getValue() == null) {
            System.out.println("Error: Please select a date before confirming.");
            return;
        }

        LocalDate selectedDate = datePicker.getValue();
        if (selectedDate.isBefore(LocalDate.now())) {
            System.out.println("Error: Selected date cannot be in the past.");
            return;
        }

        String selectedTimeSlot = timeSlotComboBox.getValue();

        if (selectedTimeSlot == null || selectedTimeSlot.isEmpty()) {
            System.out.println("Error: Please select a time slot before confirming.");
            return;
        }

        // Confirmation message
        System.out.println("Appointment Confirmed:");
        System.out.println("Date: " + selectedDate);
        System.out.println("Time Slot: " + selectedTimeSlot);


    }


    private void populateTimeSlots(LocalDate date) {
        timeSlotComboBox.getItems().clear();


        if (date.equals(LocalDate.now())) {

            timeSlotComboBox.getItems().addAll(
                    "2:00 PM - 3:00 PM",
                    "3:00 PM - 4:00 PM"
            );
        } else {

            timeSlotComboBox.getItems().addAll(
                    "10:00 AM - 11:00 AM",
                    "11:00 AM - 12:00 PM",
                    "2:00 PM - 3:00 PM",
                    "3:00 PM - 4:00 PM"
            );
        }

        System.out.println("Time slots populated for the date: " + date);
    }


    @FXML
    public void initialize() {
        System.out.println("Controller initialized.");
    }
}
