package com.dkorolev.edu.spring.spring01.dao;

import com.dkorolev.edu.spring.spring01.domain.Person;

public class PersonDaoImpl implements PersonDao {

    private int defaultAge = 29;
    
    public Person findByName(String name) {
	return new Person("ivanN", defaultAge);
    }

    public void setDefaultAge(int defaultAge) {
        this.defaultAge = defaultAge;
    }
}
