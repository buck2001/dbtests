package com.example.demo.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Person;
import com.example.demo.constants.AppConstants;
import com.example.demo.services.PersonService;

@CrossOrigin
@RestController
@RequestMapping(AppConstants.PERSON_API)
public class PersonController {

	@Autowired
	private PersonService personService;

	@RequestMapping(value = AppConstants.PERSON_API_PEOPLE, method = RequestMethod.GET)
	public List<Person> getPeople() {
		List<Person> persons = new ArrayList<Person>();

		try {
			persons = personService.getPeople();
		} catch (Exception e) {
			System.out.println(e);
		}

		return persons;
	}

	@RequestMapping(value = AppConstants.PERSON_API_PEOPLE, method = RequestMethod.POST)
	public Person addPerson(@RequestBody Person person) {
		try {
			person = personService.addPerson(person);
		} catch (Exception e) {
			System.out.println(e);
		}

		return person;
	}

	@RequestMapping(value = AppConstants.PERSON_API_FIND_PERSON, method = RequestMethod.GET)
	public Person findPerson(@PathVariable(AppConstants.PERSON_ID) String id) {
		Person person = new Person();

		try {
			person = personService.findPerson(id);
		} catch (Exception e) {
			System.out.println(e);
		}

		return person;
	}

	@RequestMapping(value = AppConstants.PERSON_API_UPDATE_DELETE_PERSON, method = RequestMethod.DELETE)
	public Person deletePerson(@PathVariable(AppConstants.PERSON_ID) String id) {
		Person person = new Person();

		try {
			person = personService.deletePersonById(id);
		} catch (Exception e) {
			System.out.println(e);
		}

		return person;
	}

	@RequestMapping(value = AppConstants.PERSON_API_UPDATE_DELETE_PERSON, method = RequestMethod.PATCH)
	public Person updatePerson(@RequestBody Person person, @PathVariable(AppConstants.PERSON_ID) String id) {
		try {
			person = personService.updatePersonById(id, person);
		} catch (Exception e) {
			System.out.println(e);
		}

		return person;
	}
}
