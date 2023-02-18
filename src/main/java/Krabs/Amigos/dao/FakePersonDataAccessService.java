package Krabs.Amigos.dao;

import Krabs.Amigos.model.Person;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Repository("fakeDao") // arba @Component
public class FakePersonDataAccessService implements PersonDao {
    private static List<Person> DB = new ArrayList<>(); // sukurta database

    @Override
    public int insertPerson(UUID id, Person person) {
        DB.add(new Person(id,person.getName()));
        return 1;
    }
}
