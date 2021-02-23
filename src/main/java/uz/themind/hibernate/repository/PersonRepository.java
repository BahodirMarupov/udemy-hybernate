package uz.themind.hibernate.repository;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import uz.themind.hibernate.domain.Person;

import javax.persistence.EntityManager;

@Repository
@Transactional
public class PersonRepository {

    private final EntityManager entityManager;

    public PersonRepository(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public Person findById(Integer id) {
        return entityManager.find(Person.class, id);
    }
}
