package com.sensedia.tictac.service;

import com.sensedia.tictac.domain.model.Game;
import com.sensedia.tictac.repository.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GameServiceImpl implements GameService {

    @Autowired
    private GameRepository gameRepository;

    @Override
    public Game createGame(Game game) {
        return gameRepository.save(game);
    }


}
