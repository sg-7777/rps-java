package com.rps.rps.mappingservice;

import com.rps.rps.dtos.GameDTO;
import com.rps.rps.dtos.MatchDTO;
import com.rps.rps.dtos.PlayerDTO;
import com.rps.rps.gameitems.Item;
import com.rps.rps.models.GameModel;
import com.rps.rps.models.MatchModel;
import com.rps.rps.models.PlayerModel;

/**
 * simple "static" class for mapping between all DTOs and Models
 */
public class Mapper {

    private Mapper(){}

    /**
     * Maps a PlayerDTO to a PlayModel
     * @param playerDTO the input from rest call
     * @return the Playermodel for business logic
     */
    public static PlayerModel mapToPlayerModel(PlayerDTO playerDTO){
        return PlayerModel.builder()
                .name(playerDTO.getName())
                .choice(Item.valueOf(playerDTO.getChoice().toUpperCase()))
                .build();
    }

    /**
     * Maps a PlayerModel to a PlayerDTO
     * @param playerModel Business model for logic
     * @return DTO for the rest response
     */
    public static PlayerDTO mapToPlayerDTO(PlayerModel playerModel){
        return PlayerDTO.builder()
                .name(playerModel.getName())
                .choice(playerModel.getChoice().toString())
                .result(playerModel.getResult().toString())
                .build();
    }

    public static MatchDTO mapMatchModelToMatchDTO(MatchModel matchModel){
        return new MatchDTO(mapToPlayerDTO(matchModel.getPlayerOne()),
                            mapToPlayerDTO(matchModel.getPlayerTwo()));
    }

    public static MatchModel mapMatchDTOToMatchModel(MatchDTO matchDTO){
        return new MatchModel(mapToPlayerModel(matchDTO.getPlayerOne()),
                                mapToPlayerModel(matchDTO.getPlayerTwo()));
    }

    public static GameModel mapGameDTOToGameModel(GameDTO gameDTO){
        MatchModel m = mapMatchDTOToMatchModel(gameDTO.getMatch());
        return new GameModel(m, gameDTO.getScore());
    }

    public static GameDTO mapGameModelToGameDTO(GameModel gameModel){
        MatchDTO m = mapMatchModelToMatchDTO(gameModel.getMatch());
        return new GameDTO(m, gameModel.getScore());
    }
}
