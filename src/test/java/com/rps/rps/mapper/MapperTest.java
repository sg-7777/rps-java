package com.rps.rps.mapper;

import com.rps.rps.dtos.GameDTO;
import com.rps.rps.dtos.MatchDTO;
import com.rps.rps.dtos.PlayerDTO;
import com.rps.rps.gameitems.Item;
import com.rps.rps.gameitems.Result;
import com.rps.rps.models.GameModel;
import com.rps.rps.models.MatchModel;
import com.rps.rps.models.PlayerModel;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;

public class MapperTest {

    private PlayerModel expectedPlayerModel;
    private PlayerDTO expectedPlayerDTO;
    private MatchModel expectedMatchModel;
    private MatchDTO expectedMatchDTO;
    private ArrayList<MatchModel> expectedMatchModelArray;
    private GameModel expectedGameModel;
    private ArrayList<MatchDTO> expectedMatchDTOArray;
    private GameDTO expectedGameDTO;

    @BeforeEach
    void setUp(){
        expectedPlayerModel = new PlayerModel("Expected", Item.ROCK, Result.WIN);
        expectedPlayerDTO = new PlayerDTO("Expected", Item.ROCK.toString(), Result.WIN.toString());
        expectedMatchModel = new MatchModel("1", expectedPlayerModel, expectedPlayerModel);
        expectedMatchDTO = new MatchDTO("1", expectedPlayerDTO, expectedPlayerDTO);
        expectedMatchModelArray = new ArrayList<>();
        expectedMatchModelArray.add(expectedMatchModel);
        expectedGameModel = new GameModel("1", expectedMatchModelArray, 1, 1);
        expectedMatchDTOArray = new ArrayList<>();
        expectedMatchDTOArray.add(expectedMatchDTO);
        expectedGameDTO = new GameDTO("1", expectedMatchDTOArray, 1, 1);
    }

    @Test
    void testPlayerModelToPlayerDTO(){
        PlayerDTO testPlayerDTO = Mapper.mapToPlayerDTO(expectedPlayerModel);
        assertThat(testPlayerDTO).usingRecursiveComparison().isEqualTo(expectedPlayerDTO);
    }

    @Test
    void testPlayerDTOToPlayerModel(){
        PlayerModel testPlayerModel = Mapper.mapToPlayerModel(expectedPlayerDTO);
        assertThat(testPlayerModel).usingRecursiveComparison().isEqualTo(expectedPlayerModel);
    }

    @Test
    void testMatchModelToMatchDTO(){
        MatchDTO testMatchDTO = Mapper.mapMatchModelToMatchDTO(expectedMatchModel);
        assertThat(testMatchDTO).usingRecursiveComparison().isEqualTo(expectedMatchDTO);
    }

    @Test
    void testMatchDTOToMatchModel(){
        MatchModel testMatchModel = Mapper.mapMatchDTOToMatchModel(expectedMatchDTO);
        assertThat(testMatchModel).usingRecursiveComparison().isEqualTo(expectedMatchModel);
    }

    @Test
    void testGameDTOToGameModel(){
        GameModel testGameModel = Mapper.mapGameDTOToGameModel(expectedGameDTO);
        assertThat(testGameModel).usingRecursiveComparison().isEqualTo(expectedGameModel);
    }

    @Test
    void testGameModelToGameDTO(){
        GameDTO testGameDTO = Mapper.mapGameModelToGameDTO(expectedGameModel);
        assertThat(testGameDTO).usingRecursiveComparison().isEqualTo(expectedGameDTO);
    }
}
