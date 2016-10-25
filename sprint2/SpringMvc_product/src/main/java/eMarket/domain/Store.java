/**
 * (C) Artur Boronat, 2016
 */
package eMarket.domain;

import java.util.ArrayList;
import java.util.List;

public class Store {
	List<Product> productList = new ArrayList<>();
	
	public void init() {
		productList = new ArrayList<>();
		Product.lastId=0;
	}

	public void setProductList(List<Product> productList) {
		this.productList = productList;
	}
	
	public List<Product> getProductList() {
		return productList;
	}
}
