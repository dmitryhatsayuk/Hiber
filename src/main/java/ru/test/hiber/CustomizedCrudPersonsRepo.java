package ru.test.hiber;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CustomizedCrudPersonsRepo extends CrudRepository<Persons, Long> {
    List<Persons> findByCity(String city);

    @Query("select p from Persons p where p.person.age < :age")
    List<Persons> findByAgeAndSort(Integer age, Sort sort);

    @Query("select p from Persons p where p.person.name =:name and p.person.surname =:surname")
    Optional<Persons> findByNameAndSurname(String name, String surname);
}
