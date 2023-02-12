package com.rps.rps.repository;
import com.rps.rps.models.GameModel;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface GameRepository extends MongoRepository<GameModel, String> {

    public GameModel findByGameid(String gameid);

}
