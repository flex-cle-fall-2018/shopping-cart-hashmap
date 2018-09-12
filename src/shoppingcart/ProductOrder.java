package shoppingcart;

public class ProductOrder {

	private String product;
	private int quantity;
	private float cost;
	
	ProductOrder(String product, int quantity, float cost) {
		this.product = product;
		this.quantity = quantity;
		this.cost = cost;
	}
	
	public String getProduct() {
		return product;
	}
	
	public int getQuantity() {
		return quantity;
	}
	
	public float getCost() {
		return cost;
	}
	
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
}
