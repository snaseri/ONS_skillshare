package uk.ac.cf.cs.ons.skillsdb.skillsdb.search;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uk.ac.cf.cs.ons.skillsdb.skillsdb.adverts.Advert;
import uk.ac.cf.cs.ons.skillsdb.skillsdb.adverts.AdvertRepository;
import uk.ac.cf.cs.ons.skillsdb.skillsdb.courses.Course;
import uk.ac.cf.cs.ons.skillsdb.skillsdb.courses.CourseRepository;
import uk.ac.cf.cs.ons.skillsdb.skillsdb.users.User;
import uk.ac.cf.cs.ons.skillsdb.skillsdb.users.UserRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Service
public class SearchServiceImpl implements SearchService {

    private UserRepository userRepository;

    private AdvertRepository advertRepository;

    private CourseRepository courseRepository;

    @Autowired
    public SearchServiceImpl(UserRepository userRepository, AdvertRepository advertRepository, CourseRepository courseRepository) {
        this.userRepository = userRepository;
        this.advertRepository = advertRepository;
        this.courseRepository = courseRepository;
    }


    @Override
    public Optional<List<SearchResult>> searchByTitle(String title, SearchType type) {
        switch(type) {
            case USER:
                return searchByUser(title);
            case ADVERT:
                return searchByAdvert(title);
            default:
            case COURSE:
                return searchByCourse(title);
        }
    }

    private Optional<List<SearchResult>> searchByCourse(String terms) {

        // TODO: Carl, how can I improve this?

        List<SearchResult> results = new ArrayList<>();

        Optional<List<Course>> courses = courseRepository.findByNameContains(terms);

        if ( courses.isPresent() ) {
            for( Course c: courses.get() ) {
                results.add( SearchResult.of(c.getName(), c.getDescription(), c.getUrl()) );
            }
            return Optional.of(results);
        } else {
            return Optional.empty();
        }

    }

    private Optional<List<SearchResult>> searchByAdvert(String terms) {

        // TODO: Carl, how can I improve this?

        List<SearchResult> results = new ArrayList<>();

        Optional<List<Advert>> adverts = advertRepository.findByTitleContains(terms);

        if ( adverts.isPresent() ) {
            for(Advert a: adverts.get()) {
                results.add( SearchResult.of( a.getTitle(), a.getDescription(), a.getUrl() ) );
            }
            return Optional.of(results);
        } else {
            return Optional.empty();
        }

    }

    private Optional<List<SearchResult>> searchByUser(String  terms) {

        // TODO: Carl, how can I improve this?

        List<SearchResult> results = new ArrayList<>();

        Optional<List<User>> users = userRepository.findByUsernameContains(terms);

        if ( users.isPresent() ) {
            for(User u: users.get()) {
                results.add( SearchResult.of( u.getUsername(), u.getUsername(), u.getUrl() ) );
            }
            return Optional.of(results);
        } else {
            return Optional.empty();
        }

    }
}
