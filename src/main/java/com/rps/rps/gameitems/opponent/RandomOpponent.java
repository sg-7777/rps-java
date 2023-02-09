package com.rps.rps.gameitems.opponent;

import com.rps.rps.gameitems.Item;

/**
 * Interface for all Opponent Classes with different difficulty level
 */
public interface RandomOpponent {

    /**
     * Standard method for playing the game
     * @return returns the picked hand as ItemType
     */
     Item throwHand();
}
