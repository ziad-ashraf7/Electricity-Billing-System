package Models;

public class Admin {
    private final int adminId;
    private String name;
    private String email;
    private String password;

    public Admin(int adminId, String email, String password, String name) {
        this.adminId = adminId;
        this.email = email;
        this.password = password;
        this.name = name;
    }

    public int getAdminId() { return adminId; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }

    public void generateStatistics(String region) {
        System.out.println("Generating statistics for region: " + region);
    }
}
