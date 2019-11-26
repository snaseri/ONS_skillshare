package uk.ac.cf.cs.ons.skillsdb.skillsdb.adverts;

import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import uk.ac.cf.cs.ons.skillsdb.skillsdb.adverts.exceptions.AdvertNotFoundException;
import uk.ac.cf.cs.ons.skillsdb.skillsdb.skills.SkillRepository;
import uk.ac.cf.cs.ons.skillsdb.skillsdb.types.TypeRepository;

import javax.validation.Valid;
import java.util.Optional;

/**
 * AdvertController controls HTTP Protocols access to the Adverts.
 *
 * @author   Kyle Davies
 * @version  1.0
 * @since    2019-11-20
 * @url      https://spring.io/guides/gs/validating-form-input/
 */
@Log
@Controller
@RequestMapping("/advert")
public class AdvertController {

    private final static String CREATE_PAGE = "adverts/create";
    private final static String ADVERT_PAGE = "adverts/advert";

    private SkillRepository skillRepository;
    private TypeRepository typeRepository;

    private AdvertService service;

    /**
     * Create a instance of AdvertController by injecting an implementation of {@see SkillRepository}, {@see TypeRepository},
     * and {@see TypeRepository} interfaces.
     *
     * @param service
     * @param skillRepository
     * @param typeRepository
     */
    @Autowired
    public AdvertController(AdvertService service, SkillRepository skillRepository, TypeRepository typeRepository) {
        this.service = service;
        this.skillRepository = skillRepository;
        this.typeRepository = typeRepository;
    }

    /**
     * Handles HTTP GET requests to /advert/create by returning a view.
     *
     * @param model model
     * @return view
     */
    @GetMapping("/create")
    public String createAdvert(Model model) {
        model.addAttribute("advert", new Advert());
        // Used to prepopulate the dropdowns for Skill, and Type.
        model.addAttribute("skills", skillRepository.findAll());
        model.addAttribute("types", typeRepository.findAll());

        return CREATE_PAGE;
    }


    /**
     * Handles HTTP POST requests to /advert/create/submit by returning a view of CREATE_PAGE if there is an error.
     * Or by submitting the data and redirecting them to the view of the advert that they have created.
     *
     * @param advert created Advert.
     * @param result result if there are errors
     * @return view - the selected view to return
     */
    @PostMapping("/create")
    public String submitAdvert(@ModelAttribute("advert") @Valid Advert advert, BindingResult result, Model model) {

        if ( result.hasErrors() ) {
            model.addAttribute("skills", skillRepository.findAll());
            model.addAttribute("types", typeRepository.findAll());
            return CREATE_PAGE;
        }

        service.createAdvert(advert);

        // TODO: Carl, Is there a better way of redirecting.
        return "redirect:/advert/" + advert.getId();
    }

    /**
     * Handles HTTP GET requests to /advert/{1} by returning a view of ADVERT_PAGE if the ADVERT exists otherwise CREATE_PAGE
     *
     * @param id of Advert
     * @param model page model
     * @return view
     */
    @GetMapping("/{id}")
    public String advertPage(@PathVariable("id") int id, Model model) {

        String skill;
        String type;

        try {
            Optional<Advert> advert = service.readAdvert(id);

            skill = skillRepository.findById( advert.get().getSkillId() ).get().getName();
            type = typeRepository.findById( advert.get().getTypeId() ).get().getName().toString();

            model.addAttribute("advert", advert.get());
            model.addAttribute("skill", skill);
            model.addAttribute("type", type);

        } catch (AdvertNotFoundException e) {
            e.printStackTrace();
            return CREATE_PAGE;
        }

        return ADVERT_PAGE;
    }



}
