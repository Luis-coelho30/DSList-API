package com.me.dslist.repositories;

import com.me.dslist.entities.Game;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GameListRepository extends JpaRepository<Game, Long> {
}
