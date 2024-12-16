package ziad.elictracitybillingsystem;

import Models.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class UserUnitTesting {
    static public Scanner scanner = new Scanner(System.in);
    static public Scanner fscanner = new Scanner(System.in);


    static OldCustomer parseCustomerInfoObject(String[] recordArr) throws FileNotFoundException {
        List<Complaint> complaintsTmp = new ArrayList<Complaint>();

        fscanner = new Scanner(new File(String.valueOf(UserUnitTesting.class.getResource("/Database/Complaints.csv")).replace("file:/", "").replace("%20"," ")));
        String[] compRecord = new String[0];
        while(fscanner.hasNext()){
            compRecord = fscanner.next().split(",");
            if(compRecord[0].equals(recordArr[0])){
                complaintsTmp.add(new Complaint(compRecord[1], compRecord[2]));
            }
        }

        List<String> unpaidBillsTmp = new ArrayList<String>();

        // Create Function to collect UnPaid Bills

        return new OldCustomer(Integer.parseInt(recordArr[0]), recordArr[1], recordArr[3], recordArr[4], recordArr[5], recordArr[6], complaintsTmp, unpaidBillsTmp);
    }
    static Admin parseAdminInfoObject(String[] recordArr) throws FileNotFoundException {
//        return new Admin(Integer.parseInt(recordArr[0]), recordArr[1], recordArr[2], recordArr[3]);
        return null;
    }
    static Operator parseOperatorInfoObject(String[] recordArr) throws FileNotFoundException {
        return new Operator(Integer.parseInt(recordArr[0]), recordArr[1], recordArr[2], recordArr[3], recordArr[4]);
    }


    static private Login login() throws FileNotFoundException {
        System.out.println("Welcome to Electricity Billing System, Please Login");
        System.out.println("Enter Email");
        String email = scanner.nextLine().toLowerCase();
        System.out.println("Enter Pass");
        String password = scanner.nextLine().toLowerCase();
        System.out.println("Enter Acc Type: Customer, Admin, Operator");
        String accType = scanner.nextLine().toLowerCase();

        System.out.println(email + " " + password + " " + accType);

        String[] recordArr = new String[0];
        if(accType.equals("customer")){
            fscanner = new Scanner(new File(String.valueOf(UserUnitTesting.class.getResource("/Database/UsersInfo.csv")).replace("file:/", "").replace("%20"," ")));
            recordArr = new String[0];

            while(fscanner.hasNext()){
                String record = fscanner.next();
                recordArr = record.split(",");

                if(email.equals(recordArr[1]) && password.equals(recordArr[2])){
//                    System.out.println("Found");
                    return new Login(parseCustomerInfoObject(recordArr));
                }
            }
        } else if(accType.equals("admin")){
            fscanner = new Scanner(new File(String.valueOf(UserUnitTesting.class.getResource("/Database/Admins.csv")).replace("file:/", "").replace("%20"," ")));
            recordArr = new String[0];

            while(fscanner.hasNext()){
                String record = fscanner.next();
                recordArr = record.split(",");

                if(email.equals(recordArr[1]) && password.equals(recordArr[2])){
//                    System.out.println("Found");
                    return new Login(parseAdminInfoObject(recordArr));
                }
            }
        } else if(accType.equals("operator")){
            fscanner = new Scanner(new File(String.valueOf(UserUnitTesting.class.getResource("/Database/Operators.csv")).replace("file:/", "").replace("%20"," ")));
            recordArr = new String[0];

            while(fscanner.hasNext()){
                String record = fscanner.next();
                recordArr = record.split(",");

                if(email.equals(recordArr[1]) && password.equals(recordArr[2])){
//                    System.out.println("Found");
                    return new Login(parseOperatorInfoObject(recordArr));
                }
            }
        }
        return null; // Login Error (Wrong Password, Wrong Account Type, Account not found...)
    }


    public static void main(String[] args) throws FileNotFoundException {
        Login x = login();
    }
}
