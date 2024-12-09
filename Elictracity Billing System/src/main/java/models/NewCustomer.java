package models;

public class NewCustomer implements Customer {
    private int customerId;
    private String name;
    private String email;
    private String phone;
    private String address;
    private String meterCode;
    private boolean isNewCustomer = true;
    private String registrationDate; 
    private String contractFilePath; 
    private boolean isMeterReady; 

    
    public NewCustomer(int customerId, String name, String email, String phone, String address, String meterCode, String registrationDate, String contractFilePath) {
        this.customerId = customerId;
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.address = address;
        this.meterCode = meterCode;
        this.registrationDate = registrationDate;
        this.contractFilePath = contractFilePath;
        this.isMeterReady = false; 
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
    public String getPhone(){ return phone; }

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
        return isNewCustomer; 
    }

    public String getRegistrationDate(){
        return registrationDate; 
    }
    public void setRegistrationDate(String registrationDate){
        this.registrationDate = registrationDate;
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
}
