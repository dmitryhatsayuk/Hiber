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
@Data
@Repository
public class Persons {

    public void setCity_of_living(String city_of_living) {
        this.city_of_living = city_of_living;
    }

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

    private String phone_number;
    private String city_of_living;
    @EmbeddedId
    private Person person;

    public String getCity_of_living() {
        return city_of_living;
    }
}
