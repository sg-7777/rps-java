package com.rps.rps.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

/**
 * Data Transfer Object of a player instance. Has everything important for being a player
 */
@Builder
@Getter
@Setter
@AllArgsConstructor
public class PlayerDTO {
    /**
     * Name of the player
     */
    private String name;

    /**
     * Choice of Hand in the current MatchModel
     */
    private String choice;

    private String result;

}
