package com.rps.rps.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
public class GameDTO {
    @Getter
    private MatchDTO match;
    @Getter
    private String score;
}
