package com.codegym.repository;

import com.codegym.model.Person;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface PersonRepository extends PagingAndSortingRepository<Person, Long> {

    Page<Person> findAllByFirstNameContainsOrLastNameContains(String firstName, String lastName, Pageable pageable);
}
