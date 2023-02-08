package com.rps.rps;
import com.rps.rps.dtos.MatchDTO;
import com.rps.rps.dtos.PlayerDTO;
import com.rps.rps.gameitems.MatchModel;
import com.rps.rps.models.PlayerModel;
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

    CustomRestController(GameControlService gameControlService){
        this.gameControlService = gameControlService;
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
                //new MatchDTO(new PlayerDTO("1", "2", "3"), new PlayerDTO("11", "22", "3"));
    }

    /**
     * Dummy mehtod for testing
     * @return
     */
    @GetMapping("playerchoice")
    public String setPlayerChoice(){

        return "Works";
    }
}
