package Krabs.Amigos.api;

import Krabs.Amigos.model.Person;
import Krabs.Amigos.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//@RequestMapping("api/v1/person")  //http://localhost:8080/Krabs/Amigos/v1/person
@RestController
public class PersonController {

    private final PersonService personService;

    @Autowired
    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    public void addPerson(@RequestBody Person person){
        personService.addPerson(person);
    }

}
