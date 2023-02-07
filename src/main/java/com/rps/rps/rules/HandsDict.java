package com.rps.rps.rules;

import java.util.HashMap;
import java.util.Map;

public class HandsDict {
    private static final Map<Integer, String> DICTONARYOFHANDS = new HashMap<>(){{

        put(Integer.valueOf(1), "ROCK");
        put(Integer.valueOf(2), "PAPER");
        put(Integer.valueOf(3), "SCISSORS");
    }};

    public static String getHand(int Key){
        return DICTONARYOFHANDS.get(Key);
    }
}
