package com.rps.rps.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.annotation.Id;

@Data
public class GameModel {
    @Id
    private String id;

    private MatchModel match;
    private int playerOneScore, playerTwoScore;

    public GameModel(MatchModel match, int playerOneScore, int playerTwoScore){
        this.match = match;
        this.playerOneScore = playerOneScore;
        this.playerTwoScore = playerTwoScore;
    }
}
