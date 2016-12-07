package eMarket.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
public class OrderItem {

	public static int getLastId() {
		return lastId;
	}

	public static void setLastId(int lastId) {
		OrderItem.lastId = lastId;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public Double getCost() {
		return cost;
	}

	public void setCost(Double cost) {
		this.cost = cost;
	}

	public static int lastId = 0;

    private int id = -1;

    private Product product;

    private int amount;

    private Double cost;
    
    public OrderItem(Product product, int amount){
    	this.id = lastId;
    	lastId++;
    	this.product = product;
    	this.amount = amount;
    	this.cost = amount * product.getPrice();
    }
    
}
