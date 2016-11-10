/**
 * (C) Artur Boronat, 2016
 */
package eMarket.domain;

import java.util.ArrayList;
import java.util.List;


public class Store {
	List<Product> productList = new ArrayList<>();
	List<Order> orderList = new ArrayList<>();
	List<Item> itemList = new ArrayList<>();
	
	public void init() {
		productList = new ArrayList<>();
		Product.lastId=0;
		orderList = new ArrayList<>();
		Order.lastId=0;
		itemList = new ArrayList<>();
		Item.lastId=0;
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
}
