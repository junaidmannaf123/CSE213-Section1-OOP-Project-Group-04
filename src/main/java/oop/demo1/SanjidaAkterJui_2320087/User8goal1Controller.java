package oop.demo1.SanjidaAkterJui_2320087;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

public class User8goal1Controller {

    @FXML
    private TableView<?> alluseraccdisplaytableview;

    @FXML
    private TextField addupduserdtlstextfield;

    @FXML
    private Button adduserbutton;

    @FXML
    private ComboBox<?> selectrolecombox;

    @FXML
    private Button savechangesbutton;

    @FXML
    private Button removeuserbutton;

    @FXML
    private void handleAddUser() {
        String userDetails = addupduserdtlstextfield.getText();
        String selectedRole = selectrolecombox.getValue().toString();

        // Logic to add a user with the provided details and role
        System.out.println("Adding user: " + userDetails + " with role: " + selectedRole);
        // Implement further user addition logic here
    }

    @FXML
    private void handleSaveChanges() {
        // Logic to save any changes made to user accounts
        System.out.println("Saving changes to user accounts.");
        // Implement save logic here
    }

    @FXML
    private void handleRemoveUser() {
        // Logic to remove the selected user
        System.out.println("Removing selected user.");
        // Implement user removal logic here
    }
}