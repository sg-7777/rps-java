package com.rps.rps.gameitems;

import com.rps.rps.dtos.PlayerDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

/**
 * An object of this class represents a match being played between two players and the outcome of this match
 */
@AllArgsConstructor
public class Match {
    @Getter @Setter
    private PlayerDTO player1, player2;
    @Getter @Setter
    private String Winner;
}
