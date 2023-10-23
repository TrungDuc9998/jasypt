package com.example.test_java.service.mapper;

import com.example.test_java.model.Person;
import com.example.test_java.model.dto.PersonDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PersonMapper {
    PersonDTO toDto(Person person);

    Person toEntity(PersonDTO personDTO);
}
