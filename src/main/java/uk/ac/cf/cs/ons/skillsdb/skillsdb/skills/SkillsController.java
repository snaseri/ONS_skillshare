package uk.ac.cf.cs.ons.skillsdb.skillsdb.skills;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import uk.ac.cf.cs.ons.skillsdb.skillsdb.users.UserService;

import java.util.Optional;

@Controller
public class SkillsController {

    private UserService userRepo;
    private SkillRepository skillRepo;


    public SkillsController(SkillRepository sRepo,UserService uRepo){
        userRepo=uRepo;
        skillRepo=sRepo;

    }

    /**
     * Return a HTML with the skill name, description, child and parent if exists,
     * courses, adverts and all the users who know the skill.
     *
     * @param name, skills unique name.
     * @return view
     */
    @GetMapping("skill/{i}")
    public String showUserPage(@PathVariable("i") String name, Model model){

        Optional<Skill> skill = skillRepo.findSkillByName(name);

        if (skill.isPresent()) {
            model.addAttribute("skillKey", skill.get());
            return "skill/skillprofile";
        } else {
            return "404";
        }
    }
}
