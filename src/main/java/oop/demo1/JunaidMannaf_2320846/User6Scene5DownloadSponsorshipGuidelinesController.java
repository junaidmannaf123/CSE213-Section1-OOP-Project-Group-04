package oop.demo1.JunaidMannaf_2320846;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Paragraph;

import java.io.File;
import java.io.FileOutputStream;

public class User6Scene5DownloadSponsorshipGuidelinesController {

    @FXML
    private ComboBox<String> guidelinesComboBox;

    @FXML
    private Button downloadButton;

    @FXML
    private Label statusLabel;

    @FXML
    private Button backButton;

    @FXML
    void initialize() {
        guidelinesComboBox.getItems().addAll(
                "General Sponsorship Guidelines",
                "Business Sponsorship Guidelines",
                "Family Sponsorship Guidelines"
        );
        guidelinesComboBox.getSelectionModel().selectFirst();
    }

    @FXML
    void handleDownloadGuidelines(ActionEvent event) {
        String selectedGuideline = guidelinesComboBox.getValue();
        String guidelineContent;

        switch (selectedGuideline) {
            case "General Sponsorship Guidelines":
                guidelineContent = "General Sponsorship Guidelines:\n\n- Ensure all required documents are submitted.\n- Maintain communication with the sponsor.\n- Follow the processing timeline.";
                break;
            case "Business Sponsorship Guidelines":
                guidelineContent = "Business Sponsorship Guidelines:\n\n- Provide proof of business registration.\n- Include financial statements.\n- Submit a detailed sponsorship plan.";
                break;
            case "Family Sponsorship Guidelines":
                guidelineContent = "Family Sponsorship Guidelines:\n\n- Provide proof of relationship.\n- Submit identity documents.\n- Ensure financial support affidavits are included.";
                break;
            default:
                statusLabel.setText("Error: Invalid selection.");
                return;
        }

        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Save PDF");
        fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("PDF Files", "*.pdf"));
        fileChooser.setInitialFileName(selectedGuideline + ".pdf");
        File saveFile = fileChooser.showSaveDialog(downloadButton.getScene().getWindow());

        if (saveFile != null) {
            try (FileOutputStream outputStream = new FileOutputStream(saveFile)) {

                PdfWriter writer = new PdfWriter(outputStream);
                PdfDocument pdfDoc = new PdfDocument(writer);
                Document document = new Document(pdfDoc);
                document.add(new Paragraph(guidelineContent));
                document.close();

                statusLabel.setText("Downloaded: " + saveFile.getName());
            } catch (Exception e) {
                statusLabel.setText("Error saving the file.");
                e.printStackTrace();
            }
        } else {
            statusLabel.setText("Download canceled.");
        }
    }

    @FXML
    private void handleBack(ActionEvent event) {
        System.out.println("Navigating back to the previous screen...");
        switchScene(event, "/oop/demo1/Junaid Mannaf/User6ClientFSDashboard.fxml");
    }

    private void switchScene(ActionEvent event, String fxmlFile) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource(fxmlFile));
            Parent root = loader.load();
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Error while switching scenes: " + e.getMessage());
        }
    }
}
