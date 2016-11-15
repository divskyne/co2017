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
    		Order order1 = EMarketApp.getStore().getOrderList().stream().filter(o -> (((Order)o).getId() == itemId)).findAny().get();
    		order1.setId(order1.getId());
    		if (order1.getName().equals("")) 
    			throw new SpringException("Name is empty.");
    		order1.setName(order1.getName());
    		order1.setAmount(order1.getAmount());
    		if (order1.getPrice() < 0.0) 
    			throw new SpringException("Value is negative.");
    		order1.setPrice(order1.getPrice());
    	} else {
    		// add
    		
    		order.setId();
    		
    	}
    	model.addAttribute("productList", EMarketApp.getStore().getProductList());
    	return "form/itemDetail";
    }
    
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String addOrder(Model model, @ModelAttribute("order") Order order, @RequestParam(value="orderId", required=false, defaultValue="-1") int orderId) {
    	if (order.getAmount() < 0.0) 
			throw new SpringException("Order Amount is negative.");
		if (order.getName().equals("")) 
			throw new SpringException("Name is empty.");    	
		Product product = EMarketApp.getStore().getProductList().stream().filter(p -> (((Product) p).getId() == orderId)).findAny().get();
		order.setDescription(product.getName());
		order.setPrice(product.getPrice());
		order.setCost(product.getPrice()*order.getAmount());
		lastOrderId=order.getId();
		
    	EMarketApp.getStore().getOrderList().removeIf(o -> (o.getId() == order.getId()));
    	EMarketApp.getStore().getOrderList().add(order);
    	model.addAttribute("orderList", EMarketApp.getStore().getOrderList());
        return "form/orderDetail";
    }
    //
    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String getOrder(@ModelAttribute("order") Order order, Model model) {
    	SimpleDateFormat sdf = new SimpleDateFormat("YYYY-M-dd");
    	String date = sdf.format(new Date());
    	model.addAttribute("date",date);
    	model.addAttribute("id",lastOrderId);
        return "form/newOrder";
    }
    //
/*    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String addOrder(@ModelAttribute("order") Order order, Model model) {
    	if (order.getAmount() < 0.0) 
			throw new SpringException("Order Amount is negative.");
		if (order.getName().equals("")) 
			throw new SpringException("Name is empty.");    	
		Product product=EMarketApp.getStore().getProductByName(order.getName());
		order.setDescription(product.getDescription());
		order.setPrice(product.getPrice());
		order.setCost(product.getPrice()*order.getAmount());
		
    	EMarketApp.getStore().getOrderList().removeIf(o -> (o.getId() == order.getId()));
    	EMarketApp.getStore().getOrderList().add(order);
    	lastOrderId=order.getId();
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
    	model.addAttribute("id",lastOrderId);
   		
    	model.addAttribute("orderList", EMarketApp.getStore().getOrderList());
    	
        return "form/orderDetail";
    }
    
    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String getOrder(@ModelAttribute("order") Order order, Model model) {
    	SimpleDateFormat sdf = new SimpleDateFormat("YYYY-M-dd");
    	String date = sdf.format(new Date());
    	model.addAttribute("date",date);
    	model.addAttribute("id",lastOrderId);
        return "form/orderDetail";
    }*/

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
