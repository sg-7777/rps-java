package com.rps.rps.models;

import lombok.Data;

import org.springframework.data.annotation.Id;

/**
 * An object of this class represents a match being played between two players and the outcome of this match
 */
@Data
public class MatchModel {

    @Id
    private String id;

    private String matchid;

    private PlayerModel playerOne, playerTwo;

    public MatchModel(String matchid, PlayerModel playerOne, PlayerModel playerTwo){
        this.matchid = matchid;
        this.playerOne = playerOne;
        this.playerTwo = playerTwo;
    }

}
