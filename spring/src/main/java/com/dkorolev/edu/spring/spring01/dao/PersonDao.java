package com.dkorolev.edu.spring.spring01.dao;

import com.dkorolev.edu.spring.spring01.domain.Person;

public interface PersonDao {
    public Person findByName(String name);
}
