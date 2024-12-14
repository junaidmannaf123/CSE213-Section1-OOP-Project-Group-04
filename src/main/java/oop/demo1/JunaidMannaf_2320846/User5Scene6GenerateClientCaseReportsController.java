package oop.demo1.JunaidMannaf_2320846;

import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Paragraph;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;
import java.io.FileOutputStream;
import java.net.URL;
import java.util.ResourceBundle;

public class User5Scene6GenerateClientCaseReportsController implements Initializable {

    @FXML
    private ComboBox<String> clientCaseComboBox;

    @FXML
    private Label statusLabel;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        clientCaseComboBox.getItems().addAll(
                "Case 001 Immigration Sponsorship",
                "Case 002 Legal Document Review",
                "Case 003 Visa Application Assistance",
                "Case 004 Citizenship Process"
        );
    }

    @FXML
    private void handleGenerateReport(ActionEvent event) {
        String selectedCase = clientCaseComboBox.getValue();
        if (selectedCase == null) {
            statusLabel.setText("Please select a client case to generate a report.");
        } else {
            statusLabel.setText("Report generated for case: " + selectedCase);
            System.out.println("Generated report for: " + selectedCase);
        }
    }

    @FXML
    private void handleExportPDF(ActionEvent event) {
        String selectedCase = clientCaseComboBox.getValue();
        if (selectedCase == null) {
            statusLabel.setText("Please select a client case to export as PDF.");
        } else {

            String caseReportContent = generateCaseReport(selectedCase);

            FileChooser fileChooser = new FileChooser();
            fileChooser.setTitle("Save PDF");
            fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("PDF Files", "*.pdf"));
            fileChooser.setInitialFileName(selectedCase + " Report.pdf");
            File saveFile = fileChooser.showSaveDialog(((Node) event.getSource()).getScene().getWindow());

            if (saveFile != null) {
                try (FileOutputStream outputStream = new FileOutputStream(saveFile)) {
                    PdfWriter writer = new PdfWriter(outputStream);
                    PdfDocument pdfDoc = new PdfDocument(writer);
                    Document document = new Document(pdfDoc);

                    document.add(new Paragraph(caseReportContent));

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
    }

    private String generateCaseReport(String selectedCase) {
        String caseReportContent;

        switch (selectedCase) {
            case "Case 001 Immigration Sponsorship":
                caseReportContent = "Case #001: Immigration Sponsorship\n\n" +
                        "Client Name: John Doe\n" +
                        "Sponsorship Type: Family\n" +
                        "Status: Pending\n" +
                        "Documents Submitted: Passport, Marriage Certificate\n" +
                        "Next Steps: Submit additional proof of financial support.\n";
                break;

            case "Case 002 Legal Document Review":
                caseReportContent = "Case #002: Legal Document Review\n\n" +
                        "Client Name: Jane Smith\n" +
                        "Document Type: Contract\n" +
                        "Status: Under Review\n" +
                        "Review Notes: Requires minor modifications.\n" +
                        "Next Steps: Client to review and provide feedback.\n";
                break;

            case "Case 003 Visa Application Assistance":
                caseReportContent = "Case #003: Visa Application Assistance\n\n" +
                        "Client Name: Michael Johnson\n" +
                        "Visa Type: Work Visa\n" +
                        "Status: Application Submitted\n" +
                        "Documents Submitted: Job Offer, Financial Statements\n" +
                        "Next Steps: Wait for consulate response.\n";
                break;

            case "Case 004 Citizenship Process":
                caseReportContent = "Case #004: Citizenship Process\n\n" +
                        "Client Name: Emily Davis\n" +
                        "Citizenship Type: Naturalization\n" +
                        "Status: In Progress\n" +
                        "Documents Submitted: Birth Certificate, Passport\n" +
                        "Next Steps: Attend interview in 2 months.\n";
                break;

            default:
                caseReportContent = "Error: Invalid case selection.";
                break;
        }

        return caseReportContent;
    }

    @FXML
    private void handleSendReport(ActionEvent event) {
        String selectedCase = clientCaseComboBox.getValue();
        if (selectedCase == null) {
            statusLabel.setText("Please select a client case to send the report.");
        } else {
            statusLabel.setText("Report for case '" + selectedCase + "' sent to client/consultant.");
            System.out.println("Sent report for: " + selectedCase);
        }
    }

    @FXML
    private void handleBackToDashboard(ActionEvent event) {
        System.out.println("Navigating back to Dashboard...");
        switchScene(event, "/oop/demo1/Junaid Mannaf/User5CaseManagerDashboard.fxml");
    }

    private void switchScene(ActionEvent event, String fxmlFile) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource(fxmlFile));
            Parent root = loader.load();
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            Scene newScene = new Scene(root);
            stage.setScene(newScene);
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Error while switching scenes: " + e.getMessage());
        }
    }
}
