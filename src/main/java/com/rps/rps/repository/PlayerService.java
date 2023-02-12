package com.rps.rps.repository;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.result.InsertOneResult;
import com.rps.rps.models.PlayerModel;
import com.rps.rps.repository.PlayerRepository;
import org.bson.Document;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlayerService {

    @Autowired
    private PlayerRepository playerRepository;

    public boolean savePlayer(PlayerModel playerModel){
        MongoClient mongoClient = MongoClients.create();

        MongoDatabase sampleTrainingDB = mongoClient.getDatabase("test");
        MongoCollection<Document> playerCollection = sampleTrainingDB.getCollection("playerModel");



        Document player = createPlayerDocument(playerModel);

        return playerCollection.insertOne(player).wasAcknowledged();
    }

    public PlayerModel loadPlayerByName(String name){
        List<PlayerModel> playerByName = playerRepository.findByName(name);
        return playerByName.stream().findFirst().orElse(null);
    }

    public Document createPlayerDocument(PlayerModel playerModel){
        Document playerDoc = new Document("_id", new ObjectId());
        playerDoc.append("name", playerModel.getName())
                .append("choice", playerModel.getChoice().toString())
                .append("result", playerModel.getResult().toString());
        return playerDoc;
    }
}
