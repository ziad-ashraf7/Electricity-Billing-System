package Models;

public class Login {
    String acctype;
    OldCustomer customer;
    Admin admin;
    Operator operator;

    public Login(OldCustomer cust){
        this.acctype = "customer";
        this.customer = cust;
        this.admin = null;
        this.operator = null;
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
