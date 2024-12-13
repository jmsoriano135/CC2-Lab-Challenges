import java.util.Scanner;

public class ShoppingCart {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ShoppingCart cart = new ShoppingCart(50); // Initial stock

        System.out.println("Welcome to the Online Shopping Cart!");

        while (true) {
            System.out.print("Enter quantity to add to cart (or -1 to exit): ");

            try {
                int quantity = scanner.nextInt();
                if (quantity == -1) {
                    break;
                }
                cart.addProduct(quantity);
            } catch (Exception e) {
                System.out.println("Error: Please enter a valid number.");
                scanner.next(); // Clear invalid input
            }
        }

        scanner.close();
        System.out.println("Thank you for using the Online Shopping Cart!");
    }

    private int availableStock;

    public ShoppingCart(int availableStock) {
        this.availableStock = availableStock;
    }

    public void addProduct(int quantity) {
        if (quantity <= 0) {
            System.out.println("Error: Quantity must be positive.");
            return;
        }
        if (quantity > availableStock) {
            System.out.printf("Error: Not enough stock. Available stock: %d%n", availableStock);
            return;
        }
        availableStock -= quantity;
        System.out.printf("Added %d items to your cart. Remaining stock: %d%n", quantity, availableStock);
    }
}