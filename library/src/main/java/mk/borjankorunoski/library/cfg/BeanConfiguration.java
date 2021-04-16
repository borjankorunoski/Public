package mk.borjankorunoski.library.cfg;

import mk.borjankorunoski.library.model.Author;
import mk.borjankorunoski.library.model.Book;
import mk.borjankorunoski.library.model.Country;
import mk.borjankorunoski.library.model.User;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.context.annotation.ApplicationScope;

@Configuration
public class BeanConfiguration {
    @Bean
    @ApplicationScope
    public User user(){
        return new User();
    }
    @Bean
    @ApplicationScope
    public Book book(){
        return new Book();
    }
    @Bean
    @ApplicationScope
    public Author author(){
        return new Author();
    }
    @Bean
    @ApplicationScope
    public Country country(){
        return new Country();
    }
}
