package Models;

public class Admin extends User{
    private  int id;
    private String name;
    private String email;
    private String password;
    private String Role = "Admin";
    private String addingDate;

    public Admin(int adminId, String email, String password, String name, String AddingDate) {
        this.id = adminId;
        this.email = email;
        this.password = password;
        this.name = name;
        this.addingDate = AddingDate;
    }


    @Override
    public int getId() {
        return id;
    }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getEmail() { return email; }

    @Override
    String getPhone() {
        return "";
    }

    @Override
    String getAddress() {
        return "";
    }

    @Override
    String getMeterCode() {
        return "";
    }

    public void setEmail(String email) { this.email = email; }

    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }

    public void generateStatistics(String region) {
        System.out.println("Generating statistics for region: " + region);
    }

    public String getRole() {
        return Role;
    }

    @Override
    public String getAddingDate() {
        return addingDate;
    }

    public void setRole(String role) {
        Role = role;
    }
}
