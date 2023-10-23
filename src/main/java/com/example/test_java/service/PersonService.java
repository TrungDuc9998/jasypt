package com.example.test_java.service;

import com.example.test_java.model.Person;
import com.example.test_java.model.dto.PersonDTO;

public interface PersonService {
    Person save(PersonDTO personDTO);

    PersonDTO get(long id);
}
