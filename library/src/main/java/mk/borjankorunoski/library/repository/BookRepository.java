package mk.borjankorunoski.library.repository;

import mk.borjankorunoski.library.model.Author;
import mk.borjankorunoski.library.model.Book;
import mk.borjankorunoski.library.model.enumerations.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book,Long> {
    Book getBookByName(String name);
    List<Book> getBooksByAuthor(Author author);
    List<Book> getBooksByCategory(Category category);
}
