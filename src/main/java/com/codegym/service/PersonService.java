package com.codegym.service;

import com.codegym.model.Person;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface PersonService {
    Iterable<Person> findAll();

    Page<Person> findAll(Pageable pageable);

    List<Person> search(String keyword);

    Page<Person> search(String keyword, Pageable pageable);

    Person findOne(Long id);

    Person save(Person person);

    List<Person> save(List<Person> personList);

    boolean exists(Long id);

    List<Person> findAll(List<Long> ids);

    Long count();

    void delete(Long id);

    void delete(Person person);

    void deleteAll();

}
