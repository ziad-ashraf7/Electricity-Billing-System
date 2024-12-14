package Models;

public class Notification {
    private int notificationId;
    private String recipientEmail; 
    private String message; 
    private String sendDate; 

    
    public Notification(int notificationId, String recipientEmail, String message, String sendDate) {
        this.notificationId = notificationId;
        this.recipientEmail = recipientEmail;
        this.message = message;
        this.sendDate = sendDate;
    }

    
    public int getNotificationId(){
        return notificationId; 
    }
    public void setNotificationId(int notificationId){
        this.notificationId = notificationId; 
    }

    public String getRecipientEmail(){
        return recipientEmail; 
    }
    public void setRecipientEmail(String recipientEmail){
        this.recipientEmail = recipientEmail; 
    }

    public String getMessage(){
        return message;
    }
    public void setMessage(String message){
        this.message = message; 
    }

    public String getSendDate(){
        return sendDate;
    }
    public void setSendDate(String sendDate){
        this.sendDate = sendDate; 
    }

    
    public String formatNotification() {
        return "To: " + recipientEmail + "\nDate: " + sendDate + "\nMessage: " + message;
    }
}
