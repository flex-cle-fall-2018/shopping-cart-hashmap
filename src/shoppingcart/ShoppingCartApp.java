package shoppingcart;

import java.util.Scanner;

public class ShoppingCartApp {

	public static void main(String[] args) {
		System.out.println("Welcome to the online shopping cart experience.");
		ShoppingCart cart = new ShoppingCart();
		
		Scanner input = new Scanner(System.in);
		String userInput = "";
		
		while(!userInput.equals("quit")) {
			
			// Start on a new line
			System.out.println();
			
			// Display the items in the cart
			if (cart.getOrderCount() == 0) {
				System.out.println("Your cart is empty.");
			}
			else {
				System.out.println("Your cart contains these items:");
				for (ProductOrder order : cart.getOrders()) {
					System.out.println(order.getProduct() +
							"\tx" + order.getQuantity() +
							"\t$" + order.getCost());
				}
			}
			
			// Ask the user for input
			System.out.println("\nWhat would you like to do?");
			
			System.out.println("1. Add an item to the cart.");
			System.out.println("2. Remove an item from the cart.");
			System.out.println("3. Change an item's quantity.");
			System.out.println("4. See how much my total order costs.");
			System.out.println("5. Check out and purchase everything.");
			System.out.println("Type \"quit\" to stop shopping.");
			userInput = input.nextLine();
			
			// Take action based on user input
			if (userInput.equals("1")) {
				// Add an item to the cart
				System.out.println("What product would you like to add to the cart?");
				String product = input.nextLine();
				
				if (cart.hasProduct(product)) {
					System.out.println("That product is already in the cart.");
					continue; // We are done with this iteration - start over
				}
				
				System.out.println("How many would you like to add?");
				int quantity = input.nextInt();
				
				System.out.println("How much do those cost?");
				float cost = input.nextFloat();
				
				cart.addItem(product, quantity, cost);
				input.nextLine(); // clear the Scanner
			}
			else if (userInput.equals("2")) {
				// Remove an item from the cart
				System.out.println("What product would you like to remove?");
				String productToRemove = input.nextLine();
				
				if (cart.hasProduct(productToRemove)) {
					cart.removeItem(productToRemove);
					System.out.println("Product removed successfully.");
				}
				else {
					System.out.println("That product does not exist.");
				}
			}
			else if (userInput.equals("3")) {
				// Change an item's quantity
				System.out.println("What product would you like to update?");
				String product = input.nextLine();
				
				if (!cart.hasProduct(product)) {
					System.out.println("That product is not in the cart.");
					continue; // We are done with this iteration - start over
				}
				
				System.out.println("You currently have " + cart.getProductQuantity(product));
				System.out.println("How many would you like instead?");
				int quantity = input.nextInt();
				input.nextLine(); // clear the Scanner
				
				cart.changeQuantity(product, quantity);
				System.out.println("You now have " + quantity + " " + product + "s.");
			}
			else if (userInput.equals("4")) {
				// See how much the total order costs
				System.out.println("Your order comes to a grand total of $" + cart.getTotalOrderCost());
			}
			else if (userInput.equals("5")) {
				// Check out and purchase everything
				System.out.println("You paid the total amount of $" + cart.getTotalOrderCost() + ".");
				cart.empty();
			}
			else {
				System.out.println("Sorry, I didn't catch that...");
			}
		}
		
		System.out.println("\nThank you for shopping with us!");
	}

}
