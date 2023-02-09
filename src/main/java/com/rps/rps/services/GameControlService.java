package com.rps.rps.services;

import com.rps.rps.models.MatchModel;
import com.rps.rps.models.PlayerModel;
import com.rps.rps.gameitems.opponent.NormalOpponent;
import com.rps.rps.rules.RuleEngine;
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
     * @return MatchModel object with both participants and the result of their competing hands
     */
    public MatchModel play(PlayerModel player){
        PlayerModel mediumCpu = PlayerModel.builder()
                .name("Medium CPU")
                .choice(new NormalOpponent().throwHand())
                .build();

        return RuleEngine.decide(player, mediumCpu);
    }
}
