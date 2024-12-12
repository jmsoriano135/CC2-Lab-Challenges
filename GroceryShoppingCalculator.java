import java.util.Scanner;

public class GroceryShoppingCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

 // Input for Item 1
System.out.println("Enter the price of item 1:");
double price1 = scanner.nextDouble();  
System.out.print("Enter the quantity of item 1: ");
int quantity1 = scanner.nextInt();     
System.out.println("Price of item 1: " + price1);
System.out.println("Quantity of item 1: " + quantity1);

// Input for Item 2
System.out.println("Enter the price of item 2: ");
double price2 = scanner.nextDouble();
System.out.print("Enter the quantity of item 2: ");
int quantity2 = scanner.nextInt();

// Input for Item
System.out.println("Enter the price of item 3:" );
double price3 = scanner.nextDouble();
System.out.print("Enter the quantity of item 3:" );
int quantity3 = scanner.nextInt();

// Calculations
double subtotal = (price1 * quantity1) + (price2 * quantity2) + (price3 * quantity3);
double discount = subtotal * 0.05; // 5% discount
double discountedAmount = subtotal - discount;
double salesTax = discountedAmount * 0.12; // 12% sales tax
double finalTotal = discountedAmount + salesTax;

// Output
System.out.printf("Subtotal       : PHP %.2f%n", subtotal);
System.out.printf("Discount       : PHP %.2f%n", discount);
System.out.printf("Sales Tax      : PHP %.2f%n", salesTax);
System.out.printf("Final Total    : PHP %.2f%n", finalTotal);


    }
}
