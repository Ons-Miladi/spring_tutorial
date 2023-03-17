package com.example.testspring.dao;

import com.example.testspring.model.Person;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository("sqlserver")
public class PersonDataAccessService implements PersonDAO{
    @Override
    public int insertPerson(UUID id, Person person) {
        return 0;
    }

    @Override
    public List<Person> SelectAllpeople() {
        return List.of(new Person(UUID.randomUUID(),"FROM SQL SERVER"));
    }

    @Override
    public int deletepersonbyId(UUID id) {
        return 0;
    }

    @Override
    public int updatePersonById(UUID id) {
        return 0;
    }

    @Override
    public Optional<Person> selectPersonById(UUID id) {
        return Optional.empty();
    }

    @Override
    public int updatePersonById(UUID id, Person person) {
        return 0;
    }
}
