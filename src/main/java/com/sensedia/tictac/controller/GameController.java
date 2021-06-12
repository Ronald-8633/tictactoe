package com.sensedia.tictac.controller;

import com.sensedia.tictac.domain.model.Game;
import com.sensedia.tictac.service.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/v1/games")
public class GameController {

    @Autowired
    GameService gameService;

    @PostMapping("creategame")
    public ResponseEntity<Game> createGame(@Valid @RequestBody Game game) {
        var gameResponse = gameService.createGame(game);
        return new ResponseEntity<>(gameResponse, HttpStatus.CREATED);
    }
}
