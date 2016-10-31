/**
 * (C) Artur Boronat, 2015
 */
package labJstl.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import labJstl.domain.SimpleProduct;

@Controller
public class IndexController {

	List<SimpleProduct> productList = new ArrayList<>();	
	
    @RequestMapping("/")
    public String index(Model model) {
    	model.addAttribute("productList", productList);
        return "form/master";
    }
    
    @RequestMapping(value = "/productDetail", method = RequestMethod.GET)
    public String productDetail(@ModelAttribute("product") SimpleProduct product, @RequestParam(value="productId", required=false, defaultValue="-1") int productId) {
    	// TODO: exercise
    	if (productId >= 0) {
    		// modify
    		SimpleProduct p2 = productList.stream().filter(p -> (p.getId() == productId)).findAny().get();
    		product.setId(p2.getId());
    		product.setName(p2.getName());
    		product.setDescription(p2.getDescription());
    		product.setPrice(p2.getPrice());
    	} else {
    		// add
    		product.setId(SimpleProduct.lastId);
    		SimpleProduct.lastId++;
    	}
    	return "form/detail";
    }   
    
    @RequestMapping(value = "/addProduct", method = RequestMethod.POST)
    public String addStudent(@ModelAttribute("product") SimpleProduct product, Model model) {
    	// TODO: exercise
   		productList.removeIf(p -> (p.getId() == product.getId()));
   		productList.add(product);
   		
    	model.addAttribute("productList", productList);
        return "form/master";
    }   

    @RequestMapping(value = "/deleteProduct", method = RequestMethod.GET)
    public String deleteStudent(@RequestParam(value="productId", required=false, defaultValue="-1") int productId, Model model) {
    	// TODO: exercise
    	productList.removeIf(p -> (p.getId() == productId));
    	model.addAttribute("productList", productList);
    	return "form/master";
    }   
    
    
    
}
