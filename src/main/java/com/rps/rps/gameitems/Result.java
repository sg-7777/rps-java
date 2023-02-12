package com.rps.rps.gameitems;

/**
 * Represents the 3 possible outcomes of a match: WIN, LOSE, DRAW
 */
public enum Result {
    WIN("WIN"),
    LOSE("LOSE"),
    DRAW("DRAW");

    private final String result;

    private Result(String s){
        result = s;
    }

    public boolean equalsName(String input) {
        return result.equals(input.toUpperCase());
    }

    public String toString(){
        return this.result;
    }
}
