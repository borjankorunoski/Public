package mk.borjankorunoski.library.repository;

import mk.borjankorunoski.library.model.Author;
import mk.borjankorunoski.library.model.Country;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AuthorRepository extends JpaRepository<Author,Long> {
    List<Author> findAuthorsByCountry(Country country);
}
