package com.example.testspring.dao;

import com.example.testspring.model.Person;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository("fakeDao")
public class FakePersonDataAccessService implements  PersonDAO{
    private static List<Person> DB=new ArrayList<>();
    @Override
    public int insertPerson(UUID id, Person person) {
        DB.add(new Person(id,person.getName()));
        return 0;
    }

    @Override
    public List<Person> SelectAllpeople() {
        return DB;
    }
    @Override
    public Optional<Person> selectPersonById(UUID id) {
        //stream Elle permet d'effectuer les opérations sur une séquence sans utiliser de structure de boucle
        return DB.stream().filter(person->person.getId().equals(id)).findFirst();
    }

    @Override
    public int deletepersonbyId(UUID id) {
        Optional<Person> personmaybe=selectPersonById(id);
        if(personmaybe.isEmpty()){
            return 0;
        }

        DB.remove(personmaybe.get());
        return 1;
    }

    @Override
    public int updatePersonById(UUID id) {
        return 0;
    }

    @Override
    public int updatePersonById(UUID id,Person person) {

        return selectPersonById(id).map(p->{
                    int indexofpersonToDelete=DB.indexOf(p);
                    System.out.println("rrrrrrrr"+indexofpersonToDelete);

                    if (indexofpersonToDelete>=0){
                        DB.set(indexofpersonToDelete,new Person(id,person.getName()));
                        return 1;
                    }
                    return 0;

                }

        ).orElse(0);
    }




}
