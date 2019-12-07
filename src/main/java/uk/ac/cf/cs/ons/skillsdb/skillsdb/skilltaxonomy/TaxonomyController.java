package uk.ac.cf.cs.ons.skillsdb.skillsdb.skilltaxonomy;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import uk.ac.cf.cs.ons.skillsdb.skillsdb.courses.Course;

import javax.validation.Valid;

@Controller
public class TaxonomyController {

    public TaxonomyController() {
    }


    @GetMapping(path = "/discover")
    public String createCourse(Model model) {

        return "discover";
    }

    @PostMapping("/discover")
    public String submitCourse(@ModelAttribute("course") @Valid Course course, BindingResult result, Model model) {
        return "discover";
    }
}
