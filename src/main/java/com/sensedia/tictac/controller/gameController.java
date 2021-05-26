package com.sensedia.tictac.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/v1/games")
public class gameController {

    @PostMapping("creategame")
    public void createGame() {
        return;
    }
}
