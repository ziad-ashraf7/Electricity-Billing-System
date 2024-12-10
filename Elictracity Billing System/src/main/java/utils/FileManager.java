package utils;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileManager {

    
    public static void createFileIfNotExists(String fileName) {
        try {
            File file = new File(fileName);
            if (file.createNewFile()) {
                System.out.println("File created: " + file.getName());
            } else {
                System.out.println("File already exists.");
            }
        } catch (IOException e) {
            System.err.println("Error creating file: " + e.getMessage());
        }
    }

    
    public static void saveToFile(String fileName, String data) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName, true))) {
            writer.write(data);
            writer.newLine();  
            System.out.println("Data saved successfully to " + fileName);
        } catch (IOException e) {
            System.err.println("Error saving data to file: " + e.getMessage());
        }
    }

    public static List<String> readFromFile(String fileName) {
        List<String> data = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = reader.readLine()) != null) {
                data.add(line);
            }
        } catch (IOException e) {
            System.err.println("Error reading data from file: " + e.getMessage());
        }
        return data;
    }

    public static void updateInFile(String fileName, int lineIndex, String newData) {
        File file = new File(fileName);
        List<String> lines = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {
                lines.add(line);
            }
            if (lineIndex >= 0 && lineIndex < lines.size()) {
                lines.set(lineIndex, newData);
            }

            try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {
                for (String updatedLine : lines) {
                    writer.write(updatedLine);
                    writer.newLine();
                }
            }
        } catch (IOException e) {
            System.err.println("Error updating data in file: " + e.getMessage());
        }
    }

    public static void deleteFromFile(String fileName, int lineIndex) {
        File file = new File(fileName);
        List<String> lines = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {
                lines.add(line);
            }

            
            if (lineIndex >= 0 && lineIndex < lines.size()) {
                lines.remove(lineIndex);
            }

            
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {
                for (String updatedLine : lines) {
                    writer.write(updatedLine);
                    writer.newLine();
                }
            }
        } catch (IOException e) {
            System.err.println("Error deleting data from file: " + e.getMessage());
        }
    }
}
