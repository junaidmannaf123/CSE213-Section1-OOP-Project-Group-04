package oop.demo1.SanjidaAkterJui_2320087;

import javafx.fxml.FXML;
import javafx.scene.chart.LineChart;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class User8goal3Controller {

    @FXML
    private TextField usernametextfield;

    @FXML
    private TextField passwordtextfield;

    @FXML
    private Button loginbutton;

    @FXML
    private LineChart<String, Number> linechartfx;

    @FXML
    private Button flaggissuebutton;

    @FXML
    private Button sendteamnotibutton;

    @FXML
    private TextArea describeconfchngtextarea;

    @FXML
    private Button saveupdatesbutton;

    @FXML
    private void handleLogin() {
        String username = usernametextfield.getText();
        String password = passwordtextfield.getText();
        // Logic to handle login
        System.out.println("Logging in with username: " + username + " and password: " + password);
        // Implement login logic here
    }

    @FXML
    private void handleFlagIssue() {
        String issueDescription = describeconfchngtextarea.getText();
        // Logic to flag the issue
        System.out.println("Flagging issue with description: " + issueDescription);
        // Implement flagging issue logic here
    }

    @FXML
    private void handleSendTeamNotification() {
        String issueDescription = describeconfchngtextarea.getText();
        // Logic to send team notification
        System.out.println("Sending team notification with issue description: " + issueDescription);
        // Implement notification sending logic here
    }

    @FXML
    private void handleSaveUpdates() {
        String configChanges = describeconfchngtextarea.getText();
        // Logic to save configuration updates
        System.out.println("Saving configuration updates: " + configChanges);
        // Implement save updates logic here
    }
}