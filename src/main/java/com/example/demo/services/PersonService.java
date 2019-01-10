package com.example.demo.services;

import java.util.ArrayList;
import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.stereotype.Service;

import com.example.demo.Person;
import com.example.demo.constants.AppConstants;
import com.example.demo.dao.MongoDBAccess;
import com.mongodb.Block;
import com.mongodb.MongoException;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import com.mongodb.client.model.Updates;
import com.mongodb.client.result.DeleteResult;
import com.mongodb.client.result.UpdateResult;

@Service
public class PersonService {
	public PersonService() {
	}

	public List<Person> getPeople() {
		List<Person> people = new ArrayList<Person>();

		try { // get connection to local mongo DB server and our database
			MongoCollection<Person> collection = getCollection(AppConstants.TABLE_PERSON, Person.class);
			collection.find().forEach((Block<? super Person>) (Person person) -> {
				person.setStringId(person.getId().toHexString());
				person.setId(null);
				people.add(person);
			});
		} catch (Exception e) {
			System.out.println(e);
		}

		return people;
	}

	public Person addPerson(Person person) {
		try {
			person.setId(ObjectId.get());
			MongoCollection<Person> collection = getCollection(AppConstants.TABLE_PERSON, Person.class);
			collection.insertOne(person);

			person.setStringId(person.getId().toHexString());
			person.setId(null);
		} catch (MongoException e) {
			if (e.getCode() == AppConstants.INSERT_FAILED) {
				return person;
			}
		} catch (Exception e) {
			System.out.println(e);
		}

		return person;
	}

	public Person findPerson(String id) {
		Person person = new Person();

		try {
			MongoCollection<Person> collection = getCollection(AppConstants.TABLE_PERSON, Person.class);
			person = collection.find(Filters.eq(AppConstants.PERSON_OBJECT_ID, new ObjectId(id))).first();

			if (person != null) {
				person.setId(null);
				person.setStringId(id);
			}
		} catch (MongoException e) {
			if (e.getCode() == AppConstants.RECORD_DOESNT_EXIST) {
				return person;
			}
		} catch (Exception e) {
			System.out.println(e);
		}

		return person;
	}

	public Person updatePersonById(String id, Person person) {
		try {
			MongoCollection<Person> collection = getCollection(AppConstants.TABLE_PERSON, Person.class);
			UpdateResult updateResult = collection.updateOne(
					(Filters.eq(AppConstants.PERSON_OBJECT_ID, new ObjectId(id))),
					Updates.combine(Updates.set(AppConstants.PERSON_FIRST_NAME, person.getFirstName()),
							Updates.set(AppConstants.PERSON_LAST_NAME, person.getLastName())));

			if (updateResult.getModifiedCount() != 1) {
				person.setFirstName(AppConstants.NOT + AppConstants.UPDATED);
			}
		} catch (MongoException e) {
			if (e.getCode() == AppConstants.RECORD_EXISTS) {
				return person;
			}
		} catch (Exception e) {
			System.out.println(e);
		}

		return person;
	}

	public Person deletePersonById(String id) {
		Person person = findPerson(id);

		try {
			MongoCollection<Person> collection = getCollection(AppConstants.TABLE_PERSON, Person.class);
			DeleteResult deleteResult = collection
					.deleteOne(Filters.eq(AppConstants.PERSON_OBJECT_ID, new ObjectId(id)));

			if (deleteResult.getDeletedCount() != 1) {
				person = null;
			}
		} catch (MongoException e) {
			if (e.getCode() == AppConstants.RECORD_EXISTS) {
				return person;
			}
		} catch (Exception e) {
			System.out.println(e);
		}

		return person;
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	private MongoCollection<Person> getCollection(String tableName, Class tableObjectClass) {
		MongoDatabase mongoDatabase = MongoDBAccess.getDatabase();
		MongoCollection<Person> collection = mongoDatabase.getCollection(tableName, tableObjectClass)
				.withCodecRegistry(MongoDBAccess.pojoCodecRegistry);

		return (collection);
	}
}
