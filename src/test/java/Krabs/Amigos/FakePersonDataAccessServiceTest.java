package Krabs.Amigos;

import Krabs.Amigos.dao.FakePersonDataAccessService;
import Krabs.Amigos.model.Person;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public class FakePersonDataAccessServiceTest {
    private FakePersonDataAccessService service;

    @BeforeEach
    public void setUp() {
        service = new FakePersonDataAccessService();
    }

    @Test
    public void testInsertPerson() {
        UUID id = UUID.randomUUID();
        Person person = new Person(id, "John", "123 Main St");

        int result = service.insertPerson(id, person);

        assertEquals(1, result);
        assertEquals(1, service.selectAllPeople().size());
        assertEquals(person, service.selectPersonById(id).get());
    }

    @Test
    public void testSelectAllPeople() {
        List<Person> expected = new ArrayList<>();
        expected.add(new Person(UUID.randomUUID(), "John", "123 Main St"));
        expected.add(new Person(UUID.randomUUID(), "Jane", "456 Oak Ave"));
        expected.add(new Person(UUID.randomUUID(), "Bob", "789 Maple Rd"));

        for (Person person : expected) {
            service.insertPerson(person.getId(), person);
        }

        List<Person> actual = service.selectAllPeople();

        assertEquals(expected.size(), actual.size());
        assertTrue(actual.containsAll(expected));
    }

    @Test
    public void testSelectPersonById() {
        UUID id1 = UUID.randomUUID();
        UUID id2 = UUID.randomUUID();
        Person person1 = new Person(id1, "John", "123 Main St");
        Person person2 = new Person(id2, "Jane", "456 Oak Ave");

        service.insertPerson(id1, person1);
        service.insertPerson(id2, person2);

        Optional<Person> result1 = service.selectPersonById(id1);
        Optional<Person> result2 = service.selectPersonById(id2);
        Optional<Person> result3 = service.selectPersonById(UUID.randomUUID());

        assertTrue(result1.isPresent());
        assertTrue(result2.isPresent());
        assertFalse(result3.isPresent());
        assertEquals(person1, result1.get());
        assertEquals(person2, result2.get());
    }

    @Test
    public void testDeletePersonById() {
        UUID id1 = UUID.randomUUID();
        UUID id2 = UUID.randomUUID();
        Person person1 = new Person(id1, "John", "123 Main St");
        Person person2 = new Person(id2, "Jane", "456 Oak Ave");

        service.insertPerson(id1, person1);
        service.insertPerson(id2, person2);

        int result1 = service.deletePersonById(id1);
        int result2 = service.deletePersonById(id2);
        int result3 = service.deletePersonById(UUID.randomUUID());

        assertEquals(1, result1);
        assertEquals(1, result2);
        assertEquals(0, result3);
        assertEquals(0, service.selectAllPeople().size());
        assertFalse(service.selectPersonById(id1).isPresent());
        assertFalse(service.selectPersonById(id2).isPresent());
    }

    @Test
    public void testUpdatePersonById() {
        UUID id = UUID.randomUUID();
        Person person = new Person(id, "John", "123 Main St");

        service.insertPerson(id, person);

        Person update = new Person(id, "Jane", "456 Oak Ave");

        int result1 = service.updatePersonById(id, update);
        int result2 = service.updatePersonById(UUID.randomUUID(), update);

        assertEquals(1, result1);
        assertEquals(0, result2);
        assertEquals(update, service.selectPersonById(id).get());
    }
}