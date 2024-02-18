package com.example.laundry_project.controller;

import com.example.laundry_project.domain.board.Board;
import com.example.laundry_project.domain.board.BoardRequestDto;
import com.example.laundry_project.repository.BoardRepository;
import com.example.laundry_project.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.WebRequest;

import java.util.Optional;

@RequestMapping("board")
@RequiredArgsConstructor
@RestController
public class BoardController {

    private final BoardService boardService;
    private final BoardRepository boardRepository;

    // C

    @PostMapping("write")
    public boolean write(@RequestBody BoardRequestDto boardDto) {
        Board board = new Board(boardDto);
        Board result = boardService.addBoard(board);

        if (result != null) {
            // 리뷰 작성시 order_review_is_written 상태 true update 시키기
            return true;
        } else {
            return false;
        }
    }

    // R
    public Optional<Board> getBoardBySeq(int boardSeq) {
        Optional<Board> board = boardRepository.findById(boardSeq);
        return board;
    }

    // U
    @PutMapping("modify")
    public void updateBoardBySeq(@RequestBody BoardRequestDto boardDto){
        Board board = new Board(boardDto);
        boardService.updateBySeq(board);
    }

    // D
    @DeleteMapping("remove")
    public boolean removeBoardBySeq(WebRequest request, @RequestParam int boardSeq){
        boardService.deleteBySeq(boardSeq);

        Optional<Board> board = getBoardBySeq(boardSeq);
        if(board.isEmpty())
            return true;
        return false;
    }

}
