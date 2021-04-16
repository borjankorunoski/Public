package mk.borjankorunoski.library.repository;

import mk.borjankorunoski.library.model.Country;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CountryRepository extends JpaRepository<Country,Long> {
    Optional<Country> findCountryByName(String name);
    List<Country> findCountryByContinent(String continent);
}
