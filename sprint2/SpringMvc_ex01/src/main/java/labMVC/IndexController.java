/**
 * (C) Artur Boronat, 2015
 */
package labMVC;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController 
{
	@RequestMapping("/hello")
    public String hello(Model model) {
        model.addAttribute("name", "World");
        return "hello";
    }
}
