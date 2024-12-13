//Soriano, JM P.
//CITCS1N
//Final Challenge No. 1 : Inventory Management


public class InventoryManagement {
    public static void main(String[] args) {
        // Number of products
        final int NUM_PRODUCTS = 10;

        // Initialize arrays to store quantities and prices
        int[] quantities = new int[NUM_PRODUCTS];
        double[] prices = new double[NUM_PRODUCTS];

        // Sample data for quantities and prices
        quantities[0] = 50;   prices[0] = 19.99;  // Product 1
        quantities[1] = 30;   prices[1] = 9.99;   // Product 2
        quantities[2] = 20;   prices[2] = 14.99;  // Product 3
        quantities[3] = 15;   prices[3] = 29.99;  // Product 4
        quantities[4] = 40;   prices[4] = 4.99;   // Product 5
        quantities[5] = 25;   prices[5] = 24.99;  // Product 6
        quantities[6] = 10;   prices[6] = 49.99;  // Product 7
        quantities[7] = 60;   prices[7] = 2.99;   // Product 8
        quantities[8] = 35;   prices[8] = 7.99;   // Product 9
        quantities[9] = 45;   prices[9] = 12.99;  // Product 10

        // Calculating the total value of all items in stock
        double totalValue = 0.0;

        System.out.println("Retail Store Inventory Report");
        System.out.println("----------------------------------------");
        System.out.printf("%-10s %-10s %-10s %-10s%n", "Product#", "Quantity", "Price($)", "Total($)");
        System.out.println("----------------------------------------");

        for (int i = 0; i < NUM_PRODUCTS; i++) {
            double productTotal = quantities[i] * prices[i];
            totalValue += productTotal;
            System.out.printf("%-10d %-10d %-10.2f %-10.2f%n", (i + 1), quantities[i], prices[i], productTotal);
        }

        System.out.println("----------------------------------------");
        System.out.printf("Total Inventory Value: $%.2f%n", totalValue);
    }
}