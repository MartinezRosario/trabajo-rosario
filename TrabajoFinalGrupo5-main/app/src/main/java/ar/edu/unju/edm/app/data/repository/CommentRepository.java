package ar.edu.unju.edm.app.data.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import ar.edu.unju.edm.app.domain.model.Comment;

import java.util.List;

public interface CommentRepository extends CrudRepository<Comment, Integer> {

    List<Comment> findByPointID(Integer ID);

}