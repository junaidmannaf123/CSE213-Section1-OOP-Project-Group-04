package oop.demo1.SanjidaAkterJui_2320087;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableView;

public class User8goal4Controller {

    @FXML
    private DatePicker sceduleautobckupdatepicker;

    @FXML
    private ComboBox<String> selectbckpfrqnccombox;

    @FXML
    private Button triggerbackupnowbutton;

    @FXML
    private TableView<?> displaybackuplogstableview;

    @FXML
    private Button sendstatusnotibutton;

    @FXML
    private void handleTriggerBackupNow() {
        // Logic to trigger a backup
        System.out.println("Triggering backup now...");
        // Implement backup logic here
    }

    @FXML
    private void handleSendStatusNotification() {
        // Logic to send status notification
        System.out.println("Sending status notification...");
        // Implement status notification logic here
    }
}