package com.rps.rps.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
public class MatchDTO {

    @Getter
    private PlayerDTO playerOne, playerTwo;
}
