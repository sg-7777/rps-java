package com.rps.rps.opponent;

/**
 * Interface for all Opponent Classes with different difficulty level
 */
public interface RandomOpponent {

    /**
     * Standard method for playing the game
     * @return returns the picked number representing rock paper or scissors
     * id 1: rock
     * id 2: paper
     * id 3: scissors
     * id x: more options
     */
    public int throwHand();
}
