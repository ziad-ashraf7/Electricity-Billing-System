package models;

public class CommercialContract extends Contract {
    private String businessLicenseNumber; 

    
    public CommercialContract(int contractId, String customerId, String contractFilePath, String contractStatus, String businessLicenseNumber) {
        super(contractId, customerId, contractFilePath, contractStatus);
        this.businessLicenseNumber = businessLicenseNumber;
    }

   
    public String getBusinessLicenseNumber(){
        return businessLicenseNumber; 
    }
    public void setBusinessLicenseNumber(String businessLicenseNumber){
        this.businessLicenseNumber = businessLicenseNumber;
    }

    
    @Override
    public void displayContractDetails() {
        System.out.println("Commercial Contract Details:");
        System.out.println("Contract ID: " + getContractId());
        System.out.println("Customer ID: " + getCustomerId());
        System.out.println("Status: " + getContractStatus());
        System.out.println("Business License Number: " + businessLicenseNumber);
    }
}
