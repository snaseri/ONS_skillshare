package uk.ac.cf.cs.ons.skillsdb.skillsdb.users.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import uk.ac.cf.cs.ons.skillsdb.skillsdb.users.dao.UserDao;
import uk.ac.cf.cs.ons.skillsdb.skillsdb.users.model.User;
import uk.ac.cf.cs.ons.skillsdb.skillsdb.users.service.UserService;

import javax.validation.Valid;

@Controller
public class loginController {

    @Autowired
    UserService userService;

    @Autowired
    UserDao userdao;

/*

    @Autowired
    UserRepository userRepository;
*/




    @RequestMapping(value = "/home", method = RequestMethod.GET)
    public String home(Model model, @AuthenticationPrincipal UserDetails currentUser) {


        User user = userdao.findUserByUsername(currentUser.getUsername());
        model.addAttribute("currentuser", user);
        return "home";
    }











    @RequestMapping(value = { "/login" }, method = RequestMethod.GET)
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
            userService.saveUser(user);
            modelAndView.addObject("successMessage", "User is registered successfully!");
        }
        modelAndView.addObject("user", new User());
        modelAndView.setViewName("login");
        return modelAndView;
    }





}
