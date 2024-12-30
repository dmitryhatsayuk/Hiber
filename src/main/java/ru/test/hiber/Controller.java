package ru.test.hiber;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@Transactional
@RestController
public class Controller {
    @PersistenceContext
    private EntityManager em;


    @GetMapping(value = "/persons/by-city")
    public ResponseEntity<?> byCity(@RequestParam String city) {

        List<Persons> personsList = em.createQuery("select p from Persons p", Persons.class).getResultList();
        ArrayList<Persons> result = new ArrayList<>();
        for (Persons persons : personsList) {
            if (persons.getCity_of_living().equals(city)) {
                result.add(persons);
            }
        }
        if (result.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);

        }
        return new ResponseEntity<>(result, HttpStatus.OK);


    }
}
