package Models;

import java.util.List;

public class OldCustomer implements Customer {
    private int customerId;
    private String name;
    private String email;
    private String phone;
    private String address;
    private String meterCode;
//    private boolean isNewCustomer = false;
    private List<Complaint> complaints;
    private List<String> unpaidBills; 

    // Constructor
    public OldCustomer(int customerId, String email, String name, String phone, String address, String meterCode, List<Complaint> complaints, List<String> unpaidBills) {
        this.customerId = customerId;
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.address = address;
        this.meterCode = meterCode;
        this.complaints = complaints;
        this.unpaidBills = unpaidBills;
    }

    
    @Override
    public int getCustomerId(){
        return customerId;
    }

    @Override
    public String getName(){
        return name; 
    }

    @Override
    public String getEmail(){
        return email; 
    }

    @Override
    public String getPhone(){
        return phone; 
    }

    @Override
    public String getAddress(){
        return address; 
    }

    @Override
    public String getMeterCode(){
        return meterCode; 
    }

    @Override
    public boolean isNewCustomer(){
//        return isNewCustomer;
        return false;
    }

    public List<Complaint> getComplaints(){
        return complaints;
    }
    public void setComplaints(List<Complaint> complaints){
        this.complaints = complaints; 
    }

    public List<String> getUnpaidBills(){
        return unpaidBills; 
    }
    public void setUnpaidBills(List<String> unpaidBills){
        this.unpaidBills = unpaidBills; 
    }

    public void payBill(String billCode){
        if (unpaidBills.contains(billCode)) {
            unpaidBills.remove(billCode);
            System.out.println("Bill " + billCode + " has been paid.");
        } else {
            System.out.println("Bill " + billCode + " not found or already paid.");
        }
    }

    public void submitMonthlyReading(int reading){
        System.out.println("Monthly reading for meter " + meterCode + " has been submitted: " + reading);
    }

    public void fileComplaint(Complaint complaint){
        complaints.add(complaint);
        System.out.println("Complaint filed for meter " + meterCode + ": " + complaint);
    }

    public void notifyLatePayment(){
        if (unpaidBills.size() >= 3){
            System.out.println("Email sent to " + email + ": Please pay your bills. You have 3 or more unpaid bills.");
        }
    }
}
