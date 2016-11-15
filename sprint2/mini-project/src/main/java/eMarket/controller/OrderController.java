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
import eMarket.domain.Product;

@Controller
@RequestMapping("/order")
public class OrderController {

    @RequestMapping("/")
    public String index(Model model) {
    	model.addAttribute("orderList", EMarketApp.getStore().getOrderList());
        return "form/orderMaster";
    }
    
    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String orderAdd(@ModelAttribute("order") Order order, @RequestParam(value="orderId", required=false, defaultValue="-1") int orderId) {
    	if (orderId >= 0) {
    	Order p2 = EMarketApp.getStore().getOrderList().stream().filter(p -> (((Order) p).getId() == orderId)).findAny().get();
    	Product p3 = EMarketApp.getStore().getProductList().stream().filter(p -> (((Product) p).getId() == orderId)).findAny().get();
		order.setId(p2.getId());
		order.setDescription(p2.getDescription());
		order.setCost(p2.getCost());
    	
    	}
    	else {
    		order.setId();
    	}
    	EMarketApp.getStore().getOrderList().add(order);
    	return "form/orderDetail";
    }  

    @RequestMapping(value = "/delete", method = RequestMethod.GET)
    public String orderMaster(@RequestParam(value="orderId", required=false, defaultValue="-1") int orderId, Model model) {
    	EMarketApp.getStore().getOrderList().removeIf(p -> (p.getId() == orderId));
    	model.addAttribute("orderList", EMarketApp.getStore().getOrderList());
    	return "form/orderMaster";
    }
    
    @RequestMapping(value = "/orderDetail", method = RequestMethod.GET)
    public String orderDetail(Model model, @ModelAttribute("order") Order order, @RequestParam(value="orderId", required=false, defaultValue="-1") int orderId) {
    	if (order.getPrice() < 0.0) 
			throw new SpringException("Value is negative.");
		if (order.getName().equals("")) 
			throw new SpringException("Name is empty.");    	

    	EMarketApp.getStore().getOrderList().removeIf(p -> (p.getId() == order.getId()));
    	EMarketApp.getStore().getOrderList().add(order);
    	return "form/orderDetail";
    }
    
}
