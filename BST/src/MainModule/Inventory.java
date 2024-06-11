package MainModule;

public class Inventory {
    private Tree<Product> productTree = new Tree<>();

    public void addProduct(String category, String name, double price) {
        Product product = new Product(name, category, price);
        productTree.add(product);
        System.out.println("Adding:\nProduct: " + name + ", Category: " + category + ", Price: " + price + "₺\n");
    }

    public void searchProduct(String name) {
        ArrayList<Product> products = productTree.inOrderTraversal();
        boolean found = false;
        System.out.println("Searching:");
        for (int i = 0; i < products.getCurrentSize(); i++) {
            Product product = products.get(i);
            if (product.getName().equals(name)) {
                System.out.println("Found: " + product+"\n");
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println("Not Found: " + name+"\n");
        }
    }

    public void listProducts() {
        ArrayList<Product> products = productTree.inOrderTraversal();
        System.out.println("List:");
        for (int i = 0; i < products.getCurrentSize(); i++) {
            System.out.println(products.get(i));
        }
        System.out.println();
    }
}