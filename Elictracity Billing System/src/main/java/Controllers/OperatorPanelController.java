package Controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import utils.Constants;
import ziad.elictracitybillingsystem.HelloApplication;

import java.io.IOException;
import java.net.URL;
import java.util.Objects;

public class OperatorPanelController {

    @FXML private Button dashboardButton;
    @FXML private Button collectPaymentsButton;
    @FXML private Button validateReadingButton;
    @FXML private Button viewRegionBillsButton;
    @FXML private Button defineTariffButton;
    @FXML private Button stopMeterButton;
    @FXML private Button settingsButton;
    @FXML private Button logOutButton;

    @FXML private Button addNewPaymentButton;
    @FXML private Button printBillButton;
    @FXML private Button viewCustomersButton;
    @FXML private Button reportIssuesButton;
    @FXML private Button tariffManagementButton;
    @FXML private Button customerSubscriptionsButton;

    @FXML private TextField readingField;
    @FXML private TextField meterCodeField;
    @FXML private TextField dateField;
    @FXML private TextField customerIdField;
    @FXML private TextField costField;
    @FXML private TextField regionField;

    @FXML private Button submitPaymentButton;

    @FXML private Label totalPaymentsLabel;
    @FXML private Label pendingBillsLabel;
    @FXML private Label resolvedIssuesLabel;
    @FXML private Label activeCustomersLabel;

    @FXML private TextField searchField;

    @FXML
    public void initialize() {
        System.out.println("Operator Panel Controller Initialized");

        // Linking button actions
        dashboardButton.setOnAction(e -> goToDashboard());
        settingsButton.setOnAction(e -> openSettings());
        logOutButton.setOnAction(e -> {
            try {
                logOut();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        collectPaymentsButton.setOnAction(e -> CollectPayments());

        addNewPaymentButton.setOnAction(e -> addNewPayment());
        viewCustomersButton.setOnAction(e -> viewCustomers());
        reportIssuesButton.setOnAction(e -> reportIssues());
        tariffManagementButton.setOnAction(e -> manageTariffs());
        customerSubscriptionsButton.setOnAction(e -> manageSubscriptions());
    }

    @FXML
    private void goToDashboard() {
        System.out.println("Navigating to Dashboard...");
    }

    @FXML
    private void printBill() throws IOException {
        Parent root = FXMLLoader.load(HelloApplication.class.getResource("PrintBill.fxml"));
        Stage stage = (Stage) Stage.getWindows().getFirst();
        stage.setScene(new Scene(root));
    }

    @FXML
    private void CollectPayments() {
        navigateTo("CollectPayments.fxml", "Collect Payments");
    }

    @FXML
    private void validateReading() {
        navigateTo("ValidateReading.fxml", "Validate Reading");
    }

    @FXML
    private void viewRegionBills() {
        navigateTo("ViewRegionBills.fxml", "View Region Bills");
    }

    @FXML
    private void defineTariff() {
        navigateTo("DefineTariff.fxml", "Define Tariff");
    }

    @FXML
    private void stopMeter() {
        navigateTo("StopMeter.fxml", "Stop Meter");
    }

    private void navigateTo(String fxmlFile, String pageName) {
        try {
            Parent root = FXMLLoader.load(HelloApplication.class.getResource(fxmlFile));
            Stage stage = (Stage) Stage.getWindows().getFirst();
            stage.setScene(new Scene(root));
            System.out.println("Navigated to " + pageName);
//            Stage stage = new Stage();

        } catch (IOException e) {
            System.err.println("Failed to load " + pageName + ": " + e.getMessage());
        }
    }

    @FXML
    private void handleSubmitPayment() {
        String reading = readingField.getText();
        String meterCode = meterCodeField.getText();
        String date = dateField.getText();
        String customerId = customerIdField.getText();
        String cost = costField.getText();
        String region = regionField.getText();

        if (reading.isEmpty() || meterCode.isEmpty() || date.isEmpty()
                || customerId.isEmpty() || cost.isEmpty() || region.isEmpty()) {
            showAlert("Error", "All fields are required.");
            return;
        }

        String successMessage = String.format(
                "Payment Submitted Successfully!\nDetails:\nReading: %s\nMeter Code: %s\nDate: %s\nCustomer ID: %s\nCost: %s\nRegion: %s",
                reading, meterCode, date, customerId, cost, region);

        showAlert("Success", successMessage);
        clearCollectPaymentsFields();
    }

    private void clearCollectPaymentsFields() {
        readingField.clear();
        meterCodeField.clear();
        dateField.clear();
        customerIdField.clear();
        costField.clear();
        regionField.clear();
    }

    private void showAlert(String title, String message) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }

    // Additional methods
    @FXML
    private void openSettings() {
        System.out.println("Opening Settings...");
    }

    @FXML
    private void logOut() throws IOException {
        Stage stage = (Stage) logOutButton.getScene().getWindow();
        stage.close();
        System.out.println("stage closed");
        stage = new Stage();
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("LoginPage.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        System.out.println("file loaded");
        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.setResizable(true);
        stage.show();
    }

    @FXML
    private void addNewPayment() {
        System.out.println("Adding New Payment...");
    }

    @FXML
    private void viewCustomers() {
        System.out.println("Viewing Customers...");
    }

    @FXML
    private void reportIssues() {
        System.out.println("Reporting Issues...");
    }

    @FXML
    private void manageTariffs() {
        System.out.println("Managing Tariffs...");
    }

    @FXML
    private void manageSubscriptions() {
        System.out.println("Managing Subscriptions...");
    }

    @FXML
    private void goBack() throws IOException {
        Stage stage = (Stage) Stage.getWindows().getFirst();
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/src/main/resources/ziad/elictracitybillingsystem/OperatorView.fxml")));
        stage.setScene(new Scene(root));
    }

    public void loadBills(ActionEvent actionEvent) {
        String region = regionField.getText();

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

}
