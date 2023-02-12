package com.rps.rps.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;

/**
 * DTO for Games. Same as GameModel
 */
public class GameDTO {

    @Getter
    private String gameid;
    @Getter
    private ArrayList<MatchDTO> matches;
    @Getter
    private int playerOneScore, playerTwoScore;

    public GameDTO(String gameid, ArrayList<MatchDTO> matches, int playerOneScore, int playerTwoScore){
        this.gameid = gameid;
        this.matches = new ArrayList<MatchDTO>(matches);
        this.playerOneScore = playerOneScore;
        this.playerTwoScore = playerTwoScore;

    }

    public void addMatchDTO(MatchDTO match){
        this.matches.add(match);
    }
}
