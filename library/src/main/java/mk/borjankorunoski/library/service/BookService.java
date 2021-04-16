package mk.borjankorunoski.library.service;

import mk.borjankorunoski.library.model.Book;

import java.util.List;

public interface BookService {
    Book getBook(long bookId);
    List<Book> getAllBooks();
    int deleteBook(long bookId);
    int addBook(Book book);
}
