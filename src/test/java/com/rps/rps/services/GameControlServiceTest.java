package com.rps.rps.services;

import com.rps.rps.gameitems.Item;
import com.rps.rps.gameitems.Result;
import com.rps.rps.models.MatchModel;
import com.rps.rps.models.PlayerModel;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.Assertions.anyOf;
import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(MockitoExtension.class)
public class GameControlServiceTest {
    @Mock
    private RuleEngine rules= new RuleEngine();

    private GameControlService gameControlService;
    @BeforeEach
    void setUp(){
        gameControlService= new GameControlService(rules);
    }

    //Is this correct?
    @Test
    public void decideOutcomeDRAWTest(){
        PlayerModel player1 = PlayerModel.builder().choice(Item.ROCK).result(Result.DRAW).build();
        PlayerModel player2 = PlayerModel.builder().choice(Item.ROCK).result(Result.DRAW).build();

        Mockito.when(rules.decideOutcome(Mockito.any(PlayerModel.class),Mockito.any(PlayerModel.class)))
                .thenReturn(new MatchModel("1", player1,player2));

        MatchModel matchModelResult = gameControlService.playAndDecideOutcome(player1);

        assertThat(matchModelResult.getPlayerOne().getResult()).isEqualTo(Result.DRAW);
        assertThat(matchModelResult.getPlayerTwo().getResult()).isEqualTo(Result.DRAW);
    }

}
