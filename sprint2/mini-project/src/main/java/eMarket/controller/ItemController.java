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
import eMarket.domain.Item;

@Controller
@RequestMapping("/item")
public class ItemController {

    @RequestMapping("/")
    public String index(Model model) {
    	model.addAttribute("itemList", EMarketApp.getStore().getItemList());
        return "form/itemMaster";
    }
    
    @RequestMapping(value = "/itemDetail", method = RequestMethod.GET)
    public String itemDetail(Model model, @ModelAttribute("item") Item item, @RequestParam(value="itemId", required=false, defaultValue="-1") int itemId) {
/*    	if (itemId >= 0) {
    		// modify
    		Item p2 = EMarketApp.getStore().getItemList().stream().filter(p -> (((Item) p).getId() == itemId)).findAny().get();
    		item.setId(p2.getId());
    		if (p2.getName().equals("")) 
    			throw new SpringException("Name is empty.");
    		item.setName(p2.getName());
    		item.setDescription(p2.getDescription());
    		if (p2.getPrice() < 0.0) 
    			throw new SpringException("Value is negative.");
    		item.setPrice(p2.getPrice());
    	} else {
    		// add
    		item.setId();
    	}*/
    	model.addAttribute("itemList", EMarketApp.getStore().getItemList());
    	return "form/itemDetail";
    }   
    
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String itemMaster(@ModelAttribute("item") Item item, Model model) {
    	if (item.getAmount() < 0.0) 
			throw new SpringException("Value is negative.");
		if (item.getName().equals("")) 
			throw new SpringException("Name is empty.");    	

    	EMarketApp.getStore().getItemList().removeIf(p -> (p.getId() == item.getId()));
//    	EMarketApp.getStore().getItemList().add(item);
   		
    	model.addAttribute("itemList", EMarketApp.getStore().getItemList());
        return "form/itemMaster";
//    	return "redirect:/item/";
    }   

    @RequestMapping(value = "/delete", method = RequestMethod.GET)
    public String itemMaster(@RequestParam(value="itemId", required=false, defaultValue="-1") int itemId, Model model) {
    	EMarketApp.getStore().getItemList().removeIf(p -> (p.getId() == itemId));
    	model.addAttribute("itemList", EMarketApp.getStore().getItemList());
    	return "form/itemMaster";
    }   
    
    
    
}
