package com.rps.rps.models;

import com.rps.rps.gameitems.Item;
import com.rps.rps.gameitems.Result;
import lombok.*;
import org.springframework.data.annotation.Id;

/**
 * Basic Model to represent a player with it's name, hand and result of the match
 */
@Builder
@Data
@AllArgsConstructor
public class PlayerModel {

    @Id
    private String id;
    private String name;

    private Item choice;

    private Result result;

}
