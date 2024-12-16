package Controllers;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import utils.FileManager;
import utils.IDGen;

import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;

public class AddUser implements Initializable {
    @FXML
    private TextField FNameTF;

    @FXML
    private Label errMsg;

    @FXML
    private TextField LNameTF;

    @FXML
    private TextField MNameTF;

    @FXML
    private TextField emailTF;

    @FXML
    private ComboBox<String> roleSelect;

    @FXML
    void Cancel(MouseEvent event) {
        Stage stage = (Stage) emailTF.getScene().getWindow();
        stage.close();
    }

    @FXML
    private PasswordField pwTF;

    @FXML
    private TextField showPwTF;

    @FXML
    private CheckBox showPwBtn;
    @FXML
    void addUser(MouseEvent event) {
        if(FNameTF.getText().isEmpty()){
            errMsg.setText("Please Enter First Name");
            errMsg.setVisible(true);
            return;
        }
        if(MNameTF.getText().isEmpty()){
            errMsg.setText("Please Enter Middle Name");
            errMsg.setVisible(true);
            return;
        }
        if(LNameTF.getText().isEmpty()){
            errMsg.setText("Please Enter Last Name");
            errMsg.setVisible(true);
            return;
        }
        if(emailTF.getText().isEmpty()){
            errMsg.setText("Please Enter Email");
            errMsg.setVisible(true);
            return;
        }
        if(pwTF.getText().isEmpty()){
            errMsg.setText("Please Enter Password");
            errMsg.setVisible(true);
            return;
        }
        if (roleSelect.getSelectionModel().getSelectedItem() == null){
            errMsg.setText("Please Select Role");
            errMsg.setVisible(true);
            return;
        }
        errMsg.setVisible(false);
        String role = roleSelect.getSelectionModel().getSelectedItem();
        int id = IDGen.generateID();
        String name = FNameTF.getText();
        String email = emailTF.getText();
        String pw = pwTF.getText();
        String path = "D:\\Projects\\JavaFX\\Electricity-Billing-System\\Elictracity Billing System\\src\\main\\resources\\Database\\UsersInfo.csv";
        FileManager.saveToFile(path , String.valueOf(id) + "," + email + ',' + pw + ',' + name + ",0120215458" + ",15 helwan st," + role + "," + "5120202," + LocalDate.now());

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        errMsg.setVisible(false);
        roleSelect.getItems().addAll("Admin", "Customer");
        showPwTF.setVisible(false);
        showPwTF.textProperty().bindBidirectional(pwTF.textProperty());
        showPwTF.visibleProperty().bind(showPwBtn.selectedProperty());
        pwTF.visibleProperty().bind(showPwTF.visibleProperty().not());

    }
}
