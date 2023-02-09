package com.rps.rps.services;

import com.rps.rps.gameitems.Item;
import com.rps.rps.gameitems.Result;
import com.rps.rps.models.GameModel;
import com.rps.rps.models.MatchModel;
import com.rps.rps.models.PlayerModel;
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
        System.out.println("hello");
    }

    /**
     * Loading a random GameModel from mongoDB
     * @return random game played in the past
     */
    public GameModel loadGame(){
        PlayerModel playerModel1 = new PlayerModel("1", "Test1", Item.PAPER, Result.DRAW);
        PlayerModel playerModel2 = new PlayerModel("2", "Test2", Item.PAPER, Result.DRAW);
        MatchModel match = new MatchModel(playerModel1, playerModel2);
        GameModel game = new GameModel(match, 1, 1);
        gameRepository.save(game);
        return gameRepository.findAll().get(0);
    }
}
