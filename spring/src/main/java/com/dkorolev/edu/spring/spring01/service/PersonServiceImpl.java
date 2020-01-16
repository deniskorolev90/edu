package com.dkorolev.edu.spring.spring01.service;

import com.dkorolev.edu.spring.spring01.dao.PersonDao;
import com.dkorolev.edu.spring.spring01.domain.Person;

public class PersonServiceImpl implements PersonService{

    private PersonDao personDao;
    
//    public PersonServiceImpl(PersonDao personDao) {
//	this.personDao = personDao;
//    }
    
    public Person getByName(String name) {
	return personDao.findByName(name);
    }

    public void setPersonDao(PersonDao personDao) {
        this.personDao = personDao;
    }

}
