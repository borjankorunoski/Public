package mk.borjankorunoski.library.service.impl;

import mk.borjankorunoski.library.model.Author;
import mk.borjankorunoski.library.model.Country;
import mk.borjankorunoski.library.repository.AuthorRepository;
import mk.borjankorunoski.library.repository.CountryRepository;
import mk.borjankorunoski.library.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthorServiceImpl implements AuthorService {
    @Autowired
    AuthorRepository authorRepository;
    @Autowired
    CountryRepository countryRepository;
    @Override
    public int addAuthor(Author author) {
        authorRepository.save(author);
        return 1;
    }

    @Override
    public int deleteAuthor(long authorId) {
        authorRepository.deleteById(authorId);
        return 1;
    }

    @Override
    public Author getAuthor(long authorId) {
        return authorRepository.findById(authorId).orElse(new Author());
    }

    @Override
    public List<Author> getAllAuthors() {
        return authorRepository.findAll();
    }

    @Override
    public List<Author> getAllAuthorsByCountry(String countryName) {
        return authorRepository.findAuthorsByCountry(countryRepository.findCountryByName(countryName).orElse(new Country()));
    }
}
