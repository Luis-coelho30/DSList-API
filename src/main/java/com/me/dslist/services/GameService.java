package com.me.dslist.services;

import com.me.dslist.dto.GameDTO;
import com.me.dslist.dto.GameMinDTO;
import com.me.dslist.entities.Game;
import com.me.dslist.projections.GameMinProjection;
import com.me.dslist.repositories.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class GameService {

    @Autowired
    private GameRepository gameRepository;

    @Transactional(readOnly = true)
    public Optional<GameDTO> findById(Long id) {
        Game result = gameRepository.findById(id).get();
        return Optional.of(new GameDTO(result));
    }

    @Transactional(readOnly = true)
    public List<GameMinDTO> findAll() {
        List<Game> result = gameRepository.findAll();
        return result.stream().map(GameMinDTO::new).toList();
    }

    @Transactional(readOnly = true)
    public List<GameMinDTO> findByList(Long listId) {
        List<GameMinProjection> result = gameRepository.searchByList(listId);
        return result.stream().map(GameMinDTO::new).toList();
    }
}
