package mk.borjankorunoski.library.service.impl;

import mk.borjankorunoski.library.model.Book;
import mk.borjankorunoski.library.repository.BookRepository;
import mk.borjankorunoski.library.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceImpl implements BookService {
    @Autowired
    BookRepository bookRepository;

    @Override
    public Book getBook(long bookId) {
        return bookRepository.findById(bookId).orElse(new Book());
    }

    @Override
    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    @Override
    public int deleteBook(long bookId) {
        bookRepository.deleteById(bookId);
        return 1;
    }

    @Override
    public int addBook(Book book) {
        bookRepository.save(book);
        return 1;
    }
}
