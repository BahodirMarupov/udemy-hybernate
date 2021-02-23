package uz.themind.hibernate;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import uz.themind.hibernate.domain.Person;
import uz.themind.hibernate.jdbc.PersonJdbcDao;

import java.util.Date;

//@SpringBootApplication
public class SpringJdbcApplication implements CommandLineRunner {

    private final PersonJdbcDao personJdbcDao;

    private final Logger logger = LoggerFactory.getLogger(SpringJdbcApplication.class);

    public SpringJdbcApplication(PersonJdbcDao personJdbcDao) {
        this.personJdbcDao = personJdbcDao;
    }

    public static void main(String[] args) {
        SpringApplication.run(SpringJdbcApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        logger.info("{} rows of users are inserted",personJdbcDao.insert(new Person(3,"Alii","nnn",new Date())));
        logger.info("{} rows of users are updated",personJdbcDao.updateUser(new Person(3,"Ganii","mmmmm",new Date())));
        logger.info("All users: {}", personJdbcDao.findAll());
        logger.info("User : {}", personJdbcDao.findById(3));
        logger.info("{} rows of users are deleted",personJdbcDao.deleteById(3));
    }
}
