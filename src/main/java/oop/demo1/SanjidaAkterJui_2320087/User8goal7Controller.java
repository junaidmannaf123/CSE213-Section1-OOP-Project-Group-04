package oop.demo1.SanjidaAkterJui_2320087;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

public class User8goal7Controller {

    @FXML
    private TableView<?> rolespermissiontableview;

    @FXML
    private TextField editpermisntextfield;

    @FXML
    private Button savechangesbutton;

    @FXML
    private Button notifyusersbutton;

    @FXML
    private void handleSaveChanges() {
        // Logic to handle saving changes to permissions
        String editedPermission = editpermisntextfield.getText();
        System.out.println("Saving changes for permission: " + editedPermission);
        // Implement your logic here
    }

    @FXML
    private void handleNotifyUsers() {
        // Logic to notify users about permission changes
        System.out.println("Sending notification to users about permission changes.");
        // Implement your logic here
    }
}