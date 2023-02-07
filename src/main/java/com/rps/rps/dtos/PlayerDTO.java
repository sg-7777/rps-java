package com.rps.rps.dtos;

import lombok.Getter;
import lombok.Setter;

/**
 * Data Transfer Object of a player instance. Has everything important for being a player
 */
public class PlayerDTO {
    /**
     * Name of the player
     */
    @Getter @Setter
    private String name;

    /**
     * Choice of Hand in the current Match
     */
    //TODO Change choice data type to enum type
    @Getter @Setter
    private String choice;

    /**
     * The result of the current Match
     */
    //TODO Change result data type to enum type
    @Getter @Setter
    private String result;
}
