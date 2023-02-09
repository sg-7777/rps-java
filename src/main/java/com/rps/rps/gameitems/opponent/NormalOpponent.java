package com.rps.rps.gameitems.opponent;

import com.rps.rps.gameitems.Item;
import com.rps.rps.gameitems.rules.HandsDict;

import java.util.Random;

/**
 * Opponent class with normal difficulty. Same probability for all 3 options
 */
public class NormalOpponent implements RandomOpponent{

    /**
     * Random number between 1 and 3 to decide via HandsDict which option of ROCK, PAPER, SCISSORS can be taken
     * @return the hand as Item
     */
    @Override
    public Item throwHand() {
        Random rng = new Random();
        int i = rng.ints(1,4).findFirst().getAsInt();
        return HandsDict.getHand(i);
    }
}
