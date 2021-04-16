package mk.borjankorunoski.library.web.controller.REST;

import mk.borjankorunoski.library.model.Author;
import mk.borjankorunoski.library.service.AuthorService;
import mk.borjankorunoski.library.service.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/auth")
@CrossOrigin
public class AuthorController {
    @Autowired
    AuthorService authorService;
    @Autowired
    CountryService countryService;
    @GetMapping(value = "/{id}", produces = "application/json")
    public Author getAuthor(@PathVariable long id){
        return authorService.getAuthor(id);
    }
    @GetMapping(value = "/all", produces = "application/json")
    public List<Author> getAllAuthors(){
        return authorService.getAllAuthors();
    }
    @PostMapping(value = "/{countryId}", consumes = "application/json", produces = "application/json")
    public int addAuthor(@RequestBody Author author, @PathVariable long countryId){
        author.setCountry(countryService.getCountry(countryId));
        authorService.addAuthor(author);
        return 1;
    }
    @PatchMapping(value = "/edit/{id}", consumes = "application/json", produces = "application/json" )
    public int editAuthor(@RequestBody Author neu, @PathVariable long id){
        Author alt = authorService.getAuthor(id);
        if(neu.getName()!=null){
            alt.setName(neu.getName());
        }
        if(neu.getSurname()!=null){
            alt.setSurname(neu.getSurname());
        }
        if(neu.getCountry()!=null){
            alt.setCountry(neu.getCountry());
        }
        return authorService.addAuthor(alt);
    }
    @DeleteMapping(value = "/del/{id}")
    public int deleteAuthor(@PathVariable long id){
        return authorService.deleteAuthor(id);
    }
}
