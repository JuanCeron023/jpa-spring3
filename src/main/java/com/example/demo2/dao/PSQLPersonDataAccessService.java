package com.example.demo2.dao;

import com.example.demo2.model.Person;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository("postgres")//referred to in PersonService
    public class PSQLPersonDataAccessService implements PersonDao{


        @Override
        public int insertPerson(UUID id, Person person) {
            return 0;
        }



    @Override
        public List<Person> selectAllPeople() {
            List<Person> e = new ArrayList<>();
         e.add(new Person(UUID.randomUUID(), "From Postgres db"));
        return e;
        }

        @Override
        public Optional<Person> selectPersonById(UUID id) {
            return Optional.empty();
        }

        @Override
        public int deletePersonById(UUID id) {
            return 0;
        }

        @Override
        public int updatePersonById(UUID id, Person person) {
            return 0;
        }
    }
