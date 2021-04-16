package mk.borjankorunoski.library.service.impl;

import mk.borjankorunoski.library.model.Country;
import mk.borjankorunoski.library.repository.CountryRepository;
import mk.borjankorunoski.library.service.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CountryServiceImpl implements CountryService {
    @Autowired
    CountryRepository countryRepository;
    public Country getCountry(String countryName) {
        return countryRepository.findCountryByName(countryName).orElse(new Country());
    }

    @Override
    public Country getCountry(long countryId) {
        return countryRepository.findById(countryId).orElse(new Country());
    }

    @Override
    public List<Country> getAllCountries() {
        return countryRepository.findAll();
    }

    @Override
    public List<Country> getAllCountriesByContinent(String continent) {
        return countryRepository.findCountryByContinent(continent);
    }

    @Override
    public int addCountry(Country country) {
        countryRepository.save(country);
        return 1;
    }

    @Override
    public int deleteCountry(long countryId) {
        return 0;
    }
}
