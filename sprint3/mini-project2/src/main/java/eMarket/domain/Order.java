/**
 * (C) Artur Boronat, 2016
 */
package eMarket.domain;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity(name="orders")
public class Order {

	public static int lastId = 1;

	@Id
	@GeneratedValue(strategy = GenerationType.TABLE)
	private int id =-1;
	@Column
	private Double cost = 0.0;

	@Column
	private String user = "";

	@Column
    private LocalDate date = LocalDate.now();
    
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, orphanRemoval=true)
    private List<OrderItem> itemList = new ArrayList<>();

	public Order() { }
	
	public String getDescription() {
		List<String> list = itemList.stream().map(i -> i.getProduct().getName()).collect(Collectors.toList());
		return String.join(", ", list);
	}
	public List<OrderItem> getItemList() {
		return itemList;
	}

	public void setItemList(List<OrderItem> itemList) {
		this.itemList = itemList;
	}
	
	public int getLastId() {
		return lastId;
	}

	// updates the id
	public void setId() {
		id=lastId;
		lastId++;
	}
	
	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}
	
	public void addItem(Product product, int amount) {
		this.getItemList().add(new OrderItem(product,amount));
		updateCost();
	}
	
	public void updateCost() {
		cost = 0.0;
		this.getItemList().forEach(i -> cost += i.getAmount() * i.getProduct().getPrice());
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}
	public void setDate() {
		LocalDate date = LocalDate.now();
		this.date = date;
    }

	public Double getCost() {
		return cost;
	}

	public void setCost(Double cost) {
		this.cost = cost;
	}
	
}
