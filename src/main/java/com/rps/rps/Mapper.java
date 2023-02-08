package com.rps.rps;

import com.rps.rps.dtos.MatchDTO;
import com.rps.rps.dtos.PlayerDTO;
import com.rps.rps.gameitems.Item;
import com.rps.rps.gameitems.MatchModel;
import com.rps.rps.models.PlayerModel;

/**
 * simple "static" class for mapping between PlayerDTO and PlayerModel
 * utilises the inbuild Builder Pattern
 */
public class Mapper {

    private Mapper(){}
    public static PlayerModel mapToPlayerModel(PlayerDTO playerDTO){
        return PlayerModel.builder()
                .name(playerDTO.getName())
                .choice(Item.valueOf(playerDTO.getChoice().toUpperCase()))
                .build();
    }

    public static PlayerDTO mapToPlayerDTO(PlayerModel playerModel){
        return PlayerDTO.builder()
                .name(playerModel.getName())
                .choice(playerModel.getChoice().toString())
                .result(playerModel.getResult().toString())
                .build();
    }

    public static MatchDTO mapMatchModelToMatchDTO(MatchModel match){
        return new MatchDTO(mapToPlayerDTO(match.getPlayerOne()),
                            mapToPlayerDTO(match.getPlayerTwo()));
    }
}
