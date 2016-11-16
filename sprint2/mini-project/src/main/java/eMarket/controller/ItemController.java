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
	int lastItemId=0;

    @RequestMapping("/"	)
    public String index(Model model, Order order) {
    	model.addAttribute("date",getDate());
    	model.addAttribute("itemList", EMarketApp.getStore().getItemList());
        return "form/itemMaster";
    }
    
    public String getDate() {
        SimpleDateFormat sdf = new SimpleDateFormat("YYYY-M-dd");
        String date = sdf.format(new Date());
        return date;
    }
    
    @RequestMapping(value = "/detail", method = RequestMethod.GET)
    public String itemDetail(Model model, @ModelAttribute("order") Order order, @ModelAttribute("item") Item item, @RequestParam(value="itemId", required=false, defaultValue="-1") int itemId) {
    	if (itemId >= 0) {
    		// modify
    		System.out.println("Item ID: "+item.getId());
    		System.out.println("Item ID3: "+itemId);
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
    	model.addAttribute("date",getDate());
    	model.addAttribute("productList", EMarketApp.getStore().getProductList());
    	return "form/itemDetail";
    }
    
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String addItem(@ModelAttribute("item") Item item, @RequestParam(value="orderId", required=false, defaultValue="-1") int orderId, Model model) {
    	if (item.getAmount() < 0.0) 
			throw new SpringException("Order Amount is negative.");
    	System.out.println("order name: "+item.getName());
		if (item.getName().equals("")) 
			throw new SpringException("Name is empty.");
		Order norder = EMarketApp.getStore().getOrderList().stream().filter(o -> (((Order)o).getId()==orderId)).findAny().get();
		norder.addItem(item);
//		Product product = EMarketApp.getStore().getProductList().stream().filter(p -> (((Product)p).getName() == order.getName())).findAny().get();
		Product product=EMarketApp.getStore().getProductByName(item.getName());
		System.out.println("product name: "+product.getDescription());
		item.setDescription(product.getName());
		item.setDescription(product.getDescription());
		item.setPrice(product.getPrice());;
		item.setCost(product.getPrice()*item.getAmount());
		System.out.println("Item ID4: "+item.getId());
//    	EMarketApp.getStore().getOrderList().removeIf(o -> (o.getId() == order.getId()));
    	EMarketApp.getStore().getItemList().add(item);
/*    	lastItemId=item.getId();
    	
    	if(EMarketApp.getStore().getAllOrders().containsKey(getDate())){
    		//key exist
    		String value=EMarketApp.getStore().getAllOrders().get(getDate());
    		value=value+", "+item.getName();
    		EMarketApp.getStore().getAllOrders().put(getDate(), value);
    		
    	}else{
    		EMarketApp.getStore().getAllOrders().put(getDate(), item.getName());
    	}*/
    	
    	model.addAttribute("date",getDate());
    	model.addAttribute("itemList", EMarketApp.getStore().getItemList());
//    	System.out.println("Item ID: "+itemId);
    	System.out.println("Item ID5: "+item.getId());
        return "form/orderDetail";
    }

    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    public String itemDelete(Order order, @RequestParam(value="itemId", required=false, defaultValue="-1") int itemId, @RequestParam(value="orderId", required=false, defaultValue="-1") int orderId, Model model) {
    	EMarketApp.getStore().getItemList().removeIf(p -> (p.getId() == itemId));
    	model.addAttribute("itemList", EMarketApp.getStore().getItemList());
    	SimpleDateFormat sdf = new SimpleDateFormat("YYYY-M-dd");
    	String date = sdf.format(new Date());
    	model.addAttribute("date",date);
    	model.addAttribute("id",lastItemId);
    	model.addAttribute("getLastId",order.getLastId());
    	return "form/orderDetail";
    }
    
    @RequestMapping("/itemDetail")
    public String indexItem(Model model) {
    	 model.addAttribute("date",getDate());
    	model.addAttribute("productList", EMarketApp.getStore().getProductList());
        return "form/itemDetail";
    }
    
    
    
}
