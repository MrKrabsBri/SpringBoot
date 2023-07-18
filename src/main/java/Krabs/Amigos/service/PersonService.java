package Krabs.Amigos.service;

import Krabs.Amigos.dao.PersonDao;
import Krabs.Amigos.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service // arba @Component
public class PersonService {
    private final PersonDao personDao;

    @Autowired // injecting into constructor
    public PersonService(@Qualifier("postgres") PersonDao personDao) {
        this.personDao = personDao;
    }

   @PostMapping// kai nebuvo irgi veike, CIA priskiria random ID personui. POST
    public int addPerson(Person person) {
        return personDao.insertPerson(person);
    }

    @GetMapping  // GET
    public List<Person> getAllPeople() {
        return personDao.selectAllPeople();
    }

    public Optional<Person> getPersonById(UUID id) {
        return personDao.selectPersonById(id);
    }

    public int deletePerson(UUID id){
        return personDao.deletePersonById(id);
    }

    public int updatePerson(UUID id, Person newPerson) {
        return personDao.updatePersonById(id, newPerson);
    }
}
