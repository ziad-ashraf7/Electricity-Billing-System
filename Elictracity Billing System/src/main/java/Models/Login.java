package Models;

import ziad.elictracitybillingsystem.UserUnitTesting;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.List;
import java.util.Scanner;

public class Login {
    String acctype;
    OldCustomer customer;
    Admin admin;
    Operator operator;

    public Login(OldCustomer cust) throws FileNotFoundException {
        this.acctype = "customer";
        this.customer = cust;
        this.admin = null;
        this.operator = null;

        String userDcontent = String.join(",", Integer.toString(cust.getId()), cust.getEmail(), cust.getPhone(), cust.getName(), cust.getPhone(), cust.getAddress(), cust.getMeterCode(), cust.getAddingDate(), cust.getRole());
        Path userD = Paths.get("data\\customers.csv");

        List<Complaint> complts = cust.getComplaints();
        Path complaints = Paths.get("data\\complaints.csv");

        List<String> blls =  cust.getBills();
        Path bllsFile = Paths.get("data\\bills.csv");

        String pth = OldCustomer.getContractPath(cust.getId());
        Path contsFile = Paths.get("data\\contracts.csv");

        List<String> rds =  cust.getReadings();
        Path rdsFile = Paths.get("data\\readings.csv");

        try {
            // push user data
            Files.write(userD, (userDcontent + System.lineSeparator()).getBytes(),
                    StandardOpenOption.CREATE, StandardOpenOption.TRUNCATE_EXISTING);

            // push user complaints
            Files.write(complaints, ("" + System.lineSeparator()).getBytes(),
                    StandardOpenOption.CREATE, StandardOpenOption.TRUNCATE_EXISTING);
            for(Complaint x : complts){
                System.out.println(x.getdata());
                Files.write(complaints, (x.getdata() + System.lineSeparator()).getBytes(),
                        StandardOpenOption.CREATE, StandardOpenOption.APPEND);
            }

            // push user's bills
            Files.write(bllsFile, ("" + System.lineSeparator()).getBytes(),
                    StandardOpenOption.CREATE, StandardOpenOption.TRUNCATE_EXISTING);
            for(String x : blls){
                Files.write(bllsFile, (Bill.getBillInfo(x) + System.lineSeparator()).getBytes(),
                        StandardOpenOption.CREATE, StandardOpenOption.APPEND);
            }

            // push user's contract
            Files.write(contsFile, (pth + System.lineSeparator()).getBytes(),
                    StandardOpenOption.CREATE, StandardOpenOption.TRUNCATE_EXISTING);

            // push user's readings
            Files.write(rdsFile, ("" + System.lineSeparator()).getBytes(),
                    StandardOpenOption.CREATE, StandardOpenOption.TRUNCATE_EXISTING);
            for(String x : rds){
                Files.write(rdsFile, (Reading.getReadInfo(x) + System.lineSeparator()).getBytes(),
                        StandardOpenOption.CREATE, StandardOpenOption.APPEND);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public Login(Admin admin){
        this.acctype = "admin";
        this.customer = null;
        this.admin = admin;
        this.operator = null;
    }

    public Login(Operator operator){
        this.acctype = "operator";
        this.customer = null;
        this.admin = null;
        this.operator = operator;
    }
}