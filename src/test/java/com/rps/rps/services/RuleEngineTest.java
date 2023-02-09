package com.rps.rps.services;

import com.rps.rps.gameitems.Item;
import com.rps.rps.gameitems.Result;
import com.rps.rps.models.MatchModel;
import com.rps.rps.models.PlayerModel;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(MockitoExtension.class)
public class RuleEngineTest {

    private  RuleEngine rules;
    @BeforeEach
    void setUp(){
        rules = new RuleEngine();
    }

    @Test
    public void decideOutcomeDRAWTest(){
        PlayerModel player1 = PlayerModel.builder().choice(Item.ROCK).build();
        PlayerModel player2 = PlayerModel.builder().choice(Item.ROCK).build();

        MatchModel matchModel = rules.decideOutcome(player1, player2);

        assertThat(matchModel.getPlayerOne().getResult()).isEqualTo(Result.DRAW);
        assertThat(matchModel.getPlayerTwo().getResult()).isEqualTo(Result.DRAW);
    }
}
