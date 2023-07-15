package com.StringCrud;

import com.StringCrud.models.Person;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class json {
    public static void main(String[] args) {
        ObjectMapper objectMapper = new ObjectMapper();
        Person person = new Person("Nikita", 27);
        String str = null;
        try {
            str = objectMapper.writeValueAsString(person);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
        System.out.println(str);
        Person newPerson;
        try {
            newPerson = objectMapper.readValue(str, Person.class);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
        System.out.println(newPerson);
    }
}
