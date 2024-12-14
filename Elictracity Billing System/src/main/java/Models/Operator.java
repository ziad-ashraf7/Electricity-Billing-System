package Models;

public class Operator {
    private int operatorId;
    private String name;
    private String region; 

    
    public Operator(int operatorId, String name, String region) {
        this.operatorId = operatorId;
        this.name = name;
        this.region = region;
    }

    
    public int getOperatorId(){
        return operatorId; 
    }
    public void setOperatorId(int operatorId){
        this.operatorId = operatorId;
    }

    public String getName(){
        return name;
    }
    public void setName(String name){
        this.name = name; 
    }

    public String getRegion(){
        return region;
    }
    public void setRegion(String region){
        this.region = region; 
    }

    
    public boolean validateReading(int reported, int actual) {
        return reported == actual;
    }
}
