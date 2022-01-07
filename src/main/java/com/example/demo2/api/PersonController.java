package com.example.demo2.api;

import com.example.demo2.model.Person;
import com.example.demo2.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.UUID;


@RequestMapping("api/v1/person")
@RestController
public class PersonController {

    private final PersonService personService;


    //autowired va aqui porque se requiere un objet deñ apramertro que
    //defini anres
    @Autowired
    public PersonController(PersonService personService) {
        this.personService = personService;
    }
    @PostMapping
    public void addPerson(@Valid @NonNull @RequestBody Person person){
        personService.addPerson(person);
    }

    @GetMapping
    public List<Person> getAllPeople(){
        return personService.getAllPeople();
    }

    @GetMapping(path = "{id}")
    public Person getPersonById(@PathVariable("id") UUID id){
        return personService.getPersonById(id)
                .orElse(null);
    }

    @DeleteMapping(path = "{id}")
    public ResponseEntity deletePersonById(@PathVariable("id")UUID id){
        int codigo=personService.deletePerson(id);
        return codigo==0  ? new ResponseEntity(HttpStatus.BAD_REQUEST) : new ResponseEntity(HttpStatus.OK);
    }

    @PutMapping(path = "{id}")
    public ResponseEntity updatePerson(@PathVariable("id") UUID id, @Valid @NonNull @RequestBody Person person){
        int codigo=personService.updatePerson(id, person);
        return codigo==0  ? new ResponseEntity(HttpStatus.BAD_REQUEST) : new ResponseEntity(HttpStatus.OK);
    }
}
