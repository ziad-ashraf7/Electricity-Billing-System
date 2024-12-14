package Models;

public abstract class Contract {
    private int contractId;
    private String customerId; 
    private String contractFilePath; 
    private String contractStatus; 

    public Contract(int contractId, String customerId, String contractFilePath, String contractStatus) {
        this.contractId = contractId;
        this.customerId = customerId;
        this.contractFilePath = contractFilePath;
        this.contractStatus = contractStatus;
    }

    
    public int getContractId(){
        return contractId; 
    }
    public void setContractId(int contractId){
        this.contractId = contractId; 
    }

    public String getCustomerId(){
        return customerId; 
    }
    public void setCustomerId(String customerId){
        this.customerId = customerId; 
    }

    public String getContractFilePath(){
        return contractFilePath; 
    }
    public void setContractFilePath(String contractFilePath){
        this.contractFilePath = contractFilePath; 
    }

    public String getContractStatus(){
        return contractStatus; 
    }
    public void setContractStatus(String contractStatus){
        this.contractStatus = contractStatus;
    }
    public abstract void displayContractDetails();
}
