package com.example.myProject06.repository;

import com.example.myProject06.entity.Board;
import com.example.myProject06.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;


public interface BoardRepository extends JpaRepository<Board, Integer> {

    //특성 작성자가 쓴 게시물 삭제 메서드
    @Modifying
    @Transactional
    @Query("delete from Board b where b.writer = :member")
    public void deleteWriter(@Param("member")Member member);

}
