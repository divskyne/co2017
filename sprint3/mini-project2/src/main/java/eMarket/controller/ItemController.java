/**
 * (C) Artur Boronat, 2015
 */
package eMarket.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import eMarket.EMarketApp;
import eMarket.domain.Order;
import eMarket.domain.OrderItem;
import eMarket.domain.Product;
import eMarket.domain.Store;
import eMarket.repository.ItemRepository;
import eMarket.repository.OrderRepository;
import eMarket.repository.ProductRepository;
import eMarket.repository.StoreRepository;

@Controller
@RequestMapping("/item")
public class ItemController {
	
	@Autowired StoreRepository storeRepo;
	@Autowired ItemRepository itemRepo;
	@Autowired OrderRepository orderRepo;
	
    @RequestMapping(value = "/detail", method = RequestMethod.GET)
    public String itemDetail(
    		@ModelAttribute("itemFormDto") ItemFormDto itemFormDto, 
    		@RequestParam(value="itemId", required=false, defaultValue="-1") int itemId, 
    		@RequestParam(value="orderId", required=true, defaultValue="-1") int orderId
    ) {
    	Store store = storeRepo.findByName(EMarketApp.STORE_NAME).get(0);
    	if (itemId > -1) {
    		Order order = store.getOrderList().stream().filter(o -> o.getId() == orderId).findFirst().orElse(null);
	    	OrderItem item = order.getItemList().stream().filter(p -> p.getId()==itemId).findFirst().orElse(null);
	    	itemFormDto.setId(itemId);
	    	itemFormDto.setProductId(item.getProduct().getId());
	    	itemFormDto.setAmount(item.getAmount());
    	}
    	itemFormDto.setOrderId(orderId);
    	itemFormDto.setProductList(store.getProductList());
    	return "form/itemDetail";
    }   
    
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    @ExceptionHandler(SpringException.class)
    public String add(@ModelAttribute("itemFormDto") ItemFormDto itemFormDto, @RequestParam(value="action") String action,  Model model) {
    	Store store = storeRepo.findByName(EMarketApp.STORE_NAME).get(0);
    	if (itemFormDto.getAmount() < 0) 
    	{
			throw new SpringException("Amount is negative.");
    	}
    	
    	Order order = store.getOrderList().stream().filter(o -> o.getId() == itemFormDto.getOrderId()).findAny().orElse(null);
        	
    	if (action.startsWith("Submit")) {
    		Optional<OrderItem> itemOp = order.getItemList().stream().filter(p -> (p.getId() == itemFormDto.getId())).findFirst();
    		if (itemOp.isPresent()) {
    			OrderItem item = itemOp.get();
    			Product product = store.getProductList().stream().filter(p -> p.getId() == itemFormDto.getProductId()).findFirst().get();
    			item.setProduct(product);
    			item.setAmount(itemFormDto.getAmount());
    			item.setCost(item.getProduct().getPrice() * item.getAmount());
    			order.updateCost();
    			itemRepo.save(item);
    		} else {
    			Product product = store.getProductList().stream().filter(p -> p.getId() == itemFormDto.getProductId()).findFirst().get();
    			order.addItem(product, itemFormDto.getAmount());
    			orderRepo.save(order);
    		}
    		storeRepo.save(store);
    	} 
    	model.addAttribute("order", order);
    	return "form/orderDetail";
    }   

    @RequestMapping(value = "/delete", method = RequestMethod.GET)
    public String delete(
    		@RequestParam(value="itemId", required=false, defaultValue="-1") int itemId, 
    		@RequestParam(value="orderId", required=true, defaultValue="-1") int orderId,
    		Model model
    ) {
    	Store store = storeRepo.findByName(EMarketApp.STORE_NAME).get(0);
    	Order order = store.getOrderList().stream().filter(o -> o.getId()==orderId).findFirst().get();
    	order.getItemList().removeIf(p -> p.getId()==itemId);
    	order.updateCost();
    	storeRepo.save(store);
    	model.addAttribute("order", order);
    	return "form/orderDetail";
    }   
    


    
}
