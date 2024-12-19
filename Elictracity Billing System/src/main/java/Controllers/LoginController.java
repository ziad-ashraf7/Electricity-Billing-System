package Controllers;

import Models.*;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import ziad.elictracitybillingsystem.HelloApplication;
import ziad.elictracitybillingsystem.UserUnitTesting;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.util.*;

public class LoginController implements Initializable {

    static public Scanner scanner = new Scanner(System.in);
    static public Scanner fscanner = new Scanner(System.in);


    static OldCustomer parseCustomerInfoObject(String[] recordArr) throws FileNotFoundException {
        List<Complaint> complaintsTmp = new ArrayList<Complaint>();
        String[] compRecord = new String[0];

        fscanner = new Scanner(new File(String.valueOf(UserUnitTesting.class.getResource("/Database/Complaints.csv")).replace("file:/", "").replace("%20"," ")));
        while(fscanner.hasNext()){
            compRecord = fscanner.next().split(",");
            if(compRecord[0].equals(recordArr[0])){
                complaintsTmp.add(new Complaint(compRecord[0], compRecord[1]));
            }
        }

        List<String> unpaidBillsTmp = new ArrayList<String>();
        List<String> BillsTmp = new ArrayList<String>();
        fscanner = new Scanner(new File(String.valueOf(UserUnitTesting.class.getResource("/Database/Bills.csv")).replace("file:/", "").replace("%20"," ")));
        while(fscanner.hasNext()){
            compRecord = fscanner.next().split(",");
            if(compRecord[1].equals(recordArr[0])){
                BillsTmp.add(compRecord[0]);
                if(compRecord[6].equals("unpaid")){
//                Bill tmp = new Bill(Integer.parseInt(compRecord[0]), Integer.parseInt(compRecord[1]), compRecord[2], Double.parseDouble(compRecord[3]), compRecord[4], compRecord[5]);
                    unpaidBillsTmp.add(compRecord[0]);
                }
            }
        }
//        System.out.println(Arrays.toString(unpaidBillsTmp.toArray()));
        return new OldCustomer(Integer.parseInt(recordArr[0]), recordArr[1], recordArr[3], recordArr[4], recordArr[5], recordArr[6], complaintsTmp, unpaidBillsTmp, BillsTmp);
    }
    static Admin parseAdminInfoObject(String[] recordArr) throws FileNotFoundException {
//        return new Admin(Integer.parseInt(recordArr[0]), recordArr[1], recordArr[2], recordArr[3]);
        return null;
    }
    static Operator parseOperatorInfoObject(String[] recordArr) throws FileNotFoundException {
        return new Operator(Integer.parseInt(recordArr[0]), recordArr[1], recordArr[2], recordArr[3], recordArr[4]);
    }



    @FXML
    private ChoiceBox<String> AccountType;
    @FXML
    private Button loginBtn;
    @FXML
    private Button cracBtn;
    @FXML
    private TextField emailField;
    @FXML
    private TextField passwordField;

    private String[] AccountTypes = {"Customer", "Operator", "Admin"};

    private Login login(String email, String password, String accType) throws IOException {
        String[] recordArr = new String[0];
        if(accType.equals("Customer")){
            fscanner = new Scanner(new File(String.valueOf(UserUnitTesting.class.getResource("/Database/UsersInfo.csv")).replace("file:/", "").replace("%20"," ")));
            recordArr = new String[10];

            while(fscanner.hasNext()){
                String record = fscanner.next();
                recordArr = record.split(",");

                if(email.equals(recordArr[1]) && password.equals(recordArr[2])){
                    Stage cstg = (Stage)loginBtn.getScene().getWindow();
                    cstg.close();
                    FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("Customer_Bills.fxml"));
                    Scene scene = new Scene(fxmlLoader.load());
                    Stage stage = new Stage();
                    stage.setTitle("Hello!");
                    stage.setWidth(1200);
                    stage.setHeight(700);
                    stage.setScene(scene);
                    stage.setResizable(true);

                    stage.show();
                    return new Login(parseCustomerInfoObject(recordArr));
                }
            }
        } else if(accType.equals("Admin")){
            fscanner = new Scanner(new File(String.valueOf(UserUnitTesting.class.getResource("/Database/Admins.csv")).replace("file:/", "").replace("%20"," ")));
            recordArr = new String[0];

            while(fscanner.hasNext()){
                String record = fscanner.next();
                recordArr = record.split(",");

                if(email.equals(recordArr[1]) && password.equals(recordArr[2])){
                    Stage cstg = (Stage)loginBtn.getScene().getWindow();
                    cstg.close();
                    FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("Admin-view.fxml"));
                    Scene scene = new Scene(fxmlLoader.load());
                    Stage stage = new Stage();
                    stage.setTitle("Hello!");
                    stage.setWidth(1200);
                    stage.setHeight(700);
                    stage.setScene(scene);
                    stage.setResizable(true);
                    stage.show();

                    return new Login(parseAdminInfoObject(recordArr));
                }
            }
        } else if(accType.equals("Operator")){
            fscanner = new Scanner(new File(String.valueOf(UserUnitTesting.class.getResource("/Database/Operators.csv")).replace("file:/", "").replace("%20"," ")));
            recordArr = new String[0];

            while(fscanner.hasNext()){
                String record = fscanner.next();
                recordArr = record.split(",");

                if(email.equals(recordArr[1]) && password.equals(recordArr[2])){
                    Stage cstg = (Stage)loginBtn.getScene().getWindow();
                    cstg.close();
                    FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("Admin-view.fxml"));
                    Scene scene = new Scene(fxmlLoader.load());
                    Stage stage = new Stage();
                    stage.setTitle("Hello!");
                    stage.setWidth(1200);
                    stage.setHeight(700);
                    stage.setScene(scene);
                    stage.setResizable(true);
                    stage.show();

                    return new Login(parseOperatorInfoObject(recordArr));
                }
            }
        }
        return null; // Login Error (Wrong Password, Wrong Account Type, Account not found...)
    }

    private void CreateAccount() throws IOException {
        Stage cstg = (Stage)loginBtn.getScene().getWindow();
        cstg.close();
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("RegisterPage.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        Stage stage = new Stage();
        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        AccountType.getItems().addAll(AccountTypes);

        AccountType.setValue("Customer");

        loginBtn.setOnAction(event -> {
            try {
                login(emailField.getText(), passwordField.getText(), AccountType.getSelectionModel().getSelectedItem());
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });

        cracBtn.setOnAction(event -> {
            try {
                CreateAccount();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });

    }
}
