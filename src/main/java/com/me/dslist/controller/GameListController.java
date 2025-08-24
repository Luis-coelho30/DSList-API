package com.me.dslist.controller;

import com.me.dslist.dto.GameDTO;
import com.me.dslist.dto.GameListDTO;
import com.me.dslist.dto.GameMinDTO;
import com.me.dslist.services.GameListService;
import com.me.dslist.services.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/lists")
public class GameListController {

    @Autowired
    private GameListService gameListService;

//    @GetMapping(value = "/{id}")
//    public ResponseEntity<GameDTO> findById(@PathVariable Long id) {
//        return gameService.findById(id)
//                .map(ResponseEntity::ok)
//                .orElseGet(() -> ResponseEntity.notFound().build());
//    }

    @GetMapping
    public List<GameListDTO> findAll() {
        List<GameListDTO> result = gameListService.findAll();
        return result;
    }

}
