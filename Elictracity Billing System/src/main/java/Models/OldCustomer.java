package Models;

import ziad.elictracitybillingsystem.UserUnitTesting;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.Scanner;

public class OldCustomer extends User  {
    private int userId;
    private String name;
    private String email;
    private String phone;
    private String address;
    private String meterCode;
    //    private boolean isNewCustomer = false;
    private List<Complaint> complaints;
    private List<String> unpaidBills;
    private List<String> Bills;
    private List<String> Readings;

    // Constructor
    public OldCustomer(int customerId, String email, String name, String phone, String address, String meterCode, List<Complaint> complaints, List<String> unpaidBills, List<String> Bills, List<String> Readings) {
        this.userId = customerId;
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.address = address;
        this.meterCode = meterCode;
        this.complaints = complaints;
        this.unpaidBills = unpaidBills;
        this.Bills = Bills;
        this.Readings = Readings;
    }
    public OldCustomer(int customerId, String email, String name, String phone, String address, String meterCode, List<Complaint> complaints, List<String> unpaidBills, List<String> Bills) {
        this.userId = customerId;
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.address = address;
        this.meterCode = meterCode;
        this.complaints = complaints;
        this.unpaidBills = unpaidBills;
        this.Bills = Bills;
    }

    @Override
    int getId() {
        return userId;
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
    String getRole() {
        return "";
    }

    @Override
    String getAddingDate() {
        return "";
    }


    static String getContractPath(int usrID) throws FileNotFoundException {
        Scanner fscanner = new Scanner(System.in);
        String[] compRecord = new String[0];
        fscanner = new Scanner(new File(String.valueOf(UserUnitTesting.class.getResource("/Database/Contracts.csv")).replace("file:/", "").replace("%20"," ")));
        while(fscanner.hasNext()){
            String tmp = fscanner.next();
            compRecord = tmp.split(",");
            if(compRecord[0].equals(Integer.toString(usrID))){
                return compRecord[1];
            }
        }
        return "";
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
    public List<String> getBills(){
        return Bills;
    }
    public List<String> getReadings(){
        return Readings;
    }
    public void setUnpaidBills(List<String> unpaidBills){
        this.unpaidBills = unpaidBills;
    }

    public void payBill(String billCode) throws FileNotFoundException {
        if (unpaidBills.contains(billCode)) {
            String filePath = String.valueOf(UserUnitTesting.class.getResource("/Database/Bills.csv")).replace("file:/", "").replace("%20"," "); // File path
            List<String> allRows = new ArrayList<>();
            boolean isBillUpdated = false;

            try (Scanner scanner = new Scanner(new File(filePath))) {
                while(scanner.hasNextLine()) {
                    String currentLine = scanner.nextLine();
                    String[] recordArr = currentLine.split(",");

                    if (billCode.equals(recordArr[0])) {
                        recordArr[6] = "true";
                        currentLine = String.join(",", recordArr);
                        isBillUpdated = true;
                    }
                    allRows.add(currentLine);
                }
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }

            try (PrintWriter writer = new PrintWriter(new FileWriter(filePath))) {
                for (String row : allRows) {
                    writer.println(row);
                }
                if (isBillUpdated) {
                    unpaidBills.remove(billCode);
                    System.out.println("Bill " + billCode + " has been paid.");
                } else {
                    System.out.println("Bill " + billCode + " not found.");
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
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