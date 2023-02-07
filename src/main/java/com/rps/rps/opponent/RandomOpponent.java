package com.rps.rps.opponent;

/**
 * Interface for all Opponent Classes with different difficulty level
 */
public interface RandomOpponent {

    /**
     * Standard method for playing the game
     * @return returns the picked hand
     */
     String throwHand();
}
