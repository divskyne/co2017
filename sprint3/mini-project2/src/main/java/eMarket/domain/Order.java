/**
 * (C) Artur Boronat, 2016
 */
package eMarket.domain;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Transient;

import org.springframework.beans.factory.annotation.Autowired;

import eMarket.EMarketApp;
import eMarket.repository.StoreRepository;
import lombok.Getter;
import lombok.Setter;

@Entity(name="orders")
public class Order {

	
	@Transient
	public int lastId = 0;

	@Id
	@GeneratedValue(strategy = GenerationType.TABLE)
	private int id;
	@Column
	private String description;
	@Column
	private Double cost = 0.0;

	@Column
	private String user = "";

	@Column
    private LocalDate date = LocalDate.now();
    
	@OneToMany(fetch=FetchType.LAZY, cascade=CascadeType.ALL, orphanRemoval=true)
    private List<OrderItem> itemList = new ArrayList<>();
//    private Double cost = 0.0;

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
//		Product product = getProduct(productId);
		this.getItemList().add(new OrderItem(product,amount));
		updateCost();
	}
	
	public void updateCost() {
		cost = 0.0;
		this.getItemList().forEach(i -> cost += i.getAmount() * i.getProduct().getPrice());
	}


//	private Product getProduct(int productId) {
//		Store store = storeRepo.findByName(EMarketApp.STORE_NAME).get(0);
//		return store.getProductList().stream().filter(p -> p.getId()==productId).findFirst().orElse(null);
//	}

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

	public void setDescription(String description) {
		this.description = description;
	}

	public Double getCost() {
		return cost;
	}

	public void setCost(Double cost) {
		this.cost = cost;
	}
	
}
