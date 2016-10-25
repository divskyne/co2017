/**
 * (C) Artur Boronat, 2016
 */
package eMarket.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import eMarket.EMarketApp;
import eMarket.domain.Product;

@Controller
@RequestMapping("/product")
public class ProductController {

    @RequestMapping("/")
    public String index(Model model) {
    	model.addAttribute("productList", EMarketApp.getStore().getProductList());
        return "form/productMaster";
    }
    
    @RequestMapping(value = "/productDetail", method = RequestMethod.GET)
    public String productDetail(@ModelAttribute("product") Product product, @RequestParam(value="productId", required=false, defaultValue="-1") int productId) {
    	if (productId >= 0) {
    		// modify
    		Product p2 = EMarketApp.getStore().getProductList().stream().filter(p -> (((Product) p).getId() == productId)).findAny().get();
    		product.setId(p2.getId());
    		product.setName(p2.getName());
    		product.setDescription(p2.getDescription());
    		product.setPrice(p2.getPrice());
    	} else {
    		// add
    		product.setId();
    	}
    	return "form/productDetail";
    }   
    
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String productMaster(@ModelAttribute("product") Product product, Model model) {

    	EMarketApp.getStore().getProductList().removeIf(p -> (p.getId() == product.getId()));
    	EMarketApp.getStore().getProductList().add(product);
   		
    	model.addAttribute("productList", EMarketApp.getStore().getProductList());
        return "form/productMaster";
    }   

    @RequestMapping(value = "/delete", method = RequestMethod.GET)
    public String productMaster(@RequestParam(value="productId", required=false, defaultValue="-1") int productId, Model model) {
    	EMarketApp.getStore().getProductList().removeIf(p -> (p.getId() == productId));
    	model.addAttribute("productList", EMarketApp.getStore().getProductList());
    	return "form/productMaster";
    }   
    
    
    
}
