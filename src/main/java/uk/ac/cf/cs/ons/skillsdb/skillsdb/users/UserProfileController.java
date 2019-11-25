package uk.ac.cf.cs.ons.skillsdb.skillsdb.users;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Optional;

@Controller
public class UserProfileController {

    private UserFinder finder;

    public UserProfileController(UserFinder aFinder) { finder = aFinder;}

    @GetMapping("user/{i}")
    public String showUserPage(@PathVariable("i") Long index, Model model){

        Optional<User> user = finder.findUserByIndex(index);

        if (user.isPresent()) {
            model.addAttribute("userKey", user.get());
            return "user_profile";
        } else {
            return "404";
        }
    }

    @GetMapping("findUser")
    public String findUser(@RequestParam("search") String searchTerm, Model model) {

        List<User> users = finder.findUserBySearch(searchTerm);

        model.addAttribute("searchTermKey", searchTerm);
        model.addAttribute("usersKey", users);

        return "user_list";
    }
}
