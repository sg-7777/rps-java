package com.rps.rps.services;

import com.rps.rps.gameitems.Item;
import com.rps.rps.models.MatchModel;
import com.rps.rps.gameitems.Result;
import com.rps.rps.models.PlayerModel;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

/**
 * Rules for the game are here defined
 */
@Component
public class RuleEngine {

    private int matchNumber = 0;

    /**
     * This method implements the basic and international known rules for rock, paper, scissors
     * @param playerOne most of the time the real human
     * @param playerTwo most of the time the fake human aka CPU
     * @return sets both players in a context called match
     */
    public MatchModel decideOutcome(PlayerModel playerOne, PlayerModel playerTwo){
        if(playerOne.getChoice().equals(playerTwo.getChoice())){
            playerOne.setResult(Result.DRAW);
            playerTwo.setResult(Result.DRAW);
        }

        if(playerOne.getChoice().equals(Item.ROCK)){
            if(playerTwo.getChoice().equals(Item.PAPER)){
                playerOne.setResult(Result.LOSE);
                playerTwo.setResult(Result.WIN);
            }

            if(playerTwo.getChoice().equals(Item.SCISSORS)){
                playerOne.setResult(Result.WIN);
                playerTwo.setResult(Result.LOSE);
            }
        }

        if(playerOne.getChoice().equals(Item.PAPER)){
            if(playerTwo.getChoice().equals(Item.ROCK)){
                playerOne.setResult(Result.WIN);
                playerTwo.setResult(Result.LOSE);
            }

            if(playerTwo.getChoice().equals(Item.SCISSORS)){
                playerOne.setResult(Result.LOSE);
                playerTwo.setResult(Result.WIN);
            }
        }

        if(playerOne.getChoice().equals(Item.SCISSORS)){
            if(playerTwo.getChoice().equals(Item.PAPER)){
                playerOne.setResult(Result.WIN);
                playerTwo.setResult(Result.LOSE);
            }

            if(playerTwo.getChoice().equals(Item.ROCK)){
                playerOne.setResult(Result.LOSE);
                playerTwo.setResult(Result.WIN);
            }
        }
        matchNumber++;
        return new MatchModel(String.valueOf(matchNumber), playerOne, playerTwo);
    }
}
