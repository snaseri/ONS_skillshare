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
 * TODO: ...
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
     * TODO ...
     *
     * @param service
     */
    @Autowired
    public AdvertController(AdvertService service, SkillRepository skillRepository, TypeRepository typeRepository) {
        this.service = service;
        this.skillRepository = skillRepository;
        this.typeRepository = typeRepository;
    }


    /**
     * TODO: ...
     *
     * @return
     */
    @GetMapping("/create")
    public String createAdvert(Model model) {
        model.addAttribute("advert", new Advert());

        // Used to prepopulate the dropdowns...
        model.addAttribute("skills", skillRepository.findAll());
        model.addAttribute("types", typeRepository.findAll());

        return CREATE_PAGE;
    }


    /**
     * TODO: ...
     *
     * @param advert
     * @param result
     * @return
     */
    @PostMapping("/create")
    public String submitAdvert(@ModelAttribute("advert") @Valid Advert advert, BindingResult result) {

        if ( result.hasErrors() ) {
            return CREATE_PAGE;
        }

        service.createAdvert(advert);

        // TODO: Carl, Is there a better way of redirecting.
        return "redirect:/advert/" + advert.getId();
    }

    @GetMapping("/{id}")
    public String advertPage(@PathVariable("id") int id, Model model) {

        // TODO: Remove AdvertNotFound, this can be prevented with Optional...
        // TODO: Fix .get()


        String skill;
        String type;

        try {
            Optional<Advert> advert = service.readAdvert(id);

            skill = skillRepository.findById( advert.get().getSkillId() ).get().getName();
            type = typeRepository.findById( advert.get().getTypeId() ).get().getName().toString();

            log.info(skill);
            log.info(type);

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
