package com.rps.rps.opponent;

import java.util.Random;

/**
 * Opponent class with normal difficulty. Same probability of all 3 options
 */
public class NormalOpponent implements RandomOpponent{

    @Override
    public int throwHand() {
        Random rng = new Random();
        return rng.ints(1,4).findFirst().getAsInt();
    }
}
