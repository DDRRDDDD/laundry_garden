package com.example.laundry_project.repository;

import com.example.laundry_project.domain.board.Board;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;

public interface BoardRepository extends JpaRepository<Board, Integer> {

    public Board findBoardByBoardSeq(int boardSeq);

    @Modifying
    @Transactional
    @Query(nativeQuery = true, value = "UPDATE board SET board_view_count = (board_view_count+1) WHERE (board_seq = ?1)")
    public void updateBoardByBoardViewCount(int boardSeq);


}
