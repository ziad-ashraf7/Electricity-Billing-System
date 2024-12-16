package Controllers;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableView;
import javafx.scene.text.Text;

import java.net.URL;
import java.util.ResourceBundle;

public class BillsController implements Initializable {
    @FXML
    private TableView<?> billTble;

    @FXML
    private Text costTxt;

    @FXML
    private ComboBox<String > region;
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        region.getItems().addAll("AlHaram","Helwan","Maadi");
        region.setOnAction(event -> {
            String s = region.getSelectionModel().getSelectedItem();
            System.out.println(s);
        });
    }
}
