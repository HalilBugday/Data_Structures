package Dictionary_app;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class FileIO {
    public static String readTextFromFile(String filePath) {
        StringBuilder contentBuilder = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
            	  line = line.replaceAll("\\p{Punct}", "");
                  contentBuilder.append(line).append("\n"); 
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return contentBuilder.toString().toLowerCase();
    }
}
