package uk.ac.cf.cs.ons.skillsdb.skillsdb.users.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import uk.ac.cf.cs.ons.skillsdb.skillsdb.users.User;
import uk.ac.cf.cs.ons.skillsdb.skillsdb.users.repository.UserRepository;
import uk.ac.cf.cs.ons.skillsdb.skillsdb.users.UserService;

import javax.validation.Valid;

@Controller
public class loginController {

    @Autowired
    UserService userService;




    @Autowired
    UserRepository userRepository;




    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public String index(Model model, @AuthenticationPrincipal UserDetails currentUser) {


        UserDetails user = currentUser;
        model.addAttribute("user", user);
        return "index";
    }













    @RequestMapping(value = { "/login", "/" }, method = RequestMethod.GET)
    public ModelAndView login() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("login");
        return modelAndView;
    }




    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public ModelAndView register() {
        ModelAndView modelAndView = new ModelAndView();
        User user = new User();
        modelAndView.addObject("user", user);
        modelAndView.setViewName("register");
        return modelAndView;
    }




    // POST METHODS

    @RequestMapping(value="/register", method=RequestMethod.POST)
    public ModelAndView registerUser(@Valid User user, BindingResult bindingResult, ModelMap modelMap) {
        ModelAndView modelAndView = new ModelAndView();
        // Check for the validations
        if(bindingResult.hasErrors()) {
            modelAndView.addObject("successMessage", "Please correct the errors in form!");
            modelMap.addAttribute("bindingResult", bindingResult);

        }

        else {
            userService.save(user);
            modelAndView.addObject("successMessage", "User is registered successfully!");
        }
        modelAndView.addObject("user", new User());
        modelAndView.setViewName("login");
        return modelAndView;
    }





}
