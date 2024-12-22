package Controllers;

import Models.NewCustomer;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import ziad.elictracitybillingsystem.HelloApplication;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.ResourceBundle;

public class RegisterController implements Initializable {
    @FXML
    private TextField nameField;

    @FXML
    private TextField emailField;

    @FXML
    private TextField phoneField;

    @FXML
    private TextField addressField;

    @FXML
    private TextField passwordField;

    @FXML
    private Button registerButton;

    @FXML
    private Button logBackButton;

    @FXML
    private Button uploadContractButton;

    private String contractFilePath;

    private void backLogin() throws IOException {
        Stage cstg = (Stage)logBackButton.getScene().getWindow();
        cstg.close();
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("LoginPage.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        Stage stage = new Stage();
        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        logBackButton.setOnAction(event -> {
            try {
                backLogin();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });
        registerButton.setOnAction(event -> handleRegister());
        uploadContractButton.setOnAction(event -> handleUploadContract());
    }

    private void handleUploadContract() {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Select Contract File");
        File selectedFile = fileChooser.showOpenDialog(new Stage());

        if (selectedFile != null) {
            contractFilePath = selectedFile.getAbsolutePath();
//            System.out.println("Selected Contract File: " + contractFilePath);
        } else {
            System.out.println("No file selected.");
        }
    }

    private void handleRegister() {
        try {
            if (nameField.getText().isEmpty() ||
                    emailField.getText().isEmpty() ||
                    phoneField.getText().isEmpty() ||
                    addressField.getText().isEmpty() ||
                    passwordField.getText().isEmpty() ||
                    contractFilePath == null) {
                System.out.println("All fields are required.");
                return;
            }

            int generatedId = (int) (System.currentTimeMillis() % Integer.MAX_VALUE);
            String currentDate = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
            NewCustomer newCustomer = new NewCustomer(
                    generatedId,
                    nameField.getText(),
                    emailField.getText(),
                    phoneField.getText(),
                    addressField.getText(),
                    null,
                    currentDate,
                    contractFilePath,
                    passwordField.getText()
            );

            if(newCustomer.sts){
//                System.out.println("User registered successfully:");
//            System.out.println("ID: " + newCustomer.getUserId());
//                System.out.println("Name: " + newCustomer.getName());
//                System.out.println("Email: " + newCustomer.getEmail());
//                System.out.println("Phone: " + newCustomer.getPhone());
//                System.out.println("Address: " + newCustomer.getAddress());
//                System.out.println("Date: " + newCustomer.getAddingDate());
//                System.out.println("Contract File: " + newCustomer.getContractFilePath());

                backLogin();
            } else{
                System.out.println("User already registered.");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
