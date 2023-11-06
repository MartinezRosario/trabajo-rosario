package ar.edu.unju.edm.app.domain.services;

import ar.edu.unju.edm.app.domain.model.Comment;
import ar.edu.unju.edm.app.domain.model.Point;
import ar.edu.unju.edm.app.domain.model.Review;
import ar.edu.unju.edm.app.domain.model.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {

    public User getUser(Integer ID);
    public User getUser(String email);
    public void editUser(User user);
    public void deleteUser(Integer ID);
    public Point getPoint(Integer ID);
    public void addComment(Comment comment);
    public void addReview(Review review);

}