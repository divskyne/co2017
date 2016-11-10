/**
 * (C) Artur Boronat, 2016
 */
package eMarket.domain;

import java.time.LocalDateTime;

public class Order {

	public static int lastId = 0;
    private int id = -1;
    private String name;
    private String date;
    private Double cost;
    private String description;
    private Double price;
    private Double amount;
    
    public Order(){}
    
    public Order(int id, String name, String description, Double price) {
		this.setId(id);
		this.setName(name);
		this.setDescription(description);
		this.setPrice(price);
	}

	public void setId() {
		this.id = lastId;
		lastId++;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public String getDate() {
		return date;
	}
	
	public void setDate() {
		LocalDateTime now = LocalDateTime.now();
    	int year = now.getYear();
    	int month = now.getMonthValue();
    	int day = now.getDayOfMonth();
    	date = year+"-"+month+"-"+day;
		this.date = date.toString();
	}
	
	public Double getCost() {
		return cost;
	}
	
	public void setCost(Double cost) {
		this.cost = cost;
	}
	
	public Double getAmount() {
		return amount;
	}
	
	public void setAmount(Double amount) {
		 this.amount = amount;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}


}
