package com.example.testspring.api;

import com.example.testspring.model.Person;
import com.example.testspring.service.PersonService;

import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.rmi.server.UID;
import java.util.List;
import java.util.UUID;

@RequestMapping("api/v1/person")
@RestController
public class PersonController {
    private final PersonService personService;
    @Autowired
    public PersonController(PersonService personService) {
        this.personService = personService;
    }
    @PostMapping
    public void addPerson( @NonNull @RequestBody  Person person){
        personService.addPerson(person);

    }
    @GetMapping
    public List<Person> getAllpeople(){
        return personService.getAllPeople();
    }
    @GetMapping(path="{id}")
    public Person GetPersonbyId(@PathVariable("id") UUID id){
        return personService.getPersonById(id).orElse(null);
    }
    @PutMapping(path="{id}")
    public void updatePerson(@PathVariable("id") UUID id, @NonNull  @RequestBody Person personToUpdate){
        personService.updatePerson(id,personToUpdate);
    }
}
