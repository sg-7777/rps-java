package com.rps.rps.gameitems;

import com.rps.rps.models.PlayerModel;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * An object of this class represents a match being played between two players and the outcome of this match
 */
@AllArgsConstructor
public class MatchModel {

    @Getter
    private PlayerModel playerOne, playerTwo;
}
