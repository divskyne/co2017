/**
 * (C) Artur Boronat, 2015
 */
package eMarket.controller;


import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import eMarket.EMarketApp;
import eMarket.domain.Item;
import eMarket.domain.Order;
import eMarket.domain.Product;

@Controller
@RequestMapping("/item")
public class ItemController {
	int lastOrderId=0;

    @RequestMapping("/"	)
    public String index(Model model) {
    	model.addAttribute("itemList", EMarketApp.getStore().getItemList());
        return "form/itemMaster";
    }
    
    @RequestMapping(value = "/detail", method = RequestMethod.GET)
    public String itemDetail(Model model, @ModelAttribute("order") Order order, @ModelAttribute("item") Item item, @RequestParam(value="itemId", required=false, defaultValue="-1") int itemId) {
    	if (itemId >= 0) {
    		// modify
    		Item item1 = EMarketApp.getStore().getItemList().stream().filter(i -> (((Item)i).getId() == itemId)).findAny().get();
    		item1.setId(item1.getId());
    		if (item1.getName().equals("")) 
    			throw new SpringException("Name is empty.");
    		item1.setName(item1.getName());
    		item1.setAmount(item1.getAmount());
    		if (item1.getPrice() < 0.0) 
    			throw new SpringException("Value is negative.");
    		item1.setPrice(item1.getPrice());
    	} else {
    		// add
    		
    		item.setId();
    		
    	}
    	model.addAttribute("productList", EMarketApp.getStore().getProductList());
    	return "form/itemDetail";
    }
    
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String addOrder(@ModelAttribute("order") Order order, Model model) {
    	if (order.getAmount() < 0.0) 
			throw new SpringException("Order Amount is negative.");
    	System.out.println("order name: "+order.getName());
		if (order.getName().equals("")) 
			throw new SpringException("Name is empty.");
//		Product product = EMarketApp.getStore().getProductList().stream().filter(p -> (((Product)p).getName() == order.getName())).findAny().get();
		Product product=EMarketApp.getStore().getProductByName(order.getName());
		System.out.println("product name: "+product.getDescription());
		order.setDescription(product.getDescription());
		order.setPrice(product.getPrice());
		order.setCost(product.getPrice()*order.getAmount());
		
//    	EMarketApp.getStore().getOrderList().removeIf(o -> (o.getId() == order.getId()));
    	EMarketApp.getStore().getOrderList().add(order);
/*    	lastOrderId=order.getId();
    	SimpleDateFormat sdf = new SimpleDateFormat("YYYY-M-dd");
    	String date = sdf.format(new Date());
    	if(EMarketApp.getStore().getAllOrders().containsKey(date)){
    		//key exist
    		String value=EMarketApp.getStore().getAllOrders().get(date);
    		value=value+", "+order.getName();
    		EMarketApp.getStore().getAllOrders().put(date, value);
    		
    	}else{
    		EMarketApp.getStore().getAllOrders().put(date, order.getName());
    	}
    	
    	model.addAttribute("date",date);
    	model.addAttribute("id",lastOrderId);*/
   		
    	model.addAttribute("orderList", EMarketApp.getStore().getOrderList());
    	
        return "form/orderDetail";
    }

    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    public String itemMaster(@RequestParam(value="itemId", required=false, defaultValue="-1") int itemId, Model model) {
    	EMarketApp.getStore().getItemList().removeIf(p -> (p.getId() == itemId));
    	model.addAttribute("itemList", EMarketApp.getStore().getItemList());
    	return "form/orderDetail";
    }
    
    @RequestMapping("/itemDetail")
    public String indexItem(Model model) {
    	model.addAttribute("productList", EMarketApp.getStore().getProductList());
        return "form/itemDetail";
    }
    
    
    
}
