package com.rps.rps.repository;

import com.rps.rps.models.PlayerModel;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface PlayerRepository extends MongoRepository<PlayerModel, String> {
    public List<PlayerModel> findByName(String name);
}
