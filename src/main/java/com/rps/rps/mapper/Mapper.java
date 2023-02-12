package com.rps.rps.mapper;

import com.rps.rps.dtos.GameDTO;
import com.rps.rps.dtos.MatchDTO;
import com.rps.rps.dtos.PlayerDTO;
import com.rps.rps.gameitems.Item;
import com.rps.rps.gameitems.Result;
import com.rps.rps.models.GameModel;
import com.rps.rps.models.MatchModel;
import com.rps.rps.models.PlayerModel;

import java.util.ArrayList;

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
                .result(playerDTO.getResult() != null ? Result.valueOf(playerDTO.getResult()) : null)
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
        return new MatchDTO(matchModel.getMatchid(),
                            mapToPlayerDTO(matchModel.getPlayerOne()),
                            mapToPlayerDTO(matchModel.getPlayerTwo()));
    }

    public static MatchModel mapMatchDTOToMatchModel(MatchDTO matchDTO){
        return new MatchModel(matchDTO.getMatchid(),
                                mapToPlayerModel(matchDTO.getPlayerOne()),
                                mapToPlayerModel(matchDTO.getPlayerTwo()));
    }

    public static GameModel mapGameDTOToGameModel(GameDTO gameDTO){
        GameModel gameModel = new GameModel(gameDTO.getGameid(),
                                            new ArrayList<MatchModel>(),
                                            gameDTO.getPlayerOneScore(),
                                            gameDTO.getPlayerTwoScore());

        for(MatchDTO mDTO : gameDTO.getMatches()){
            MatchModel matchModel = mapMatchDTOToMatchModel(mDTO);
            gameModel.addMatchModel(matchModel);
        }

        return gameModel;
    }

    public static GameDTO mapGameModelToGameDTO(GameModel gameModel){
        GameDTO gameDTO = new GameDTO(gameModel.getGameid(),
                                        new ArrayList<MatchDTO>(),
                                        gameModel.getPlayerOneScore(),
                                        gameModel.getPlayerTwoScore());

        for(MatchModel mModel : gameModel.getMatches()){
            MatchDTO matchDTO = mapMatchModelToMatchDTO(mModel);
            gameDTO.addMatchDTO(matchDTO);
        }

        return gameDTO;
    }
}
