package models;

public class Admin {
    private int adminId;
    private String name;

    public Admin(int adminId, String name) {
        this.adminId = adminId;
        this.name = name;
    }

    public int getAdminId() { return adminId; }
    public void setAdminId(int adminId) { this.adminId = adminId; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public void generateStatistics(String region) {
        System.out.println("Generating statistics for region: " + region);
    }
}
