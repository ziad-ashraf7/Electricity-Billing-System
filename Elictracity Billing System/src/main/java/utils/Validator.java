package utils;

import java.util.regex.Pattern;

public class Validator {

    
    public static boolean isValidEmail(String email) {
        String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";
        return Pattern.matches(emailRegex, email);
    }

    
    public static boolean isValidPhoneNumber(String phone) {
        String phoneRegex = "^[0-9]{10}$";
        return Pattern.matches(phoneRegex, phone);
    }

    
    public static boolean isNotEmpty(String str) {
        return str != null && !str.trim().isEmpty();
    }
}
