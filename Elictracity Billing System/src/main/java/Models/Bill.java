package Models;

public class Bill {
    private int billId;
    private int CustomerID;
    private String meterCode;
    private double amount;
    private boolean status = false; // true for paid, false for unpaid
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

    public String getRegion() {return region;}

    public void setRegion(String region) {this.region = region;}


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
        return status;
    }
    public void setPaid(boolean paid){
        status = paid;
    }

    public String getDueDate(){
        return dueDate; 
    }
    public void setDueDate(String dueDate){
        this.dueDate = dueDate; 
    }

   
    public double calculateLateFee(int lateDays, double dailyRate) {
        return lateDays * dailyRate;
    }
}
