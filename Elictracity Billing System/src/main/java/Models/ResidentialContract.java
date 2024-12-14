package Models;

public class ResidentialContract extends Contract {
    private String apartmentDetails; 

    
    public ResidentialContract(int contractId, String customerId, String contractFilePath, String contractStatus, String apartmentDetails) {
        super(contractId, customerId, contractFilePath, contractStatus);
        this.apartmentDetails = apartmentDetails;
    }

    
    public String getApartmentDetails() { return apartmentDetails; }
    public void setApartmentDetails(String apartmentDetails) { this.apartmentDetails = apartmentDetails; }

    
    @Override
    public void displayContractDetails() {
        System.out.println("Residential Contract Details:");
        System.out.println("Contract ID: " + getContractId());
        System.out.println("Customer ID: " + getCustomerId());
        System.out.println("Status: " + getContractStatus());
        System.out.println("Apartment Details: " + apartmentDetails);
    }
}
