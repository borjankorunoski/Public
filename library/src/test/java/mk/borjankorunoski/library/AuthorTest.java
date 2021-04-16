package mk.borjankorunoski.library;

import mk.borjankorunoski.library.repository.AuthorRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class AuthorTest {
    @Autowired
    AuthorRepository authorRepository;

    @Test
    void testRepo(){
        Assertions.assertEquals(1L,authorRepository.findAll().size());
    }
}
