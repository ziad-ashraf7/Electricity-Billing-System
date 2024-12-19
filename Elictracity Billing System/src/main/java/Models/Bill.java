package Models;

import ziad.elictracitybillingsystem.UserUnitTesting;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Bill {
    private int billId;
    private int CustomerID;
    private String meterCode;
    private double amount;
    private String status = "unpaid"; // true for paid, false for unpaid
    private String dueDate;
    private String region;

    public Bill(int billId, int CustomerID, String meterCode, double amount, String dueDate , String region) {
        this.billId = billId;
        this.CustomerID = CustomerID;
        this.meterCode = meterCode;
        this.amount = amount;
        this.dueDate = dueDate;
        this.region = region;
    }
    public Bill(int billId, int CustomerID, String meterCode, double amount, String dueDate , String region, String status) {
        this.billId = billId;
        this.CustomerID = CustomerID;
        this.meterCode = meterCode;
        this.amount = amount;
        this.dueDate = dueDate;
        this.region = region;
        this.status = status;
    }

    public String getRegion() {return region;}

    public void setRegion(String region) {this.region = region;}


    public int getCustomerID(){
        return CustomerID;
    }

    public int getBillId(){
        return billId;
    }
    public void setBillId(int billId){
        this.billId = billId;
    }

    public String getMeterCode(){
        return meterCode;
    }
    public void setMeterCode(String meterCode){
        this.meterCode = meterCode;
    }

    public double getAmount(){
        return amount;
    }
    public void setAmount(double amount){
        this.amount = amount;
    }

    public boolean isPaid(){
        return status.equals("paid");
    }
    public void setPaid(String paid){
        status = paid;
    }

    public String getDueDate(){
        return dueDate;
    }
    public void setDueDate(String dueDate){
        this.dueDate = dueDate;
    }

    public String getStatus(){
        return status;
    }

    static String getBillInfo(String BillID) throws FileNotFoundException {
        Scanner fscanner = new Scanner(System.in);
        String[] compRecord = new String[0];
        fscanner = new Scanner(new File(String.valueOf(UserUnitTesting.class.getResource("/Database/Bills.csv")).replace("file:/", "").replace("%20"," ")));
        while(fscanner.hasNext()){
            String tmp = fscanner.next();
            compRecord = tmp.split(",");
            if(compRecord[0].equals(BillID)){
                return tmp;
            }
        }
        return "";
    }
   
    public double calculateLateFee(int lateDays, double dailyRate) {
        return lateDays * dailyRate;
    }
}
