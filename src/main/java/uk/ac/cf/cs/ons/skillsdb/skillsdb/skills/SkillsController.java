package uk.ac.cf.cs.ons.skillsdb.skillsdb.skills;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import uk.ac.cf.cs.ons.skillsdb.skillsdb.skilltaxonomy.SkillTaxonomy;
import uk.ac.cf.cs.ons.skillsdb.skillsdb.skilltaxonomy.TaxonomyRepository;
import uk.ac.cf.cs.ons.skillsdb.skillsdb.users.UserService;

import java.util.List;
import java.util.Optional;

@Controller
public class SkillsController {

    private UserService userRepo;
    private SkillRepository skillRepo;
    private TaxonomyRepository taxoRepo;


    public SkillsController(SkillRepository sRepo,UserService uRepo, TaxonomyRepository tRepo){
        userRepo=uRepo;
        skillRepo=sRepo;
        taxoRepo=tRepo;

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
        List<SkillTaxonomy> children = taxoRepo.findAllByParentName(name);
        List<SkillTaxonomy> parent = taxoRepo.findAllByChildName(name);

        if (skill.isPresent()) {
            model.addAttribute("skillKey", skill.get());
            model.addAttribute("childKey", children);
            model.addAttribute("parentKey", parent);

            return "skill/skillprofile";
        } else {
            return "404";
        }
    }
}
