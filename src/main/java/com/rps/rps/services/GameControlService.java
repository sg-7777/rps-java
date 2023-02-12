package com.rps.rps.services;

import com.rps.rps.models.MatchModel;
import com.rps.rps.models.PlayerModel;
import com.rps.rps.gameitems.opponent.NormalOpponent;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * This service controls the flow of a match between two players
 */
@Service
@RequiredArgsConstructor
public class GameControlService {


    private final RuleEngine rules;

    /**
     * This method is responsible for the match being played. It puts both players in a context, a match. Evaluation
     * of player choices and deciding the result
     * @param player object with the name and hand of the current match from the frontend
     * @return MatchModel object with both participants and the result of their competing hands
     */
    public MatchModel playAndDecideOutcome(PlayerModel player){
        PlayerModel mediumCpu = getMediumCpu();
        MatchModel matchModel = rules.decideOutcome(player, mediumCpu);
        return matchModel;
    }

    private PlayerModel getMediumCpu() {
        return PlayerModel.builder()
                .name("Medium CPU")
                .choice(new NormalOpponent().pickHand())
                .build();
    }

}
