/**
 * (C) Artur Boronat, 2015
 */
package eMarket.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import eMarket.EMarketApp;
import eMarket.domain.Order;
import eMarket.domain.Store;
import eMarket.repository.OrderRepository;
import eMarket.repository.ProductRepository;
import eMarket.repository.StoreRepository;

@Controller
@RequestMapping("/order")
public class OrderController {
	
	@Autowired StoreRepository storeRepo;
	@Autowired ProductRepository productRepo;
	@Autowired OrderRepository orderRepo;
	
    @RequestMapping("/")
    public String orderMaster(Model model) {
    	Store store = storeRepo.findByName(EMarketApp.STORE_NAME).get(0);
       	model.addAttribute("orderList", store.getOrderList());
        return "form/orderMaster";
    }	
   
    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String orderDetail(@ModelAttribute("order") Order order, Model model, @RequestParam(value="orderId", required=false, defaultValue="-1") int orderId) {
    	
    	Store store = storeRepo.findByName(EMarketApp.STORE_NAME).get(0);
		if (orderId > -1) {    	   	
	    	Order orderAux = store.getOrderList().stream().filter(o -> o.getId()==orderId).findFirst().orElse(null); // might give nullpointer in future
	    	order.setId(orderAux.getId());
	    	order.setDate(orderAux.getDate());
	    	order.setItemList(orderAux.getItemList());
	    	order.setUser(orderAux.getUser());
	    	order.setCost(orderAux.getCost());
    	}
	    	else {
	    	    order.setId();
        		store.getOrderList().add(order);
	    	}

    	storeRepo.save(store);
    	model.addAttribute("orderList", store.getOrderList());
    	
    	return "form/orderDetail";
    }   

    @RequestMapping(value = "/delete", method = RequestMethod.GET)
    public String delete(@RequestParam(value="orderId", required=false, defaultValue="-1") int orderId, Model model) {
    	
    	Store store = storeRepo.findByName(EMarketApp.STORE_NAME).get(0);
    	store.getOrderList().removeIf(p -> (p.getId() == orderId));
    	storeRepo.save(store);
    	model.addAttribute("orderList", store.getOrderList());
    	return "form/orderMaster";
    }   
   

    
}
