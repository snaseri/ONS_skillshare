package uk.ac.cf.cs.ons.skillsdb.skillsdb.courses;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class CourseController {

    private final static String CREATE_PAGE = "courses/create";
    private final static String COURSES_PAGE = "courses/course";


    public CourseController() {

    }

    @RequestMapping(path = "/course/create", method = RequestMethod.GET)
    public String createCourse(Model model) {

        model.addAttribute("sponsorKey", new CourseForm());
        return null;
    }

}
