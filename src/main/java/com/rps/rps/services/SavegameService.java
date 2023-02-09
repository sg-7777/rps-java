package com.rps.rps.services;

import com.rps.rps.models.GameModel;
import com.rps.rps.repository.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * This Service is responsible for managing the Game Data of two players
 * Can save a game with saveGame()
 * Can load a game with loadGame()
 */
@Service
public class SavegameService {

    @Autowired
    private GameRepository gameRepository;

    /**
     * Simple Method for persisting a GameModel
     * @param gameModel the played game
     */
    public void saveGame(GameModel gameModel){
        gameRepository.save(gameModel);
    }

    /**
     * Loading a random GameModel from mongoDB
     * @return random game played in the past
     */
    public GameModel loadGame(){
        return gameRepository.findAll().get(0);
    }
}
