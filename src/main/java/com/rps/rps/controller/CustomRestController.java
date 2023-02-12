package com.rps.rps.controller;
import com.rps.rps.gameitems.Item;
import com.rps.rps.gameitems.Result;
import com.rps.rps.mapper.Mapper;
import com.rps.rps.dtos.GameDTO;
import com.rps.rps.dtos.MatchDTO;
import com.rps.rps.dtos.PlayerDTO;
import com.rps.rps.models.GameModel;
import com.rps.rps.models.MatchModel;
import com.rps.rps.models.PlayerModel;
import com.rps.rps.services.GameControlService;
import com.rps.rps.repository.MatchService;
import com.rps.rps.repository.PlayerService;
import com.rps.rps.repository.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

/**
 * REST API for backend logic
 */
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/rest/")
public class CustomRestController {


    @Autowired
    private final GameControlService gameControlService;

    @Autowired
    private final GameService gameService;

    @Autowired
    private final PlayerService playerService;

    @Autowired
    private final MatchService matchService;

    CustomRestController(GameControlService gameControlService,
                         GameService gameService,
                         PlayerService playerService,
                         MatchService matchService){
        this.gameControlService = gameControlService;
        this.gameService = gameService;
        this.playerService = playerService;
        this.matchService = matchService;
    }

    /**
     * Method for a typical match between a real and a CPU player
     * @param playerDTO the player instance from the frontend with the name and their hand
     * @return A match object with both participants and the result of their match
     */
    @PostMapping("play")
    public MatchDTO determineWinner(@RequestBody PlayerDTO playerDTO){
        System.out.println("REST PLAY");
        PlayerModel playerModel = Mapper.mapToPlayerModel(playerDTO);

        MatchModel match = gameControlService.playAndDecideOutcome(playerModel);
        MatchDTO matchDTO = Mapper.mapMatchModelToMatchDTO(match);
        return matchDTO;
    }

    /**
     * Rest API for saving games to the database
     * @param gameDTO the game to be saved
     * @return boolean if the game was saved or not
     */
    @PostMapping("savegame")
    public boolean saveGame(@RequestBody GameDTO gameDTO){
        System.out.println("REST SAVE");

        GameModel game = Mapper.mapGameDTOToGameModel(gameDTO);
        return this.gameService.saveGame(game);
    }

    /**
     * Loading a specific game from the database
     * @return returning the specified game
     */
    @PostMapping("loadgame")
    public GameDTO loadGame(@RequestBody String gameid){
        System.out.println("REST LOAD");
        GameModel gameModel = this.gameService.loadGame(gameid);
        GameDTO gameDTO = Mapper.mapGameModelToGameDTO(gameModel);

        return gameDTO;
    }

}
