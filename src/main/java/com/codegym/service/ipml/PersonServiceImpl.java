package com.codegym.service.ipml;

import com.codegym.model.Person;
import com.codegym.repository.PersonRepository;
import com.codegym.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public class PersonServiceImpl implements PersonService {
    @Autowired
    private PersonRepository personRepository;

    @Override
    public Iterable<Person> findAll() {
        return personRepository.findAll();
    }

    @Override
    public Page<Person> findAll(Pageable pageable) {
        return personRepository.findAll(pageable);
    }

    @Override
    public List<Person> search(String keyword) {
        return null;
    }

    @Override
    public Page<Person> search(String keyword, Pageable pageable) {
        return personRepository.findAllByFirstNameContainsOrLastNameContains(keyword, keyword, pageable);
    }

    @Override
    public Person findOne(Long id) {
        return personRepository.findOne(id);
    }

    @Override
    public Person save(Person person) {
        return personRepository.save(person);
    }

    @Override
    public List<Person> save(List<Person> personList) {
        return (List<Person>) personRepository.save(personList);
    }

    @Override
    public boolean exists(Long id) {
        return false;
    }

    @Override
    public List<Person> findAll(List<Long> ids) {
        return (List<Person>) personRepository.findAll(ids);
    }

    @Override
    public Long count() {
        return personRepository.count();
    }

    @Override
    public void delete(Long id) {
        personRepository.delete(id);
    }

    @Override
    public void delete(Person person) {
        personRepository.delete(person);
    }

    @Override
    public void deleteAll() {
        personRepository.deleteAll();
    }
}
