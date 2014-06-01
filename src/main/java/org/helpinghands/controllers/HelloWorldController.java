package org.helpinghands.controllers;
import org.helpinghands.Repositories.OrganizationRepository;
import org.helpinghands.models.Organization;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HelloWorldController {

    @Autowired
    OrganizationRepository organizationRepository;

    @RequestMapping("/")
    public ModelAndView map(){
        ModelAndView rval = new ModelAndView("map");
        rval.addObject("orgName", "Helping Hands Hackathon");

        return rval;
    }

    @RequestMapping("/organizations/{id}")
    public ModelAndView organization(@PathVariable String id){
        ModelAndView rval = new ModelAndView("organization");

        Organization org = organizationRepository.findOne(id);
        rval.addObject("org", org);

        return rval;
    }

}
