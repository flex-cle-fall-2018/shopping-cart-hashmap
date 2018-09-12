package shoppingcart;

import java.util.Collection;
import java.util.HashMap;

public class ShoppingCart {

	private HashMap<String, ProductOrder> orders;
	
	ShoppingCart() {
		orders = new HashMap<String, ProductOrder>();
	}
	
	/**
	 * Add a ProductOrder to the cart.
	 * The order will be referenced by its key, the product name.
	 * @param product
	 * @param quantity
	 * @param cost
	 */
	public void addItem(String product, int quantity, float cost) {
		ProductOrder newOrder = new ProductOrder(product, quantity, cost);
		orders.put(product, newOrder);
	}
	
	/**
	 * Returns whether or not a product exists in the cart.
	 * @param product
	 * @return
	 */
	public boolean hasProduct(String product) {
		ProductOrder order = orders.get(product);
		
		boolean hasProduct;
		if (order == null) {
			hasProduct = false;
		}
		else {
			hasProduct = true;
		}
		
		return hasProduct;
	}
	
	/**
	 * Remove a ProductOrder from the cart by its key - the product name;
	 * @param product
	 */
	public void removeItem(String product) {
		orders.remove(product);
	}
	
	/**
	 * Change the quantity of a product order already in the cart.
	 * @param product
	 */
	public boolean changeQuantity(String product, int quantity) {
		// Find the product in the cart
		ProductOrder existingOrder = orders.get(product);
		if (existingOrder == null) {
			// Order not found - return false to indicate this
			return false;
		}
		existingOrder.setQuantity(quantity);
		return true;
	}
	
	/**
	 * Retrieve the number of orders in the cart (not the number of total items,
	 * but the number of different types of items)
	 * @return
	 */
	public int getOrderCount() {
		int totalOrderCount = 0;
		for (ProductOrder order : orders.values()) {
			totalOrderCount += order.getQuantity();
		}
		return totalOrderCount;
	}
	
	/**
	 * Returns a collection of all orders in the cart.
	 * Useful for iteration - looping over each item.
	 * @return
	 */
	public Collection<ProductOrder> getOrders() {
		return orders.values();
	}
	
	/**
	 * Returns the total cost of all items in the cart.
	 * @return
	 */
	public float getTotalOrderCost() {
		float totalCost = 0f;
		for (ProductOrder order : orders.values()) {
			totalCost += order.getCost() * order.getQuantity();
		}
		return totalCost;
	}
	
	/**
	 * Returns the quantity of a particular product in the cart.
	 * If the product is not in the cart, returns zero.
	 * @param product
	 * @return
	 */
	public int getProductQuantity(String product) {
		if (!this.hasProduct(product)) {
			return 0;
		}
		return orders.get(product).getQuantity();
	}
	
	/**
	 * Updates the quantity of a particular product in the cart.
	 * @param product
	 * @param quantity
	 */
	public void updateProductQuantity(String product, int quantity) {
		orders.get(product).setQuantity(quantity);
	}

	/**
	 * Empties all items from the cart.
	 */
	public void empty() {
		orders.clear();
	}
}
