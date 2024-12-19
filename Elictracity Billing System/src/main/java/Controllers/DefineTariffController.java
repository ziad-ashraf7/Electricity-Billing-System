package Controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import ziad.elictracitybillingsystem.HelloApplication;

import java.io.IOException;

public class DefineTariffController {

    @FXML
    private TextField costField;

    @FXML
    private TextField customerIdField;
    public void saveTariff(ActionEvent actionEvent) {
        String category = customerIdField.getText();
        String tariffInput = costField.getText();

        if (category == null || category.isEmpty() || tariffInput == null || tariffInput.isEmpty()) {
            showAlert("Error", "Please enter both category and tariff value.");
            return;
        }

        try {
            double tariff = Double.parseDouble(tariffInput);
            System.out.println("Saving Tariff: Category = " + category + ", Rate = " + tariff);

            String successMessage = String.format("Tariff saved successfully!\nCategory: %s\nRate: %.2f", category, tariff);
            showAlert("Success", successMessage);

        } catch (NumberFormatException e) {
            showAlert("Error", "Please enter a valid numeric value for the tariff.");
        }
    }

    public void goBack(ActionEvent actionEvent) throws IOException {
        Stage stage = (Stage) Stage.getWindows().getFirst();
        Parent root = FXMLLoader.load(HelloApplication.class.getResource("OperatorView.fxml"));
        stage.setScene(new Scene(root));
    }
    private void showAlert(String title, String message) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
}
