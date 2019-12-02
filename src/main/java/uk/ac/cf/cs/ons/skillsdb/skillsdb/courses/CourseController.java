package uk.ac.cf.cs.ons.skillsdb.skillsdb.courses;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import uk.ac.cf.cs.ons.skillsdb.skillsdb.enrolledoncourse.EnrolledOnCourse;
import uk.ac.cf.cs.ons.skillsdb.skillsdb.enrolledoncourse.EnrolledRepository;
import uk.ac.cf.cs.ons.skillsdb.skillsdb.skills.SkillRepository;
import uk.ac.cf.cs.ons.skillsdb.skillsdb.users.User;

import javax.validation.Valid;
import java.util.Optional;

@Controller
public class CourseController {

    private CourseRepository courseRepo;
    private SkillRepository skillRepo;
    private EnrolledRepository enrollRepo;

    public CourseController(CourseRepository aRepo, SkillRepository sRepo, EnrolledRepository eRepo) {
        courseRepo = aRepo;
        skillRepo = sRepo;
        enrollRepo = eRepo;
    }


    @GetMapping(path = "/course/create")
    public String createCourse(Model model) {
        model.addAttribute("course", new Course());
        model.addAttribute("skills", skillRepo.findAll());
        return "courses/create";
    }

    @PostMapping("/course/create")
    public String submitCourse(@ModelAttribute("course") @Valid Course course, BindingResult result, Model model) {

        if ( result.hasErrors() ) {
            model.addAttribute("skills", skillRepo.findAll());
            return "courses/create";
        }

        //TODO set the user as the logged in user
        User defaultUser = new User();
        defaultUser.setPassword("password");
        defaultUser.setUsername("username");
        course.setUser(defaultUser);
        courseRepo.save(course);

        return "redirect:/courses/" + course.getId();
    }

    @GetMapping("/courses/{id}")
    public String coursePage(@PathVariable("id") Long id, Model model) {
        
            Optional<Course> course = courseRepo.findById(id);
            if (!course.isPresent()) {
                return "404";
            }

            int enrolledUsers = enrollRepo.countAllByCourseIdIs(course.get().getId());
            model.addAttribute("course", course.get());
            model.addAttribute("enrolled", enrolledUsers);


        return "courses/course";
    }

    @PostMapping("/courses/{id}")
    public String courseEnroll(@PathVariable("id") Long id, Model model) {

        Optional<Course> course = courseRepo.findById(id);
        if (!course.isPresent()) {
            return "404";
        }

        //TODO set the user as the logged in user
        User defaultUser = new User();
        defaultUser.setPassword("password");
        defaultUser.setUsername("username");

        EnrolledOnCourse enroll = new EnrolledOnCourse();

        enroll.setCourse(course.get());
        enroll.setUser(defaultUser);

        enrollRepo.save(enroll);

        model.addAttribute("course", course.get());
        model.addAttribute("enroll", enroll);

        return "index";
    }


}
