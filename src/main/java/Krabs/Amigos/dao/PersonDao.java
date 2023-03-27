package Krabs.Amigos.dao;

// operations that are allowed are in here

import Krabs.Amigos.model.Person;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface PersonDao { // DAO - data access object

    int insertPerson(UUID id, Person person);

    default int insertPerson(Person person){
        UUID id = UUID.randomUUID();
        return insertPerson(id, person);
    }

    List<Person> selectAllPeople();

    Optional<Person> selectPersonById(UUID id);

    int deletePersonById(UUID id);
    int updatePersonById(UUID id, Person person);

}
