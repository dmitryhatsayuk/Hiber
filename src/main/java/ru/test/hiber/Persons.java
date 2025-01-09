package ru.test.hiber;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import lombok.*;
import org.springframework.stereotype.Repository;


@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Repository
public class Persons {


    @EmbeddedId

    private Person person;
    private String phone_number;
    private String city;

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public String getPhone_number() {
        return phone_number;
    }

    public void setPhone_number(String phone_number) {
        this.phone_number = phone_number;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }


}
