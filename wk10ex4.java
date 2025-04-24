import java.util.ArrayList;
import java.util.Scanner;

// this defines the product class
class Product {
    // this stores the product id
    private String productID;
    // this stores the product name
    private String productName;
    // this stores the product price
    private double price;

    // this initializes the product object with its id, name, and price
    public Product(String productID, String productName, double price) {
        this.productID = productID;
        this.productName = productName;
        this.price = price;
    }

    // this returns the product id
    public String getProductID() {
        return productID;
    }

    // this returns the product name
    public String getProductName() {
        return productName;
    }

    // this returns the product price
    public double getPrice() {
        return price;
    }
}

// this defines the shopping cart class
class ShoppingCart {
    // this creates an array list to store products in the cart
    private ArrayList<Product> cart;

    // this initializes the shopping cart
    public ShoppingCart() {
        cart = new ArrayList<>();
    }

    // this adds a product to the shopping cart
    public void AddProduct(Product product) {
        cart.add(product);
        // this prints a message confirming the product was added
        System.out.println(product.getProductName() + " added to cart.");
    }

    // this removes a product from the shopping cart based on its id
    public void RemoveProduct(String productID) {
        for (Product product : cart) {
            // this checks if the product id matches
            if (product.getProductID().equals(productID)) {
                cart.remove(product);
                // this prints a message confirming the product was removed
                System.out.println(product.getProductName() + " removed from cart.");
                return;
            }
        }
        // this prints a message if the product was not found
        System.out.println("Product not found in cart.");
    }

    // this calculates the total price of all products in the cart
    public double CalculateTotalPrice() {
        double total = 0;
        for (Product product : cart) {
            // this adds the price of each product to the total
            total += product.getPrice();
        }
        return total;
    }
}

// this defines the main online store application
public class OnlineStore {
    public static void main(String[] args) {
        // this creates a new shopping cart
        ShoppingCart cart = new ShoppingCart();
        // this creates a scanner to read user input
        Scanner scanner = new Scanner(System.in);
        
        // this runs the main menu in a loop until the user exits
        while (true) {
            // this displays menu options
            System.out.println("1. Add Product");
            System.out.println("2. Remove Product");
            System.out.println("3. Display Total Price");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            // this handles the user's menu choice
            switch (choice) {
                case 1:
                    // this prompts the user to enter product details
                    System.out.print("Enter Product ID: ");
                    String id = scanner.nextLine();
                    System.out.print("Enter Product Name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter Price: ");
                    double price = scanner.nextDouble();
                    scanner.nextLine();
                    // this adds the product to the cart
                    cart.AddProduct(new Product(id, name, price));
                    break;
                case 2:
                    // this prompts the user to enter the id of the product to remove
                    System.out.print("Enter Product ID to remove: ");
                    String removeId = scanner.nextLine();
                    // this removes the product from the cart
                    cart.RemoveProduct(removeId);
                    break;
                case 3:
                    // this calculates and displays the total price of the cart
                    System.out.printf("Total Price: $%.2f\n", cart.CalculateTotalPrice());
                    break;
                case 4:
                    // this exits the program
                    System.out.println("Exiting...");
                    scanner.close();
                    return;
                default:
                    // this informs the user of an invalid choice
                    System.out.println("Invalid choice, please try again.");
            }
        }
    }
}
