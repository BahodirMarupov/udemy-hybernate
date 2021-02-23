package uz.themind.hibernate.jdbc;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import uz.themind.hibernate.domain.Person;

import java.util.List;

@Repository
public class PersonJdbcDao {

    private final JdbcTemplate jdbcTemplate;

    public PersonJdbcDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    // select * from person
    public List<Person> findAll() {
        return jdbcTemplate.query("select * from person", new PersonRowMapper());
    }

    public Person findById(Integer id) {
        return jdbcTemplate.queryForObject("select * from person where id=?",
                new Object[]{id},
                new BeanPropertyRowMapper<>(Person.class));
    }

    public Integer deleteById(Integer id) {
        return jdbcTemplate.update("delete from person where id=?", id);
    }

    public Integer insert(Person person) {
        return jdbcTemplate.update("insert into person(id,name,location,birth_date)" +
                        "values (?,?,?,?)",
                person.getId(), person.getName(), person.getLocation(), person.getBirthDate());
    }

    public Integer updateUser(Person person) {
        return jdbcTemplate.update("update person set " +
                "name=?, location=?, birth_date=?" +
                "where id=?", person.getName(), person.getLocation(), person.getBirthDate(), person.getId());
    }
}
