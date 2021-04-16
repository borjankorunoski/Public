package mk.borjankorunoski.library.service;

import mk.borjankorunoski.library.model.Country;

import java.util.List;

public interface CountryService {
    Country getCountry(long countryId);
    List<Country> getAllCountries();
    List<Country> getAllCountriesByContinent(String continent);
    int addCountry(Country country);
    int deleteCountry(long countryId);
}
