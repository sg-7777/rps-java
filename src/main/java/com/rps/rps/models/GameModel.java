package com.rps.rps.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.annotation.Id;

@Data
public class GameModel {
    @Id
    private String id;

    private MatchModel match;
    private String score;

    public GameModel(MatchModel match, String score){
        this.match = match;
        this.score = score;
    }
}
