package com.rps.rps.gameitems.rules;

import com.rps.rps.gameitems.Item;

import java.util.HashMap;
import java.util.Map;

/**
 * HandsDict functions as a dictonary for the CPU to map their pseudo random int to an Item
 */
public class HandsDict {

    private HandsDict(){}
    private static final Map<Integer, Item> DICTONARYOFHANDS = new HashMap<>(){{

        put(Integer.valueOf(1), Item.ROCK);
        put(Integer.valueOf(2), Item.PAPER);
        put(Integer.valueOf(3), Item.SCISSORS);
    }};

    /**
     * Get 1 of the 3 possible @see com.rps.rps.gameitems.Item available in the game
     * Options: 1 = ROCK, 2 = PAPER, 3 = SCISSORS
     * @param Key to get 1 @see com.rps.rps.gameitems.Item
     * @return returns the @see com.rps.rps.gameitems.Item
     */
    public static Item getHand(int Key){
        return DICTONARYOFHANDS.get(Key);
    }
}
