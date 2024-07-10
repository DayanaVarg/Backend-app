package com.tests.backend_app.Repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import com.tests.backend_app.Model.Person;

public interface personRepository extends CrudRepository<Person, String> {

    @Query("SELECT p FROM Person p WHERE p.identification = :identification")
    Person findByIde(@Param("identification") String identification);
}
