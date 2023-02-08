package com.rps.rps.gameitems;

/**
 * Enum to ensure possible options to pick from
 *
 */
public enum Item {

    ROCK("ROCK"),
    PAPER("PAPER"),
    SCISSORS("SCISSORS");

    private final String hand;

    private Item(String s) {
        hand = s;
    }

    /**
     * See if Input matches any EnumType. Regardless of input being lower- or uppercase
     * @param input input to check if available
     * @return boolean if input is equals to any Enum of the Type
     */
    public boolean equalsName(String input) {
        return hand.equals(input.toUpperCase());
    }

    public String toString() {
        return this.hand;
    }
}

