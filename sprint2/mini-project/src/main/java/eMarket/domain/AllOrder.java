/**
 * (C) Artur Boronat, 2016
 */
package eMarket.domain;


public class AllOrder {

	public static int lastId = 0;
    private int id = -1;
    private String date;
    private String description;
    private Double cost;
    
    
    public AllOrder(){}
    
    public AllOrder(int id, String date, String description, Double cost) {
		this.setId(id);
		this.setDate(date);
		this.setDescription(description);
		this.setCost(cost);
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

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getDescription() {
		return description;
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
