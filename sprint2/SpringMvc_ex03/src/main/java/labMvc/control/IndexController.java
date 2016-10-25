/**
 * (C) Artur Boronat, 2015
 */
package labMvc.control;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import labMvc.domain.Student;

@Controller
public class IndexController {
	
    @RequestMapping("/")
    public String index() {
        return "index";
    }

//    @RequestMapping(value = "/student", method = RequestMethod.GET)
    //TODO
    
//    @RequestMapping(value = "/addStudent", method = RequestMethod.POST)
    //TODO
}
