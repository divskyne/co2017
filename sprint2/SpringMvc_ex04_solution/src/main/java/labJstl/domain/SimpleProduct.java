package labJstl.domain;

public class SimpleProduct {

	public static int lastId = 0;
    private int id = -1;
    private String name;
    private String description;
    private Double price;
    
    public SimpleProduct(){}
    
    public SimpleProduct(int id, String description, String name, Double price) {
		this.id = id;
		this.name = name;
		this.description = description;
		this.price = price;
	}
    
    public void setId(int i) {
        id = i;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
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
    
    public String toString() {
        StringBuffer buffer = new StringBuffer();
        buffer.append("Description: " + description + ";");
        buffer.append("Price: " + price);
        return buffer.toString();
    }
}
