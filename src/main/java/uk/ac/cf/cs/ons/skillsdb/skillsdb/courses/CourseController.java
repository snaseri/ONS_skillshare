package uk.ac.cf.cs.ons.skillsdb.skillsdb.courses;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
public class CourseController {

    private CourseRepository courseRepo;

    public CourseController(CourseRepository aRepo) {
        courseRepo = aRepo;
    }


    @GetMapping(path = "/course/create")
    public String createCourse(Model model) {
        model.addAttribute("course", new Course());
        return "courses/create";
    }

    @PostMapping("course/create")
    public String submitAdvert(@ModelAttribute("course") @Valid Course course, BindingResult result) {

        if ( result.hasErrors() ) {
            return "courses/create";
        }

        //TODO set the user as the logged in user
        course.setUser(null);
        courseRepo.save(course);

        return "redirect:/course/" + course.getId();
    }

}
