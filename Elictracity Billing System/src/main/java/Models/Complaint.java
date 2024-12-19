package Models;

import java.time.LocalDate;
import java.util.Date;

public class Complaint {
    private String createdAt;
    private String msg;

    public Complaint(Date createdAt, String msg) {
        this.createdAt = createdAt.toString();
        this.msg = msg;
    }
    public Complaint(String createdAt, String msg) {
        this.createdAt = createdAt;
        this.msg = msg;
    }

    public String getdata() {
        return String.join(",", createdAt, msg);
    }
}