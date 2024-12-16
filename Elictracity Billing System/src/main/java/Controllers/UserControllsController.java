package Controllers;

import Models.Admin;
import Models.NewCustomer;
import Models.User;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableRow;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import utils.FileManager;

import java.io.File;
import java.net.URL;
import java.time.LocalDate;
import java.util.List;
import java.util.ResourceBundle;

public class UserControllsController implements Initializable {

    @FXML
    private TableView<User> tble;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        tble.getColumns().get(0).setCellValueFactory(new PropertyValueFactory<>("id"));
        tble.getColumns().get(1).setCellValueFactory(new PropertyValueFactory<>("name"));
        tble.getColumns().get(2).setCellValueFactory(new PropertyValueFactory<>("email"));
        tble.getColumns().get(3).setCellValueFactory(new PropertyValueFactory<>("addingDate"));
        tble.getColumns().get(4).setCellValueFactory(new PropertyValueFactory<>("Role"));
        List<String> data = FileManager.readFromFile("D:\\Projects\\JavaFX\\Electricity-Billing-System\\Elictracity Billing System\\src\\main\\resources\\Database\\UsersInfo.csv");

        for (int i = 0; i < data.size(); i++) {
            String line = data.get(i);
            String[] records = line.split(",");
            if (records[6].equals("Admin")) {
                Admin admin = new Admin(Integer.parseInt(records[0]),
                        records[1],
                        records[2],
                        records[3],
                        records[8]);
                tble.getItems().add(admin);
            } else {
                NewCustomer newCustomer = new NewCustomer(Integer.parseInt(records[0]),
                        records[3],
                        records[1],
                        records[4],
                        records[5],
                        records[6],
                        "" + LocalDate.now(),
                        "hell");
                tble.getItems().add(newCustomer);
            }


        }

    }
}
