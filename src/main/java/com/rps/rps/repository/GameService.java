package com.rps.rps.repository;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.result.InsertOneResult;
import com.rps.rps.models.GameModel;
import com.rps.rps.models.MatchModel;
import org.bson.Document;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**
 * This Service is responsible for managing the Game Data of two players
 * Can save a game with saveGame()
 * Can load a game with loadGame()
 */
@Service
public class GameService {

    @Autowired
    private GameRepository gameRepository;

    @Autowired
    private MatchService matchService;

    /**
     * Simple Method for persisting a GameModel
     * @param gameModel the played game
     */
    public boolean saveGame(GameModel gameModel){
        MongoClient mongoClient = MongoClients.create();

        MongoDatabase sampleTrainingDB = mongoClient.getDatabase("test");
        MongoCollection<Document> gameCollection = sampleTrainingDB.getCollection("gameModel");

        Document game = createGameDocument(gameModel);

        return gameCollection.insertOne(game).wasAcknowledged();
    }

    /**
     * Loading a random GameModel from mongoDB
     * @return random game played in the past
     */
    public GameModel loadGame(){
        return gameRepository.findAll().get(0);
    }

    public Document createGameDocument(GameModel gameModel){
        Document gameDoc = new Document("_id", new ObjectId());
        gameDoc.append("gameid", gameModel.getGameid());

        for(MatchModel m : gameModel.getMatches()){
            gameDoc.append("match " + m.getMatchid(), matchService.createMatchDocument(m));
        }

        gameDoc.append("playerOneScore", gameModel.getPlayerOneScore())
                .append("playerTwoScore", gameModel.getPlayerTwoScore());
        return gameDoc;
    }
}
