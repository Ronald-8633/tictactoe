package com.sensedia.tictac.controller;

import com.sensedia.tictac.domain.model.Game;
import com.sensedia.tictac.service.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/v1/games")
public class GameController {

    @Autowired
    GameService gameService;

    @PostMapping("creategame")
    public void createGame() {

        List<String> board = new ArrayList<>();
        board.add("a");
        board.add("b");
        board.add("c");
        board.add("d");

        var game = Game.builder()
                .mark("X")
                .turn("0")
                .board(board)
                .build();

        gameService.createGame(game);

    }
}
