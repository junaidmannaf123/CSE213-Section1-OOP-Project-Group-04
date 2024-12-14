package oop.demo1.SanjidaAkterJui_2320087;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;

public class User8goal5Controller {

    @FXML
    private TableView<?> reporterissuedisplaytableview;

    @FXML
    private TextArea reviewsystemlogstextarea;

    @FXML
    private Button markresolvedbutton;

    @FXML
    private Button sendresolutionnotificationbutton;

    @FXML
    private void handleMarkResolved() {
        // Logic to mark the reported issue as resolved
        System.out.println("Issue marked as resolved.");
        // Implement your logic here
    }

    @FXML
    private void handleSendResolutionNotification() {
        // Logic to send a resolution notification
        System.out.println("Sending resolution notification...");
        // Implement your logic here
    }
}
