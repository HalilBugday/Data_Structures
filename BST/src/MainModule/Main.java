package MainModule;

public class Main {
    public static void main(String[] args) {
        Inventory inventory = new Inventory();
        FileIO fileIO = new FileIO();
        fileIO.readFile("hw3_example_inputs.csv", inventory);
    }
}