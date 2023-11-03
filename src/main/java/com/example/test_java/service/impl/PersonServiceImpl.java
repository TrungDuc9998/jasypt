package com.example.test_java.service.impl;

import com.example.test_java.model.Person;
import com.example.test_java.model.dto.PersonDTO;
import com.example.test_java.repository.PersonRepository;
import com.example.test_java.service.PersonService;
import com.example.test_java.service.mapper.PersonMapper;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Service
@Transactional
@RequiredArgsConstructor
public class PersonServiceImpl implements PersonService {

    private final PersonRepository personRepository;

    private final PersonMapper personMapper;

    @Override
    public Person save(PersonDTO personDTO) {
        Person person = this.personMapper.toEntity(personDTO);
        this.personRepository.save(person);
        return person;
    }

    @Override
    public PersonDTO get(long id) {
        String[] a = {"MER", "VENUSSS", "EARTH", "MARS"};
        System.out.println(a.length);
        System.out.println(a[1].length());
        return this.personMapper.toDto(this.personRepository.getById(id));
    }
}
