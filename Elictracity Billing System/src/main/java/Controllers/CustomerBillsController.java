package Controllers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.beans.property.SimpleStringProperty;
import ziad.elictracitybillingsystem.UserUnitTesting;

import java.io.File;
import java.io.FileNotFoundException;
import java.net.URL;
import java.nio.file.Paths;
import java.util.ResourceBundle;
import java.util.Scanner;

public class CustomerBillsController implements Initializable {
    @FXML
    private TableView<String[]> billTble;

    @FXML
    private TableColumn<String[], String> billIdColumn;

    @FXML
    private TableColumn<String[], String> Cost;

    @FXML
    private TableColumn<String[], String> MeterCode;

    @FXML
    private TableColumn<String[], String> Date;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        billIdColumn.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue()[0]));
        Cost.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue()[1]));
        MeterCode.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue()[2]));
        Date.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue()[3]));

        // Add data to the TableView
        ObservableList<String[]> data = FXCollections.observableArrayList();

        Scanner fscanner = new Scanner(System.in);
        String[] compRecord = new String[0];
        try {
            fscanner = new Scanner(new File(String.valueOf(Paths.get("data\\bills.csv"))));
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        while(fscanner.hasNext()){
            String tmp = fscanner.next();
            compRecord = tmp.split(",");
            String[] x = {compRecord[0], compRecord[3], compRecord[2], compRecord[4]};
            data.add(x);
        }

        billTble.setItems(data);
    }
}
