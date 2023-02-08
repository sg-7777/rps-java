package com.rps.rps.models;

import com.rps.rps.gameitems.Item;
import com.rps.rps.gameitems.Result;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

/**
 * Basic Model to represent a player with it's name, hand and result of the match
 */
@Builder
@Getter
public class PlayerModel {

    private String name;

    private Item choice;

    @Setter
    private Result result;
}
