package com.tests.backend_app.Service;

import java.util.List;

import com.tests.backend_app.Model.Person;

public interface IPersonService {
    Person save(Person person);

    List<Person> findAll();

    Person findById(String identification);

    Person deleteById(String identification);
}
