package com.tests.backend_app.Controller;

import org.springframework.web.bind.annotation.RestController;

import com.tests.backend_app.Model.Person;
import com.tests.backend_app.Repository.personRepository;
import com.tests.backend_app.Service.IPersonService;

import lombok.AllArgsConstructor;
import lombok.extern.java.Log;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;

@CrossOrigin
@Log
@AllArgsConstructor
@RequestMapping("/api/people")
@RestController
public class PersonController {

    @Autowired
    private IPersonService personService;

    @Autowired
    private personRepository personRepository;

     @GetMapping("/list")
    public List<Person> getAllPople() {
        return personService.findAll();
    }

    @GetMapping("/list/{id}")
    public Person getPerson(@PathVariable("id") String identification) {
        return personService.findById(identification);
    }

    @PostMapping("/add")
    public Person addPerson(@RequestBody Person person) {
        log.info("Añadiendo una nueva persona:" + person.getEmail());
        return personService.save(person);
    }

    
    @PutMapping("/{id}")
    public ResponseEntity<Object> updatePerson(@PathVariable("id") String identification,
            @RequestBody Person updatedPerson) {
        Person existPerson = personRepository.findByIde(identification);
        if (existPerson != null) {
            org.springframework.beans.BeanUtils.copyProperties(updatedPerson, existPerson);
            Person updatedPersoE = personService.save(existPerson);
            return new ResponseEntity<>(updatedPersoE, HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Persona no encontrada con identificación: " + identification,
                    HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deletePerson(@PathVariable("id") String identification) {
        Person existPerson = personRepository.findByIde(identification);
        if (existPerson != null) {
            Person deletePersoE = personService.deleteById(identification);
            return new ResponseEntity<>(deletePersoE, HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Persona no encontrada con identificación: " + identification,
                    HttpStatus.NOT_FOUND);
        }
    }

}