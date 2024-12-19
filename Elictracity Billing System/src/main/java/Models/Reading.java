package Models;

import ziad.elictracitybillingsystem.UserUnitTesting;

import java.io.*;
import java.util.Scanner;

public class Reading {
    private String readingId;
    private String userID;
    private String meterCode;
    private String readingDate; 
    private int consumption; 

    
    public Reading(String readingId, String userID, String meterCode, String readingDate, int consumption) {
        this.readingId = readingId;
        this.userID = userID;
        this.meterCode = meterCode;
        this.readingDate = readingDate;
        this.consumption = consumption;
    }

    
    public String getReadingId(){
        return readingId;
    }
    public void setReadingId(String readingId){
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

    static String getReadInfo(String readID) throws FileNotFoundException {
        Scanner fscanner = new Scanner(System.in);
        String[] compRecord = new String[0];
        fscanner = new Scanner(new File(String.valueOf(UserUnitTesting.class.getResource("/Database/Readings.csv")).replace("file:/", "").replace("%20"," ")));
        while(fscanner.hasNext()){
            String tmp = fscanner.next();
            compRecord = tmp.split(",");
            if(compRecord[0].equals(readID)){
                return tmp;
            }
        }
        return "";
    }
}

