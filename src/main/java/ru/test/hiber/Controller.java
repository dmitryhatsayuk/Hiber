package ru.test.hiber;

import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@Transactional
@RestController
public class Controller {
    private final CustomizedCrudPersonsRepo customizedCrudPersonsRepo;

    public Controller(CustomizedCrudPersonsRepo personsRepository, CustomizedCrudPersonsRepo customizedCrudPersonsRepo) {
        this.personsRepository = personsRepository;
        this.customizedCrudPersonsRepo = customizedCrudPersonsRepo;
    }

    CustomizedCrudPersonsRepo personsRepository;

    @GetMapping(value = "/persons/by-city")
    public ResponseEntity<?> byCity(@RequestParam String city) {
        List<Persons> result;
        result = personsRepository.findByCity(city);
        if (result.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);

        }
        return new ResponseEntity<>(result, HttpStatus.OK);

    }

    @GetMapping(value = "/persons/by-age")
    public ResponseEntity<?> byAge(@RequestParam Integer age) {
        List<Persons> result = customizedCrudPersonsRepo.findByAgeAndSort(age, Sort.by("person.age"));
        if (result.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);

        }
        return new ResponseEntity<>(result, HttpStatus.OK);

    }

    @GetMapping(value = "/persons/by-namesurname")
    public ResponseEntity<?> byNameSurname(@RequestParam String name, @RequestParam String surname) {
        Optional<Persons> result = customizedCrudPersonsRepo.findByNameAndSurname(name, surname);
        if (result.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);

        }
        return new ResponseEntity<>(result, HttpStatus.OK);

    }

}
