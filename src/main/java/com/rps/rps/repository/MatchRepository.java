package com.rps.rps.repository;

import com.rps.rps.models.MatchModel;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface MatchRepository extends MongoRepository<MatchModel, String> {


}
