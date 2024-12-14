package oop.demo1.SanjidaAkterJui_2320087;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;

public class User7goal8Controller {

    @FXML
    private ComboBox<String> topicofresrchcombox;

    @FXML
    private TextArea inputfindingstextarea;

    @FXML
    private Button sendresearchfindingsbutton;

    @FXML
    private void handleSendResearchFindings() {
        // Logic to handle sending research findings
        String selectedTopic = topicofresrchcombox.getValue();
        String findings = inputfindingstextarea.getText();

        System.out.println("Research findings sent for topic: " + selectedTopic);
        System.out.println("Findings: " + findings);
        // Implement further processing as needed
    }
}