package ru.test.hiber;

import jakarta.persistence.Embeddable;
import lombok.*;

import java.io.Serializable;


@Setter
@Getter
@Builder
@Embeddable
@AllArgsConstructor
@NoArgsConstructor
public class Person implements Serializable {
    private String name;
    private String surname;
    private int age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }


}
