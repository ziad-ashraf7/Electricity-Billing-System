package Controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.stage.Stage;
import ziad.elictracitybillingsystem.HelloApplication;

import java.io.IOException;

public class ViewRegionalBillsController {

    private void showAlert(String title, String message) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }

    public void loadBills(ActionEvent actionEvent) {
        String region = "Alharam";

        if (region == null || region.isEmpty()) {
            showAlert("Error", "Please enter a region to load bills.");
            return;
        }

        // مثال على منطق التحميل: يمكن هنا ربط قاعدة بيانات لتحميل البيانات الحقيقية
        System.out.println("Loading bills for region: " + region);

        String exampleBills = """
            Region: %s
            Bill 1: $120
            Bill 2: $200
            Bill 3: $150
            """.formatted(region);

        showAlert("Bills Loaded", "Here are the bills for the region:\n" + exampleBills);
    }

    public void goBack(ActionEvent actionEvent) throws IOException {
        Stage stage = (Stage) Stage.getWindows().getFirst();
        Parent root = FXMLLoader.load(HelloApplication.class.getResource("OperatorView.fxml"));
        stage.setScene(new Scene(root));
    }
}
