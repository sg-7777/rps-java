package com.rps.rps.gameitems;

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
