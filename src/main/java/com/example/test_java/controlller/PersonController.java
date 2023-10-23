package com.example.test_java.controlller;

import com.example.test_java.model.Person;
import com.example.test_java.model.dto.PersonDTO;
import com.example.test_java.service.PersonService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RestController
@RequestMapping("/person")
public class PersonController {
    private final PersonService personService;

    @PostMapping("/save")
    public ResponseEntity<Person> save(@RequestBody PersonDTO personDTO) {
        return ResponseEntity.ok().body(this.personService.save(personDTO));
    }

    @PostMapping("/get")
    public ResponseEntity<PersonDTO> get(@RequestBody PersonDTO personDTO) {
        return ResponseEntity.ok().body(this.personService.get(personDTO.getId()));
    }
}
