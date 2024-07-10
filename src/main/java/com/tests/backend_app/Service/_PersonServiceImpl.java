package com.tests.backend_app.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tests.backend_app.Model.Person;
import com.tests.backend_app.Repository.personRepository;

import lombok.AllArgsConstructor;


@AllArgsConstructor
@Service
public class _PersonServiceImpl implements IPersonService {

  @Autowired
  private personRepository personRepository;

  @Override
  public Person save(Person person) {
    return personRepository.save(person);
  }

  @Override
  public List<Person> findAll() {
    return (List<Person>) personRepository.findAll();
  }

  @Override
  public Person findById(String identification) {
    return personRepository.findByIde(identification);
  }

  public Person deleteById(String identification) {
    personRepository.deleteById(identification);
    return personRepository.findByIde(identification);
  }

}
