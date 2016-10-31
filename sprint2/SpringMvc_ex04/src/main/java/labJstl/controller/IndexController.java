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
    	if (productId>=0)
    	{
    		SimpleProduct individualProduct = productList.stream().filter(particular -> (particular.getId() == productId)).findAny().get();
    		product.setId(individualProduct.getId());
    		product.setName(individualProduct.getName());
    		product.setDescription(individualProduct.getDescription());
    		product.setPrice(individualProduct.getPrice());
    	}
    	else
    	{
    		product.setId(SimpleProduct.lastId);
    		SimpleProduct.lastId++;
    	}
    	return "form/detail";
    }   
    
    @RequestMapping(value = "/addProduct", method = RequestMethod.POST)
    public String addProduct(@ModelAttribute("product") SimpleProduct product, Model model) {
    	productList.removeIf(particular -> (particular.getId() == product.getId()));
    	productList.add(product);
    	model.addAttribute("productList", productList);

    	return "form/master";
    }   

    @RequestMapping(value = "/deleteProduct", method = RequestMethod.GET)
    public String deleteProduct(@RequestParam(value="productId", required=false, defaultValue="-1") int productId, Model model) {
    	productList.removeIf(particular -> (particular.getId() == productId));
    	model.addAttribute("productList", productList);

    	return "form/master";
    }   
    
    
    
}
