package Controllers;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;

import java.net.URL;
import java.util.ResourceBundle;

public class LoginController implements Initializable {
    @FXML
    private ChoiceBox<String> AccountType;

    private String[] AccountTypes = {"Customer", "Operator", "Admin"};


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        AccountType.getItems().add("Select Account Type");
        AccountType.getItems().addAll(AccountTypes);

        AccountType.setValue("Select Account Type");
    }
}
