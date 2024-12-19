package Models;

import ziad.elictracitybillingsystem.UserUnitTesting;

import java.io.*;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class NewCustomer extends User   {
    private int userId;
    private String name;
    private String email;
    private String phone;
    private String password;
    private String address;
    private String meterCode;
    private String Role = String.valueOf(ROLES.CUSTOMER);
    private String contractFilePath;
    private boolean isMeterReady;
    private String addingDate;
    public boolean sts = false;


    public NewCustomer(int customerId, String name, String email, String phone, String address, String meterCode, String registrationDate, String contractFilePath, String password) throws FileNotFoundException {
        this.userId = customerId;
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.address = address;
        this.meterCode = meterCode;
        this.addingDate = registrationDate;
        this.contractFilePath = contractFilePath;
        this.password = password;
        this.isMeterReady = false;

        if (isEmailUnique(email)) {
            appendToCSV();
        } else {
            System.err.println("Error: Email is already in use.");
        }
    }
    public NewCustomer(int customerId, String name, String email, String phone, String address, String meterCode, String registrationDate, String contractFilePath) {
        this.userId = customerId;
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.address = address;
        this.meterCode = meterCode;
        this.addingDate = registrationDate;
        this.contractFilePath = contractFilePath;
        this.isMeterReady = false;
    }

    private boolean isEmailUnique(String email) throws FileNotFoundException {
        Scanner fscanner = new Scanner(new File(String.valueOf(UserUnitTesting.class.getResource("/Database/UsersInfo.csv")).replace("file:/", "").replace("%20", " ")));
        String[] recordArr = new String[10];

        while(fscanner.hasNext()){
            String record = fscanner.next();
            recordArr = record.split(",");

            if(email.equals(recordArr[1])){
                return false;
            }
        }
        sts=true;
        return true;
    }

    private void appendToCSV() {
        String filePath = String.valueOf(UserUnitTesting.class.getResource("/Database/UsersInfo.csv")).replace("file:/", "").replace("%20"," ");
        String csvLine = String.join(",",
                String.valueOf(userId),
                email,
                password, // Replace with actual password logic if needed
                name,
                phone,
                address,
                meterCode == null ? "NULL" : meterCode,
                addingDate,
                Role
        );

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath, true))) {
            writer.newLine();
            writer.write(csvLine);
        } catch (IOException e) {
            System.err.println("Error writing to CSV: " + e.getMessage());
        }
    }

    @Override
    public int getId() {
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
    public String getPhone(){ return phone; }

    @Override
    public String getAddress(){
        return address; 
    }

    @Override
    public String getMeterCode(){
        return meterCode; 
    }

    public String getRegistrationDate(){
        return addingDate;
    }
    public void setRegistrationDate(String registrationDate){
        this.addingDate = registrationDate;
    }

    public String getContractFilePath(){
        return contractFilePath; 
    }
    public void setContractFilePath(String contractFilePath){
        this.contractFilePath = contractFilePath;
    }

    public boolean isMeterReady(){
        return isMeterReady;
    }
    public void setMeterReady(boolean meterReady){
        isMeterReady = meterReady; 
    }

    public void notifyCustomerByEmail() {
        if (isMeterReady) {
            System.out.println("Email sent to " + email + ": Your meter is ready!");
        }
    }

    public String getRole() {
        return Role;
    }

    @Override
    public String getAddingDate() {
        return addingDate;
    }

    public void setRole(String role) {
        Role = role;
    }
}
