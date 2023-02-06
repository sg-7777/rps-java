package com.rps.rps.gameitems;

import lombok.Getter;
import lombok.Setter;

public class PlayerToken {

    @Getter @Setter
    private String name;
    @Getter @Setter
    private Item choice;

    PlayerToken(String name){
        this.name = name;
    }

    PlayerToken(String name, Item choice){
        this(name);
        this.choice = choice;
    }
}
