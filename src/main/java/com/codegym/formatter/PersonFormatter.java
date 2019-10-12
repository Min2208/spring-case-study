package com.codegym.formatter;

import com.codegym.model.Person;
import com.codegym.service.PersonService;
import org.springframework.format.Formatter;

import java.text.ParseException;
import java.util.Locale;

public class PersonFormatter implements Formatter {
    private PersonService personService;

    public PersonFormatter(PersonService personService) {
        this.personService = personService;
    }

    @Override
    public Person parse(String text, Locale locale) throws ParseException {
        return personService.findOne(Long.parseLong(text));
    }

    @Override
    public String print(Object object, Locale locale) {
        return null;
    }
}
