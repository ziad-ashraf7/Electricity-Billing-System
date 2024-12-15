package Controllers;
import Models.NewCustomer;
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
import java.util.List;
import java.util.ResourceBundle;

public class UserControllsController implements Initializable {

    @FXML
    private TableView<NewCustomer> tble;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        NewCustomer costumer = new NewCustomer(1 ,
                "ziad" ,
                "ziad@gmail.com",
                "0121254514" ,
                "ay 7aga" ,
                "1234" ,
                "8/12/2004" ,
                "A7a");

        tble.getColumns().get(0).setCellValueFactory(new PropertyValueFactory<>("customerId"));
        tble.getColumns().get(1).setCellValueFactory(new PropertyValueFactory<>("name"));
        tble.getColumns().get(2).setCellValueFactory(new PropertyValueFactory<>("email"));
        tble.getColumns().get(3).setCellValueFactory(new PropertyValueFactory<>("registrationDate"));
        List<String> data = FileManager.readFromFile("D:\\Projects\\JavaFX\\Electricity-Billing-System\\Elictracity Billing System\\src\\main\\resources\\Database\\UsersInfo.csv");
        tble.setRowFactory(tv -> {
            TableRow<NewCustomer> row = new TableRow<>();
            row.itemProperty().addListener((obs, oldItem, newItem) -> {
                if(row.isEmpty()){
                    row.setVisible(false);
                }
            });
            return row;
        });
        for (int i = 0; i < data.size(); i++) {
            String line = data.get(i);
            String [] records = line.split(",");
            NewCustomer newCustomer = new NewCustomer( Integer.parseInt(records[0]) ,
                    records[3] ,
                    records[1] ,
                    records[4] ,
                    records[5],
                    records[6],
                    "hello",
                    "hell");

            tble.getItems().add(newCustomer);

        }

    }
}
