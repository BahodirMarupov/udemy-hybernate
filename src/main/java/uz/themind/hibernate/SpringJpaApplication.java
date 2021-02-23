package uz.themind.hibernate;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import uz.themind.hibernate.domain.Person;
import uz.themind.hibernate.jdbc.PersonJdbcDao;
import uz.themind.hibernate.repository.PersonRepository;

import java.util.Date;

@SpringBootApplication
public class SpringJpaApplication implements CommandLineRunner {

    private final PersonRepository personRepository;

    private final Logger logger = LoggerFactory.getLogger(SpringJpaApplication.class);

    public SpringJpaApplication(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    public static void main(String[] args) {
        SpringApplication.run(SpringJpaApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        logger.info("{} rows of users are inserted", personRepository.insert(new Person(3, "Alii", "nnn", new Date())));
        logger.info("{} rows of users are updated", personRepository.updateUser(new Person(3, "Ganii", "mmmmm", new Date())));
        logger.info("All users: {}", personRepository.findAll());
        logger.info("User : {}", personRepository.findById(3));
        logger.info("{} rows of users are deleted", personRepository.deleteById(3));
    }
}
