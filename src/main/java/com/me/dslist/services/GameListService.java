package com.me.dslist.services;

import com.me.dslist.dto.GameDTO;
import com.me.dslist.dto.GameMinDTO;
import com.me.dslist.entities.Game;
import com.me.dslist.repositories.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GameListService {

    @Autowired
    private GameRepository gameRepository;

    public Optional<GameDTO> findById(Long id) {
        Game result = gameRepository.findById(id).get();
        return Optional.of(new GameDTO(result));
    }

    public List<GameMinDTO> findAll() {
        List<Game> result = gameRepository.findAll();
        List<GameMinDTO> dto = result.stream().map(x -> new GameMinDTO(x)).toList();
        return dto;
    }
}
