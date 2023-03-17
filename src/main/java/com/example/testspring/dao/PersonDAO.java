package com.example.testspring.dao;

import com.example.testspring.model.Person;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface PersonDAO {
    int insertPerson(UUID id, Person person);
    default int insertPerson(Person person){
        UUID id=UUID.randomUUID();
        return insertPerson(id,person);
    }
    List<Person> SelectAllpeople();
    int deletepersonbyId(UUID id);
    int updatePersonById(UUID id);
    Optional<Person> selectPersonById(UUID id);
    int updatePersonById(UUID id,Person person);
}
