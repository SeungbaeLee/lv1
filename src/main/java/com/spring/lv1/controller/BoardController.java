package com.spring.lv1.controller;

import com.spring.lv1.dto.BoardDto;
import com.spring.lv1.entity.Board;
import com.spring.lv1.mapper.BoardMapper;
import com.spring.lv1.service.BoardService;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/board")
@AllArgsConstructor
public class BoardController {

    private final BoardService boardService;
    private final BoardMapper boardMapper;

    //create
    @PostMapping
    public ResponseEntity createBoard(@RequestBody BoardDto.Post post) {
        Board board = boardMapper.boardPostToBoard(post);
        Board createdBoard = boardService.createBoard(board);
        BoardDto.Response response = boardMapper.boardToResponse(createdBoard);
        return new ResponseEntity(response, HttpStatus.OK);
    }

    //readOne
    @GetMapping("/{boardId}")
    public ResponseEntity readOneBoard(@PathVariable("boardId") long boardId) {
        Board board = boardService.readOneBoard(boardId);
        return new ResponseEntity(boardMapper.boardToResponse(board), HttpStatus.OK);
    }

    //readAll
    @GetMapping
    public ResponseEntity readAllBoard() {
        List<Board> boards = boardService.readAllBoard();
        List<BoardDto.Response> responses = boardMapper.boardsToResponseDto(boards);
        return new ResponseEntity<>(responses, HttpStatus.OK);
    }

    //update
    @PatchMapping("/{boardId}")
    public ResponseEntity updateBoard(@PathVariable("boardId") long boardId,
                                      @RequestBody BoardDto.Patch patch) {
        Board board = boardMapper.boardPatchToBoard(patch);
        Board updatedBoard = boardService.updateBoard(boardId, board);
        BoardDto.Response response = boardMapper.boardToResponse(updatedBoard);
        return new ResponseEntity(response, HttpStatus.OK);
    }

    //delete
    @DeleteMapping("/{boardId}")
    public ResponseEntity deleteBoard(@PathVariable("boardId") long boardId,
                                      @RequestBody BoardDto.Delete delete) {
        boardService.deleteBoard(boardId, delete);
        return new ResponseEntity(HttpStatus.OK);
    }
}
