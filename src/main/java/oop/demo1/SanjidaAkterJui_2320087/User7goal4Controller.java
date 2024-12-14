package oop.demo1.SanjidaAkterJui_2320087;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;

public class User7goal4Controller {

    @FXML
    private ComboBox<String> loccombobox;

    @FXML
    private DatePicker appntmntdatepicker;

    @FXML
    private Button confappntmntbutton;

    @FXML
    private Button confemailbutton;

    @FXML
    private void handleConfirmAppointment() {
        // Logic to handle confirming the appointment
        System.out.println("Confirm Appointment button clicked.");
    }

    @FXML
    private void handleSendConfirmationEmail() {
        // Logic to handle sending the confirmation email
        System.out.println("Send Confirmation Email button clicked.");
    }
}