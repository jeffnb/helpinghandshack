package org.helpinghands;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HelloWorldController {

    @RequestMapping("/")
    public String index(Model model) {
    	if( Math.random() > 0.5){
    		model.addAttribute("name", "RandomPerson");
    	}
    	return "index";
    }

}
