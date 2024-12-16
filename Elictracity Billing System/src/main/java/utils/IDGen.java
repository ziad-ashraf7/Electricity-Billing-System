package utils;

import java.util.Random;

public class IDGen {
    public static int generateID() {
        Random rand = new Random();
        return Math.abs(rand.nextInt());
    }
}
