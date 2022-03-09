package org.example.case3FurkanYabanci.repository;

import org.example.case3FurkanYabanci.model.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Long> {

    List<Comment> getCommentByUser_Id(long userId);
    List<Comment> getCommentByProduct_Id(long productId);
}
