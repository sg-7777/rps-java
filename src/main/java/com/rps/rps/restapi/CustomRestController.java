package com.rps.rps.restapi;
import com.rps.rps.mappingservice.Mapper;
import com.rps.rps.dtos.GameDTO;
import com.rps.rps.dtos.MatchDTO;
import com.rps.rps.dtos.PlayerDTO;
import com.rps.rps.models.GameModel;
import com.rps.rps.models.MatchModel;
import com.rps.rps.models.PlayerModel;
import com.rps.rps.services.GameControlService;
import com.rps.rps.services.SavegameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
    private final SavegameService savegameService;

    CustomRestController(GameControlService gameControlService,
                         SavegameService savegameService){
        this.gameControlService = gameControlService;
        this.savegameService =savegameService;
    }

    /**
     * Method for a typical match between a real and a CPU player
     * @param playerDTO the player instance from the frontend with the name and their hand
     * @return A match object with both participants and the result of their match
     */
    @PostMapping("play")
    public MatchDTO determineWinner(@RequestBody PlayerDTO playerDTO){
        PlayerModel playerModel = Mapper.mapToPlayerModel(playerDTO);

        MatchModel match = gameControlService.play(playerModel);
        MatchDTO matchDTO = Mapper.mapMatchModelToMatchDTO(match);
        return matchDTO;
    }

    @PutMapping("savegame")
    public void saveGame(@RequestBody GameDTO gameDTO){
        GameModel game = Mapper.mapGameDTOToGameModel(gameDTO);

    }

    @GetMapping("loadgame")
    public GameDTO loadGame(){
        return Mapper.mapGameModelToGameDTO(savegameService.loadGame());
    }
}
