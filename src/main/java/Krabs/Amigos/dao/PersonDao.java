package Krabs.Amigos.dao;

// operations that are allowed are in here

import Krabs.Amigos.model.Person;

import java.util.UUID;

public interface PersonDao { // DAO - data access object

    int insertPerson(UUID id, Person person);

    default int insertPerson(Person person){
        UUID id = UUID.randomUUID();
        return insertPerson(id, person);
    }
}
