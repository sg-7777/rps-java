package com.rps.rps;

import com.rps.rps.dtos.PlayerDTO;
import com.rps.rps.gameitems.Match;
import com.rps.rps.opponent.NormalOpponent;
import org.springframework.stereotype.Service;

/**
 * This service controls the flow of a match between two players
 */
@Service
public class GameControlService {

    /**
     * This method is responsible for the match being played. It puts both players in a context, a match. Evaluation
     * of player choices and deciding the result
     * @param player object with the name and hand of the current match from the frontend
     * @return Match object with both participants and the result of their competing hands
     */
    //TODO refactor opponent generation
    public Match play(PlayerDTO player){
        NormalOpponent normalOpponent = new NormalOpponent();


        PlayerDTO opponent = new PlayerDTO();
        opponent.setName("Opponent");
        opponent.setChoice(normalOpponent.throwHand());

        Match newMatch = new Match(player, opponent, "Winner Winner Chicken Dinner");

        return newMatch;
    }
}
