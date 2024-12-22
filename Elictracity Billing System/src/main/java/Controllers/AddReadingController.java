package Controllers;

import Models.Complaint;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import ziad.elictracitybillingsystem.UserUnitTesting;

import java.io.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.UUID;

public class AddReadingController {

    @FXML
    private Button submitButton;

    @FXML
    private Button cancelButton;

    @FXML
    private TextField readingInput;

    @FXML
    private TextField meterCodeInput;

    @FXML
    private DatePicker dateInput;

    public void initialize() {
        // Handle the Submit button
        submitButton.setOnAction(event -> {
            try {
                String complaintFl = "data\\complaints.csv";
                String firstLine = readFirstLine("data\\customers.csv").split(",")[0];

                String generatedId = UUID.randomUUID().toString();

                // Get user input values
                String reading = readingInput.getText();
                String meterCode = meterCodeInput.getText();
                LocalDate date = dateInput.getValue();
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                String dateString = date.format(formatter);

                // Validate inputs
                if (reading.isEmpty() || meterCode.isEmpty() || date == null) {
                    System.out.println("All fields are required!");
                    return;
                }

                // Process the data (e.g., save to file)
                String record = String.join(",",
                        generatedId,
                        firstLine,
                        meterCode,
                        dateString,
                        reading
                );

                saveToFile(String.valueOf(UserUnitTesting.class.getResource("/Database/Readings.csv")).replace("file:/", "").replace("%20"," "), record);

                ((Stage) submitButton.getScene().getWindow()).close();

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
private void saveToFile(String filePath, String record) throws IOException {
    try (FileWriter writer = new FileWriter(filePath, true)) {
        writer.append("\n");
        writer.write(record + System.lineSeparator());
    }
}
}
