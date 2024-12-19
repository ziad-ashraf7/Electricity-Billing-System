package Controllers;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import utils.Constants;
import utils.FileManager;

import java.io.File;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class DeleteUser implements Initializable {
    @FXML
    private TextField IdTF;

    @FXML
    private Label delBtn;

    @FXML
    private Label errMsg;

    @FXML
    void deletUser(MouseEvent event) {

        List<String> data = FileManager.readFromFile(Constants.USER_INFO);
        for (int i = 0; i < data.size(); i++) {
            String[] rec = data.get(i).split(",");
            if (rec[0].equals(IdTF.getText())) {
                System.out.println("User has been deleted successfully");
                errMsg.setText("User has been deleted successfully");
                errMsg.setVisible(true);
                errMsg.setTextFill(Color.GREEN);
                FileManager.deleteFromFile(Constants.USER_INFO, i);
                return;
            }
        }
        errMsg.setText("User Not Found");
        errMsg.setVisible(true);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        errMsg.setVisible(false);
    }
}
