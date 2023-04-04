//package Krabs.Amigos;
//
//import Krabs.Amigos.dao.FakePersonDataAccessService;
//import Krabs.Amigos.dao.PersonDao;
//import Krabs.Amigos.model.Person;
//import Krabs.Amigos.service.PersonService;
//import org.junit.Before;
//import org.junit.jupiter.api.Test;
//
//import java.util.Optional;
//import java.util.UUID;
//
//import static org.junit.jupiter.api.Assertions.assertEquals;
//import static org.junit.jupiter.api.Assertions.assertTrue;
//
//public class PersonServiceTestGet {
//
//    private PersonService personService = new PersonService(new FakePersonDataAccessService());
//
//
//    @Test
//    public void testAddPerson() {
//        UUID personID = UUID.randomUUID();
//        Person person = new Person(personID, "Lil Jon", "Mog");
//        //assertTrue(personService.addPerson(person));
//    }
//
//    @Test
//    public void testDeletePerson() {
//        Person person = new Person("Jane", "Doe");
//        personService.addPerson(person);
//        assertTrue(personService.deletePerson(person.getId()));
//    }
//
//    @Test
//    public void testUpdatePerson() {
//        Person person = new Person("Bob", "Smith");
//        personService.addPerson(person);
//        person.setLastName("Jones");
//        assertTrue(personService.updatePerson(person));
//    }
//
//}
//
//
//
//
//
////public class PersonServiceTestGet {
////
////    private PersonDao personDao;
////    private PersonService personService;
////
////    @Before
////    public void setUp() {
////        personDao = new FakePersonDataAccessService();
////        personService = new PersonService(personDao);
////    }
////
////    @Test
////    public void testGetPersonById() {
////        // Create a Person object and insert it into the data store
////        UUID personID = UUID.randomUUID();
////        Person person = new Person(personID, "Alice Cooper", "Murrica");
////        personDao.insertPerson(person);
////
////        // Retrieve the person by ID
////        Optional<Person> result = personService.getPersonById(personID);
////
////        // Verify that the correct person is returned
////        assertEquals("Alice Cooper", result.get().getName());
////    }
////
////
////
////
////}
//
