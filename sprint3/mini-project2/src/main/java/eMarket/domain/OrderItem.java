package eMarket.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity(name="item")
public class OrderItem {
	
	public static int lastId = 1;
	
	@ManyToOne
	private Product product;
	
	@Id
	@GeneratedValue(strategy = GenerationType.TABLE)
	private int id = -1;

	@Column
    private int amount;
	@Column
	private Double cost;
	
	public OrderItem(){}
    
    public OrderItem(Product product, int amount){
    	this.id = lastId;
    	lastId++;
    	this.product = product;
    	this.amount = amount;
    	this.cost = amount * product.getPrice();
    }

	public int getAmount() {
		return amount;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		id = lastId;
		lastId++;
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
