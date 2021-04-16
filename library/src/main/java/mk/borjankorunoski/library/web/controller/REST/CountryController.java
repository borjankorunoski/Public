package mk.borjankorunoski.library.web.controller.REST;

import mk.borjankorunoski.library.model.Country;
import mk.borjankorunoski.library.service.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/country")
@CrossOrigin
public class CountryController {
    @Autowired
    CountryService countryService;

    @GetMapping(value = "/{id}", produces = "application/json")
    public Country getCountry(@PathVariable long id){
        return countryService.getCountry(id);
    }

    @GetMapping(value = "/all", produces = "application/json")
    public List<Country> getAllCountries(){
        return countryService.getAllCountries();
    }

    @PostMapping(consumes = "application/json", produces = "application/json")
    public int addCountry(@RequestBody Country country){
        return countryService.addCountry(country);
    }

    @PatchMapping(value = "/edit/{id}",consumes = "application/json", produces = "application/json")
    public int editCountry(@RequestBody Country neu, @PathVariable long id){
        Country old = countryService.getCountry(id);
        if(neu.getName()!=null){
            old.setName(neu.getName());
        }
        if(neu.getContinent()!=null){
            old.setContinent(neu.getContinent());
        }
        return countryService.addCountry(old);
    }

    @DeleteMapping(value = "/del/{id}")
    public int deleteCountry(@PathVariable long id){
        return countryService.deleteCountry(id);
    }
}
