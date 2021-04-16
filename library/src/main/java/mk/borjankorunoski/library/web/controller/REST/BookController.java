package mk.borjankorunoski.library.web.controller.REST;

import mk.borjankorunoski.library.model.Book;
import mk.borjankorunoski.library.service.AuthorService;
import mk.borjankorunoski.library.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.awt.*;
import java.util.List;

@RestController
@RequestMapping(value = "/book")
@CrossOrigin
public class BookController {
    @Autowired
    BookService bookService;
    @Autowired
    AuthorService authorService;

    @GetMapping(value = "/{id}", produces = "application/json")
    public Book getBook(@PathVariable long id){
        return bookService.getBook(id);
    }

    @GetMapping(value = "/all",  produces = "application/json")
    public List<Book> getAllBooks(){
        return bookService.getAllBooks();
    }

    @PostMapping(value = "/{authorId}" , consumes = "application/json", produces = "application/json")
    public int addBook(@RequestBody Book book, @PathVariable long authorId){
        book.setAuthor(authorService.getAuthor(authorId));
        return bookService.addBook(book);
    }

    @PatchMapping(value = "/edit/{bookId}", consumes = "application/json", produces = "application/json")
    public int editBook(@RequestBody Book neu, @PathVariable long bookId){
        Book old = bookService.getBook(bookId);
        if(neu.getName()!=null){
            old.setName(neu.getName());
        }
        if(neu.getCategory()!=null){
            old.setCategory(neu.getCategory());
        }
        if(neu.getAuthor()!=null){
            old.setAuthor(neu.getAuthor());
        }
        if(neu.getAvailableCopies()!=-1){
            old.setAvailableCopies(neu.getAvailableCopies());
        }
        return bookService.addBook(old);
    }

    @GetMapping(value = "/checkout/{bookId}", produces = "application/json")
    public int markAsTaken(@PathVariable long bookId){
        Book old = bookService.getBook(bookId);
        if(old.getAvailableCopies()>0){
            old.setAvailableCopies(old.getAvailableCopies()-1);
            bookService.addBook(old);
        }
        return old.getAvailableCopies();
    }

    @DeleteMapping(value = "/del/{bookId}")
    public int deleteBook(@PathVariable long bookId){
        return bookService.deleteBook(bookId);
    }
}
//todo: usercontroller