package Models;

public class NewCustomer extends User   {
    private int userId;
    private String name;
    private String email;
    private String phone;
    private String address;
    private String meterCode;
    private String Role = String.valueOf(ROLES.CUSTOMER);
    private String contractFilePath;
    private boolean isMeterReady;
    private String addingDate;


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
