package eMarket.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity(name="orderitems")
public class OrderItem {
	
	public static int lastId = 0;
	@Id
	@GeneratedValue(strategy = GenerationType.TABLE)
	private int id = -1;
	@OneToOne(fetch=FetchType.LAZY)
	@JoinColumn (name = "productId")
    private Product product;

	@Column
    private int amount;
	@Column
	private Double cost;
    
    public OrderItem(Product item, int amount){
    	this.id = lastId;
    	lastId++;
    	this.product = item;
    	this.amount = amount;
    	this.cost = amount * item.getPrice();
    }

	public int getAmount() {
		return amount;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getLastId() {
		return lastId;
	}

	public void setLastId(int lastId) {
		OrderItem.lastId = lastId;
	}

	public Double getCost() {
		return cost;
	}

	public void setCost(Double cost) {
		this.cost = cost;
	}
	
	public Product getProduct() {
		return product;
	}
	
	public void setProduct(Product product) {
		this.product = product;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}
    
}
