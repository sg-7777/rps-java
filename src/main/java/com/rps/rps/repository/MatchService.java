package com.rps.rps.repository;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.result.InsertOneResult;
import com.rps.rps.models.MatchModel;
import org.bson.Document;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MatchService {

    @Autowired
    private MatchRepository matchRepository;

    @Autowired
    private PlayerService playerService;

    public boolean saveMatch(MatchModel matchModel){

        MongoClient mongoClient = MongoClients.create();

        MongoDatabase sampleTrainingDB = mongoClient.getDatabase("test");
        MongoCollection<Document> matchCollection = sampleTrainingDB.getCollection("matchModel");

        Document match = createMatchDocument(matchModel);

        return matchCollection.insertOne(match).wasAcknowledged();
    }

    public MatchModel loadMatch(){
        List<MatchModel> all = matchRepository.findAll();
        return all.stream().findFirst().orElse(null);
    }

    public Document createMatchDocument(MatchModel matchModel){
        Document matchDoc = new Document("_id", new ObjectId());
        matchDoc.append("matchid", matchModel.getMatchid())
                .append("playerOne", playerService.createPlayerDocument(matchModel.getPlayerOne()))
                .append("playerTwo", playerService.createPlayerDocument(matchModel.getPlayerTwo()));
        return matchDoc;
    }
}
