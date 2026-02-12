package com.sparta.memo.repository;

import com.sparta.memo.entity.Memo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


public interface MemoRepository extends JpaRepository<Memo, Long> {
    List<Memo> findAllByOrderByModifiedAtDesc();//ModifiedAt desc 정렬해서 전체를 내보낼거다.
    //List<Memo> findAllByUsername(String username); // 해당 유저네임이 작섣한 내용 전체 보내
}
