/**
 * (C) Artur Boronat, 2016
 */
package eMarket.domain;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class Store {
	List<Product> productList = new ArrayList<>();
	List<Order> orderList = new ArrayList<>();
	List<Item> itemList = new ArrayList<>();;
	//
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
}
