package uk.ac.cf.cs.ons.skillsdb.skillsdb.users;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import uk.ac.cf.cs.ons.skillsdb.skillsdb.associatedskills.AssociatedSkillService;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

/**
 * UserController will return a HTML view for each HTTP route it is responsible for.
 *
 * @author  Humzah Hanif
 * @version 1.0
 * @since   2019-11-26
 */
@Controller
public class UserController {

    private UserService service;

    private AssociatedSkillService asService;

    /**
     * Allows for a UserController to be created with an implementation of UserService.
     *
     * @param service, implementation of UserService.
     */
    public UserController(UserService service, AssociatedSkillService asService) {
        this.service = service;
        this.asService = asService;
    }

    /**
     * Return a HTML view for each user page.
     *
     * @param id, Users unique id.
     * @return view
     */
    @GetMapping("user/{id}")
    public String showUserPage(@PathVariable("id") long id, Model model){

        Optional<User> user = service.findUserByIndex(id);

        if (user.isPresent()) {
            model.addAttribute("userKey", user.get());
            model.addAttribute("uid", id);
            return "users/user_profile";
        } else {
            return "404";
        }
    }

    /**
     * Return a HTML view for searching for users.
     *
     * @param searchTerm, Users usernames.
     * @return view
     */
    @GetMapping("findUser")
    public String findUser(@RequestParam("search") String searchTerm, Model model) {

        Optional<List<User>> users = service.findUserBySearch(searchTerm);

        if (users.isPresent()) {
            model.addAttribute("searchTermKey", searchTerm);
            model.addAttribute("usersKey", users.get() );
            return "users/user_list";
        } else {
            return "404";
        }

    }

    @RequestMapping("deleteUser")
    public String deleteUser(@RequestParam("id") long id){
        service.deleteUserById(id);
        asService.deleteAssociatedSkillsByUserId(id);
        return "index";


    }
}
