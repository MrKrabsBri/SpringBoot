package Krabs.Amigos.service;

import Krabs.Amigos.dao.PersonDao;
import Krabs.Amigos.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Service // arba @Component
public class PersonService {
    private final PersonDao personDao;

    @Autowired // injecting into constructor
    public PersonService(@Qualifier("fakeDao") PersonDao personDao) {
        this.personDao = personDao;
    }

   @PostMapping// kai nebuvo irgi veike
    public int addPerson(Person person) {
        return personDao.insertPerson(person);
    }

    @GetMapping
    public List<Person> getAllPeople() {
        return personDao.selectAllPeople();
    }
}
