package com.me.dslist.services;

import com.me.dslist.dto.GameListDTO;
import com.me.dslist.entities.GameList;
import com.me.dslist.repositories.GameListRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class GameListService {

    @Autowired
    private GameListRepository gameListRepository;

//    public Optional<GameDTO> findById(Long id) {
//        Game result = gameRepository.findById(id).get();
//        return Optional.of(new GameDTO(result));
//    }

    @Transactional(readOnly = true)
    public List<GameListDTO> findAll() {
        List<GameList> result = gameListRepository.findAll();
        List<GameListDTO> dto = result.stream().map(GameListDTO::new).toList();
        return dto;
    }
}
