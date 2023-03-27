package Krabs.Amigos.dao;

import Krabs.Amigos.model.Person;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository("fakeDao") // arba @Component
public class FakePersonDataAccessService implements PersonDao {
    private static List<Person> DB = new ArrayList<>(); // sukurta database

    @Override
    public int insertPerson(UUID id, Person person) {
        DB.add(new Person(id,person.getName(),person.getAddress()));
        return 1;
    }

    @Override
    public List<Person> selectAllPeople() {
        return DB;
    }

    @Override
    public Optional<Person> selectPersonById(UUID id) {
        return DB.stream()
                .filter(person -> person.getId().equals(id) )
                .findFirst();

    }

    @Override
    public int deletePersonById(UUID id) {
        return 0;
    }

    @Override
    public int updatePersonById(UUID id, Person person) {
        return 0;
    }
}
