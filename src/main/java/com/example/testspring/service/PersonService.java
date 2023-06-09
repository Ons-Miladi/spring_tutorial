package com.example.testspring.service;

import com.example.testspring.dao.PersonDAO;
import com.example.testspring.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.OptionalInt;
import java.util.UUID;

@Service
public class PersonService {
    private  final PersonDAO personDAO;
    @Autowired//because we inject dao
    public PersonService (@Qualifier("sqlserver") PersonDAO personDAO){
        this.personDAO=personDAO;
    }
    public int addPerson(Person person){
        return personDAO.insertPerson(person);
    }
    public List<Person> getAllPeople(){
        return personDAO.SelectAllpeople();
    }
    public Optional<Person> getPersonById(UUID id){
        return  personDAO.selectPersonById(id);
    }
    public int updatePerson(UUID id,Person person){
        return personDAO.updatePersonById(id,person);
    }
}
