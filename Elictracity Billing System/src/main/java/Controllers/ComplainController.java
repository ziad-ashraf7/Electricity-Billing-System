package Controllers;

import Models.Complaint;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import ziad.elictracitybillingsystem.UserUnitTesting;

import java.io.*;

public class ComplainController {

    @FXML
    private TextArea complainTextArea;

    @FXML
    private Button submitButton;

    @FXML
    private Button cancelButton;

    @FXML
    public void initialize() {
        // Handle the Submit button
        submitButton.setOnAction(event -> {
            try {
                String complaintFl = "data\\complaints.csv";
                String firstLine = readFirstLine("data\\customers.csv").split(",")[0];

                String msg = complainTextArea.getText();

                // Check if the TextArea is empty
                if (msg.isEmpty()) {
                    System.out.println("Complaint text cannot be empty.");
                } else {
                    try (BufferedWriter writer = new BufferedWriter(new FileWriter(complaintFl, true))) {
                        writer.newLine();
                        writer.write(String.join(",", firstLine, msg));
                    } catch (IOException e) {
                        System.err.println("Error writing to CSV: " + e.getMessage());
                    }
                    Complaint tmp = new Complaint(firstLine, msg);
                    ((Stage)cancelButton.getScene().getWindow()).close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        });

        cancelButton.setOnAction(event -> {
            ((Stage)cancelButton.getScene().getWindow()).close();
        });
    }

    private String readFirstLine(String filePath) throws IOException {
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            return reader.readLine();
        }
    }
}
