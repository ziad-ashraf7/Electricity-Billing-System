package Models;

public class Reading {
    private int readingId;
    private String meterCode; 
    private String readingDate; 
    private int consumption; 

    
    public Reading(int readingId, String meterCode, String readingDate, int consumption) {
        this.readingId = readingId;
        this.meterCode = meterCode;
        this.readingDate = readingDate;
        this.consumption = consumption;
    }

    
    public int getReadingId(){
        return readingId;
    }
    public void setReadingId(int readingId){
        this.readingId = readingId;
    }

    public String getMeterCode(){
        return meterCode; 
    }
    public void setMeterCode(String meterCode){
        this.meterCode = meterCode;
    }

    public String getReadingDate(){
        return readingDate;
    }
    public void setReadingDate(String readingDate){
        this.readingDate = readingDate; 
    }

    public int getConsumption(){
        return consumption; 
    }
    public void setConsumption(int consumption){
        this.consumption = consumption; 
    }

    public double calculateAverageConsumption(int days) {
        return (double) consumption / days;
    }
}

