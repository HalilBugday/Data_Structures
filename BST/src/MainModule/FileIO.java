package MainModule;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class FileIO {
    public void readFile(String fileName, Inventory inventory) {
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(",");
                String command = parts[0];
                switch (command) {
                    case "add":
                        String category = parts[1];
                        String product = parts[2];
                        double price = Double.parseDouble(parts[3]);
                        inventory.addProduct(category, product, price);
                        break;
                    case "search":
                        inventory.searchProduct(parts[1]);
                        break;
                    case "list":
                        inventory.listProducts();
                        break;
                    default:
                    	//Security imp.
                        System.out.println("Input Error! Invalid command: " + command +"\n");
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

