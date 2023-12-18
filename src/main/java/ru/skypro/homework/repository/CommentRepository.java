package ru.skypro.homework.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import ru.skypro.homework.entity.Comment;

import java.util.List;

public interface CommentRepository extends JpaRepository<Comment, Integer> {
    @Query( value = "select * from comments where adid = :adid", nativeQuery = true)
    List<Comment> getCommentByAdId(@Param("adid")Integer adId);
}
