package com.example.test_java.repository;

import com.example.test_java.model.Person;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonRepository extends JpaRepository<Person, Long> {
    @Cacheable(value = "person", key = "#id", unless = "#result == null")
    Person getById(long id);

    @CachePut(value = "person", key = "#id", unless = "#result == null")
    default Person put(long id, Person person) {
        return this.save(person);
    }
}
