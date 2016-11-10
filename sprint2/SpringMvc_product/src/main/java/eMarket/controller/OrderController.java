/**
 * (C) Artur Boronat, 2015
 */
package eMarket.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import eMarket.EMarketApp;
import eMarket.domain.Order;

@Controller
@RequestMapping("/order")
public class OrderController {

    @RequestMapping("/")
    public String index(Model model) {
    	model.addAttribute("orderList", EMarketApp.getStore().getOrderList());
        return "form/orderMaster";
    }
    
    @RequestMapping(value = "/orderDetail", method = RequestMethod.GET)
    public String orderDetail(@ModelAttribute("order") Order order, @RequestParam(value="orderId", required=false, defaultValue="-1") int orderId) {
    	if (orderId >= 0) {
    		// modify
    		Order p2 = EMarketApp.getStore().getOrderList().stream().filter(p -> (((Order) p).getId() == orderId)).findAny().get();
    		order.setId(p2.getId());
    		if (p2.getName().equals("")) 
    			throw new SpringException("Name is empty.");
    		order.setName(p2.getName());
    		order.setDescription(p2.getDescription());
    		if (p2.getPrice() < 0.0) 
    			throw new SpringException("Value is negative.");
    		order.setPrice(p2.getPrice());
    	} else {
    		// add
    		order.setId();
    	}
    	return "form/orderDetail";
    }   
    
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String orderDetail(@ModelAttribute("order") Order order, Model model) {
    	if (order.getPrice() < 0.0) 
			throw new SpringException("Value is negative.");
		if (order.getName().equals("")) 
			throw new SpringException("Name is empty.");    	

    	EMarketApp.getStore().getOrderList().removeIf(p -> (p.getId() == order.getId()));
    	EMarketApp.getStore().getOrderList().add(order);
   		
    	model.addAttribute("orderList", EMarketApp.getStore().getOrderList());
    	return "form/orderDetail";
    }   

    @RequestMapping(value = "/delete", method = RequestMethod.GET)
    public String orderMaster(@RequestParam(value="orderId", required=false, defaultValue="-1") int orderId, Model model) {
    	EMarketApp.getStore().getOrderList().removeIf(p -> (p.getId() == orderId));
    	model.addAttribute("orderList", EMarketApp.getStore().getOrderList());
    	return "form/orderMaster";
    }
}
