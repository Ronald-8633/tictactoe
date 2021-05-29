package com.sensedia.tictac.repository;


import com.sensedia.tictac.domain.model.Game;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface GameRepository extends MongoRepository<Game, String> {
}
