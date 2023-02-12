package com.rps.rps.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * DTO for matches. Same as MatchModel
 */
@AllArgsConstructor
public class MatchDTO {

    @Getter
    private String matchid;

    @Getter
    private PlayerDTO playerOne, playerTwo;
}
