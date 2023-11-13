package com.example.test_java.controlller;

import com.example.test_java.model.Person;
import com.example.test_java.model.dto.PersonDTO;
import com.example.test_java.service.PersonService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RestController
@RequestMapping("/api/v1/demo")
public class DemoController {

    @GetMapping("/get")
    public ResponseEntity<String> get() {
        return ResponseEntity.ok().body("this.personService.save(personDTO)");
    }
}
