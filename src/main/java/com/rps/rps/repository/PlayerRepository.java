package com.rps.rps.repository;

import com.rps.rps.models.PlayerModel;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface PlayerRepository extends MongoRepository<PlayerModel, String> {
    public PlayerModel findByName(String name);
}
