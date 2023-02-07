package com.rps.rps;
import com.rps.rps.dtos.PlayerDTO;
import com.rps.rps.gameitems.Match;
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
     * @param player the player instance from the frontend with the name and their hand
     * @return A match object with both participants and the result of their match
     */
    @PostMapping("play")
    public Match determineWinner(@RequestBody PlayerDTO player){
        return gameControlService.play(player);
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
