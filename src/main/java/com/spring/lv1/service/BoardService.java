package com.spring.lv1.service;

import com.spring.lv1.dto.BoardDto;
import com.spring.lv1.entity.Board;
import com.spring.lv1.repository.BoardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional
public class BoardService {

    private final BoardRepository boardRepository;
    //create
    public Board createBoard(Board board) {

        Board newBoard = Board.builder()
                .name(board.getName())
                .title(board.getTitle())
                .password(board.getPassword())
                .content(board.getContent())
                .build();
        return boardRepository.save(newBoard);
    }

    //readOne
    public Board readOneBoard(long boardId) {
        Board findBoard = findBoardById(boardId);
        return findBoard;
    }
    //readAll
    public List<Board> readAllBoard() {
        return boardRepository.findAllOrderByBoardIdDesc();
    }

    //update
    public Board updateBoard(long boardId, Board board) {
        Board findBoard = findBoardById(boardId);
        pwIsValid(findBoard.getBoardId(), board.getPassword());
        findBoard.update(board.getTitle(), board.getName(), board.getContent());
        return findBoard;
    }

    //delete
    //비밀번호 검증 필요
    public void deleteBoard(long boardId, BoardDto.Delete board) {
        findBoardById(boardId);
        pwIsValid(boardId, board.getPassword());
        boardRepository.deleteById(boardId);
    }

    private Board findBoardById(long boardId) {
        Optional<Board> optionalBoard = boardRepository.findById(boardId);
        Board findBoard = optionalBoard.orElseThrow(()-> new RuntimeException("게시글을 찾을 수 없습니다."));
        return findBoard;
    }

    private long pwIsValid(long boardId, String password) {
        Optional<Board> optionalBoard = boardRepository.findById(boardId);
        if (optionalBoard.get().getPassword().equals(password)) {
            return optionalBoard.get().getBoardId();
        } else throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
    }
}