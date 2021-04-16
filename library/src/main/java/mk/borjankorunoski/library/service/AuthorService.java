package mk.borjankorunoski.library.service;

import mk.borjankorunoski.library.model.Author;

import java.util.List;

public interface AuthorService {
    int addAuthor(Author author);
    int deleteAuthor(long authorId);
    Author getAuthor(long authorId);
    List<Author> getAllAuthors();
    List<Author> getAllAuthorsByCountry(String countryName);
}
