package oop.demo1.SanjidaAkterJui_2320087;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;

public class User8goal2Controller {

    @FXML
    private ComboBox<String> listofrecombox;

    @FXML
    private TextArea displayerrordettextarea;

    @FXML
    private Button markresolvedbutton;

    @FXML
    private Button sendnotibutton;

    @FXML
    private void handleMarkResolved() {
        String selectedError = listofrecombox.getValue();
        // Logic to mark the selected error as resolved
        System.out.println("Marking error as resolved: " + selectedError);
        // Implement error resolution logic here
    }

    @FXML
    private void handleSendNotification() {
        String errorDetails = displayerrordettextarea.getText();
        // Logic to send a notification with the error details
        System.out.println("Sending notification with error details: " + errorDetails);
        // Implement notification sending logic here
    }
}