/**
 * (C) Artur Boronat, 2016
 */
package eMarket.domain;

import java.util.Date;

public class Order {

	public static int lastId = 0;
    private int id = -1;
    private String name;
    private String date;
    private Double cost;
    private String description;
    private Double price;
    
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
		Date date = new Date();
		this.date = date.toString();
	}
	
	public Double getCost() {
		return cost;
	}
	
	public void setCost(Double cost) {
		this.cost = cost;
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
