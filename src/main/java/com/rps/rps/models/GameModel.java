package com.rps.rps.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;

import java.util.ArrayList;

/**
 * GameModel wraps matches and holds the score of the 2 competitors
 */
@Data
public class GameModel {
    @Id
    private String id;

    @Getter
    @Setter
    private String gameid;

    private ArrayList<MatchModel> matches;
    private int playerOneScore, playerTwoScore;

    public GameModel(String gameid, ArrayList<MatchModel> matches, int playerOneScore, int playerTwoScore){
        this.gameid = gameid;
        this.matches = new ArrayList<>(matches);
        this.playerOneScore = playerOneScore;
        this.playerTwoScore = playerTwoScore;
    }

    public void addMatchModel(MatchModel match){
        this.matches.add(match);
    }
}
