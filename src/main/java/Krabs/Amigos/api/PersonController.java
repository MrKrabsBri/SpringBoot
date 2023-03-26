package Krabs.Amigos.api;

import Krabs.Amigos.model.Person;
import Krabs.Amigos.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//@RequestMapping("api/v1/person")  //http://localhost:8080/Krabs/Amigos/v1/person

/**
 * Routes & handles requests hitting localhost:8080/api/v1/person to this class
 **/
@RequestMapping("/api/v1/person")
@RestController
public class PersonController {

    private final PersonService personService;

    @Autowired
    public PersonController(PersonService personService) {
        this.personService = personService;
    }

@PostMapping
    public void addPerson(@RequestBody Person person){
        personService.addPerson(person);
    }

    @GetMapping
    public List<Person> getAllPeople(){
        return personService.getAllPeople();
    }

}
