package Models;

public class Bill {
    private int billId;
    private String meterCode; 
    private double amount; 
    private boolean isPaid;
    private String dueDate; 

    
    public Bill(int billId, String meterCode, double amount, boolean isPaid, String dueDate) {
        this.billId = billId;
        this.meterCode = meterCode;
        this.amount = amount;
        this.isPaid = isPaid;
        this.dueDate = dueDate;
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
        return isPaid;
    }
    public void setPaid(boolean paid){
        isPaid = paid; 
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
