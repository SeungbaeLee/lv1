package com.spring.lv1.mapper;

import com.spring.lv1.dto.BoardDto;
import com.spring.lv1.entity.Board;
import org.mapstruct.Mapper;

import java.util.List;

//필요없음. 공부 및 피드백용
@Mapper(componentModel = "spring")
public interface BoardMapper {

    Board boardPostToBoard(BoardDto.Post post);

    Board boardPatchToBoard(BoardDto.Patch patch);

    BoardDto.Response boardToResponse(Board board);

    List<BoardDto.Response> boardsToResponseDto(List<Board> boards);
}