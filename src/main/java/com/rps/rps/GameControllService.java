package com.rps.rps;

import com.rps.rps.opponent.NormalOpponent;
import org.springframework.stereotype.Service;

@Service
public class GameControllService {

    public int play(){
        NormalOpponent normalOpponent = new NormalOpponent();
        return normalOpponent.throwHand();
    }
}
