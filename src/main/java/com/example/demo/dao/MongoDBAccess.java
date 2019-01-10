package com.example.demo.dao;

import static org.bson.codecs.configuration.CodecRegistries.fromProviders;
import static org.bson.codecs.configuration.CodecRegistries.fromRegistries;

import org.bson.codecs.configuration.CodecRegistry;
import org.bson.codecs.pojo.PojoCodecProvider;

import com.example.demo.constants.AppConstants;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.client.MongoDatabase;

public class MongoDBAccess {
	private static MongoClientURI uri = new MongoClientURI(AppConstants.bob);
	private static MongoClient mongoClient = new MongoClient(uri);
	// "mongodb+srv://kay:myRealPassword@cluster0.mongodb.net/admin");
	// private static MongoClient mongoClient = new
	// MongoClient(AppConstants.MONGODB_URL, AppConstants.MONGODB_PORT);
	private static MongoDatabase mongoDatabase = mongoClient.getDatabase(AppConstants.DATABASE_NAME);
	public static CodecRegistry pojoCodecRegistry = fromRegistries(MongoClient.getDefaultCodecRegistry(),
			fromProviders(PojoCodecProvider.builder().automatic(true).build()));

	public MongoDBAccess() {
	}

	public static MongoClient getClient() {
		if (mongoClient != null) {
			return (mongoClient);
		} else {
			return (mongoClient);
		}
	}

	public static boolean closeClient() {
		if (mongoClient != null) {
			mongoClient.close();
			return (true);
		} else {
			return (false);
		}
	}

	public static MongoDatabase getDatabase() {
		if (mongoDatabase != null) {
			return getClient().getDatabase(AppConstants.DATABASE_NAME);
		} else {
			return (mongoDatabase);
		}
	}
}
