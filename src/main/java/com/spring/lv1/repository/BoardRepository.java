package com.spring.lv1.repository;

import com.spring.lv1.entity.Board;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface BoardRepository extends JpaRepository<Board, Long> {

    @Query("SELECT b FROM Board b ORDER BY b.boardId DESC")
    List<Board> findAllOrderByBoardIdDesc();
}
