package Controllers.Admin;

import Models.Bill;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.text.Text;
import ziad.elictracitybillingsystem.UserUnitTesting;

import java.io.File;
import java.io.FileNotFoundException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.Scanner;

public class BillsController implements Initializable {
    @FXML
    private TableView<Bill> billTble;

    @FXML
    private TableColumn<Bill, Integer> billIdColumn;

    @FXML
    private TableColumn<Bill, Integer> ownerIDColumn;

    @FXML
    private TableColumn<Bill, String> meterCodeColumn;

    @FXML
    private TableColumn<Bill, Double> costColumn;

    @FXML
    private TableColumn<Bill, String> regionColumn;

    @FXML
    private TableColumn<Bill, String> statusColumn;

    @FXML
    private Text costTxt;

    @FXML
    private ComboBox<String> region;

    @FXML
    private ComboBox<String> paidSt;

    @FXML
    private Text paidcnt;

    @FXML
    private Text unpaidcnt;

    private ObservableList<Bill> billData;

    int totalPaid=0;
    int totalunPaid=0;
    String cRegion = "All";
    String cStatus = "All";

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        region.getItems().addAll("All", "cairo", "giza", "potato", "AlHaram", "Helwan", "Maadi", "Faisal", "ElTagamoa");
        region.setOnAction(event -> {
            cRegion = region.getSelectionModel().getSelectedItem();
            showRegionStatusBased();
        });
        region.getSelectionModel().selectFirst();

        paidSt.getItems().addAll("All", "paid", "unpaid");
        paidSt.setOnAction(event -> {
            cStatus = paidSt.getSelectionModel().getSelectedItem();
            showRegionStatusBased();
        });
        paidSt.getSelectionModel().selectFirst();

        configureTableColumns();

        try {
            loadBillsFromFile();
            paidcnt.setText(Integer.toString(totalPaid));
            unpaidcnt.setText(Integer.toString(totalunPaid));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        showData(billData);
    }

    private void configureTableColumns() {
        billIdColumn.setCellValueFactory(new PropertyValueFactory<>("billId"));
        ownerIDColumn.setCellValueFactory(new PropertyValueFactory<>("customerID"));
        meterCodeColumn.setCellValueFactory(new PropertyValueFactory<>("meterCode"));
        costColumn.setCellValueFactory(new PropertyValueFactory<>("amount"));
        regionColumn.setCellValueFactory(new PropertyValueFactory<>("region"));
        statusColumn.setCellValueFactory(new PropertyValueFactory<>("status"));
    }

    private void loadBillsFromFile() throws FileNotFoundException {
        billData = FXCollections.observableArrayList(); // Initialize the ObservableList

        Scanner fscanner = new Scanner(new File(String.valueOf(UserUnitTesting.class.getResource("/Database/Bills.csv"))
                .replace("file:/", "")
                .replace("%20", " ")));

        while (fscanner.hasNext()) {
            String[] compRecord = fscanner.nextLine().split(",");
            try {
                int billId = Integer.parseInt(compRecord[0]);
                int customerID = Integer.parseInt(compRecord[1]);
                String meterCode = compRecord[2];
                double amount = Double.parseDouble(compRecord[3]);
                String dueDate = compRecord[4];
                String region = compRecord[5];
                String status = compRecord[6];

                if(status.equals("unpaid")){
                    totalunPaid++;
                }  else {
                    totalPaid++;
                }

                Bill tmp = new Bill(billId, customerID, meterCode, amount, dueDate, region, status);
                billData.add(tmp);
            } catch (Exception e) {
                System.err.println("Error parsing record: " + String.join(",", compRecord));
                e.printStackTrace();
            }
        }
    }

    private void showData(ObservableList<Bill> x){
        billTble.setItems(x);
    }
    private void showRegionStatusBased(){
        if(cRegion.equals("All") && cStatus.equals("All"))
            showData(billData);
        else{
            ObservableList<Bill> tmp = FXCollections.observableArrayList();
            for(Bill x : billData){
                if(cRegion.equals("All") || cRegion.equals(x.getRegion()))
                    if(cStatus.equals("All") || cStatus.equals(x.getStatus()))
                        tmp.add(x);
            }
            showData(tmp);
        }
    }


}
