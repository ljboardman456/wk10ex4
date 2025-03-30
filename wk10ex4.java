import java.util.ArrayList;
import java.util.Scanner;

class Product {
    private String productID;
    private String productName;
    private double price;

    public Product(String productID, String productName, double price) {
        this.productID = productID;
        this.productName = productName;
        this.price = price;
    }

    public String getProductID() {
        return productID;
    }

    public String getProductName() {
        return productName;
    }

    public double getPrice() {
        return price;
    }
}

class ShoppingCart {
    private ArrayList<Product> cart;

    public ShoppingCart() {
        cart = new ArrayList<>();
    }

    public void AddProduct(Product product) {
        cart.add(product);
        System.out.println(product.getProductName() + " added to cart.");
    }

    public void RemoveProduct(String productID) {
        for (Product product : cart) {
            if (product.getProductID().equals(productID)) {
                cart.remove(product);
                System.out.println(product.getProductName() + " removed from cart.");
                return;
            }
        }
        System.out.println("Product not found in cart.");
    }

    public double CalculateTotalPrice() {
        double total = 0;
        for (Product product : cart) {
            total += product.getPrice();
        }
        return total;
    }
}

public class OnlineStore {
    public static void main(String[] args) {
        ShoppingCart cart = new ShoppingCart();
        Scanner scanner = new Scanner(System.in);
        
        while (true) {
            System.out.println("1. Add Product");
            System.out.println("2. Remove Product");
            System.out.println("3. Display Total Price");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter Product ID: ");
                    String id = scanner.nextLine();
                    System.out.print("Enter Product Name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter Price: ");
                    double price = scanner.nextDouble();
                    scanner.nextLine();
                    cart.AddProduct(new Product(id, name, price));
                    break;
                case 2:
                    System.out.print("Enter Product ID to remove: ");
                    String removeId = scanner.nextLine();
                    cart.RemoveProduct(removeId);
                    break;
                case 3:
                    System.out.printf("Total Price: $%.2f\n", cart.CalculateTotalPrice());
                    break;
                case 4:
                    System.out.println("Exiting...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice, please try again.");
            }
        }
    }
}
