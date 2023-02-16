package com.rps.rps.repository;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import lombok.RequiredArgsConstructor;
import org.bson.Document;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class DBConfig {

    public MongoCollection<Document> getDB(String collection){
        MongoClient mongoClient = MongoClients.create("mongodb://" + "host.docker.internal" + ":27017");

        MongoDatabase DB = mongoClient.getDatabase("test");
        return DB.getCollection(collection);
    }
}
