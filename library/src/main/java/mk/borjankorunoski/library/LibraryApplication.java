package mk.borjankorunoski.library;

import mk.borjankorunoski.library.cfg.BeanConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@SpringBootApplication
public class LibraryApplication {

    public static void main(String[] args) {
        SpringApplication.run(LibraryApplication.class, args);
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(BeanConfiguration.class);
    }

}
