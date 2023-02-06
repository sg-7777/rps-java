package com.rps.rps;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("api/")
public class CostumRestController {


    @Autowired
    private final GameControllService gameControllService;

    CostumRestController(GameControllService gameControllService){
        this.gameControllService = gameControllService;
    }
    @GetMapping("hello")
    public int getGameElement(){
        return this.gameControllService.play();
    }
}
