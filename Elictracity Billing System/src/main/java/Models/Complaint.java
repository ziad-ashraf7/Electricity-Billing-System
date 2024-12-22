package Models;

import ziad.elictracitybillingsystem.UserUnitTesting;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.util.Date;

public class Complaint {
    private String usrid;
    private String msg;


    public Complaint(String usrid, String msg) {
        this.usrid = usrid;
        this.msg = msg;
    }

    public Complaint(String usrid, String msg, int x) {
        this.usrid = usrid;
        this.msg = msg;

        String filePath = String.valueOf(UserUnitTesting.class.getResource("/Database/Complaints.csv")).replace("file:/", "").replace("%20"," ");

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath, true))) {
            writer.newLine();
            writer.write(String.join(",", usrid, msg));
        } catch (IOException e) {
            System.err.println("Error writing to CSV: " + e.getMessage());
        }
    }

    public String getdata() {
        return String.join(",", usrid, msg);
    }
}