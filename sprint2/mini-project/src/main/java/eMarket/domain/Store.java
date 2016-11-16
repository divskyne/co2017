/**
 * (C) Artur Boronat, 2016
 */
package eMarket.domain;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class Store {
	List<Product> productList = new ArrayList<>();
	List<Order> orderList = new ArrayList<>();
	List<Item> itemList = new ArrayList<>();;
	//
	List<AllOrder> totalOrders = new ArrayList<>();
	Map<String,String> allOrders=new HashMap<>();
	
	public void init() {
		productList = new ArrayList<>();
		Product.lastId=0;
		orderList = new ArrayList<>();
		Order.lastId=0;
		itemList = new ArrayList<>();
		Order.lastId=0;
	}

	public void setProductList(List<Product> productList) {
		this.productList = productList;
	}
	
	public void setOrderList(List<Order> orderList) {
		this.orderList = orderList;
	}
	
	public void setItemList(List<Item> itemList) {
		this.itemList = itemList;
	}
	
	public List<Product> getProductList() {
		return productList;
	}
	
	public List<Order> getOrderList() {
		return orderList;
	}

	public List<Item> getItemList() {
		return itemList;
	}
	//
	public Product getProductByName(String name) {
		
		for(Product product:productList){
			if(product.getName().equals(name)){
				return product;
			}
		}
		return null;
	}
	public List<String> getProductNames() {
		ArrayList<String> productNames=new ArrayList<>();
		for(Product product:productList){
			productNames.add(product.getName());
		}
		return productNames;
	}
	public Map<String, String> getAllOrders() {
		return allOrders;
	}
	
public Order getOrderByName(String name) {
		
		for(Order order:orderList){
			if(order.getName().equals(name)){
				return order;
			}
		}
		return null;
	}

	public String getDate() {
		LocalDateTime now = LocalDateTime.now();
		int year = now.getYear();
		int month = now.getMonthValue();
		int day = now.getDayOfMonth();
		String date = year+"-"+month+"-"+day;
		return date;
	}

	public List<AllOrder> getTotalOrders(){
		totalOrders.clear();
		
		if(getAllOrders().size()>0){
			for(String date:getAllOrders().keySet()){
				AllOrder allorder=new AllOrder();
				allorder.setId();
				allorder.setDate(date);
				allorder.setDescription(getAllOrders().get(date));
				String []names=getAllOrders().get(date).split(" ");
				double sumCost=0;
				for (String order:names){
					Order ord=getOrderByName(order);
					if(ord!=null){
						sumCost+=ord.getCost();	
					}
					
				}
				allorder.setCost(sumCost);
				totalOrders.add(allorder);
			}
		}
		
		return totalOrders;
	}
}
