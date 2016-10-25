/**
 * (C) Artur Boronat, 2015
 */
package labMVC;

import java.util.Collection;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class IndexController {
    @RequestMapping("/hello")
    public String hello(Model model) {
        model.addAttribute("name", "World");
        return "hello";
    }
    
    // SOLUTION TO EXERCISES
    
    // USING PATH VARIABLES

    // The request: http://localhost:8090/greeting/User
    // should produce: Hello User!
    @RequestMapping("/greeting/{name}")
    public String greetingName(@PathVariable String name, Model model) {
        model.addAttribute("name", name);
        return "greeting";
    }
    
    // The request: http://localhost:8090/greeting/Alice/Bob
    // should produce: Hello Alice Bob!
    @RequestMapping("/greeting/{name}/{value}")
    public String greetingNameValue(@PathVariable String name, @PathVariable String value, Model model) {
        model.addAttribute("name", name.concat(" ").concat(value));
        return "greeting";
    }

    
	// The request: http://localhost:8090/greeting?name=User
	// should produce: Hello User!
	// The request: http://localhost:8090/greeting (i.e. no name parameter is specified)
	// should produce: Hello World!
    @RequestMapping("/greeting")
    public String greetingParam(@RequestParam(value="name", required=false, defaultValue="World") String name, Model model) {
        model.addAttribute("name", name);
        return "greeting";
    }

    
    // TYPE CONVERSION
	// The request: http://localhost:8090/greeting/primitive?value=1
	// should produce: Converted primitive 1
	@RequestMapping("/greeting/primitive")
	public String primitive(@RequestParam Integer value, Model model) {
		model.addAttribute("value", value);
		return "greeting";
	}
    
	// The request:  http://localhost:8090/greeting/date/2015-07-10
	// should produce: Converted date Fri Jul 10 01:00:00 BST 2015
	@RequestMapping("/greeting/date/{value}")
	public String date(@PathVariable @DateTimeFormat(iso=ISO.DATE) Date value, Model model) {
		model.addAttribute("value", value);
		return "greeting";
	}
    
	// The request: http://localhost:8090/greeting/collection?values=1&values=2&values=3&values=4&values=5
	// should produce: Converted collection [1, 2, 3, 4, 5]
	@RequestMapping("/greeting/collection")
	public String collection(@RequestParam Collection<Integer> values, Model model) {
		model.addAttribute("value", values);
		return "greeting";
	}    
}
