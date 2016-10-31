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

    @RequestMapping(value = "/student", method = RequestMethod.GET)
    public String student(@ModelAttribute("student") Student student) {
    	return "form/form";
    }
    
    // use @ModelAttribute when the page contains a form
    // or else use Model
    @RequestMapping(value = "/addStudent", method = RequestMethod.POST)
    public String addStudent(@ModelAttribute("student") Student student,  Model model) {
       model.addAttribute("name", student.getName());
       model.addAttribute("age", student.getAge());
       model.addAttribute("id", student.getId());
       return "form/result";
    }  
    
}
