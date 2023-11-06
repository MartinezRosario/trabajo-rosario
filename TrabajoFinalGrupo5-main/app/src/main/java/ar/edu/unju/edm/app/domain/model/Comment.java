package ar.edu.unju.edm.app.domain.model;

import org.springframework.stereotype.Component;

import javax.persistence.*;

@Component
@Entity
public class Comment {
 
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer ID;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "fk_user")
    private User user;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "fk_point")
    private Point point;
    private String text;

    public Comment() {}

    public Comment(Integer ID, User user, Point point, String text) {
        this.ID = ID;
        this.user = user;
        this.point = point;
        this.text = text;
    }

    public Integer getID() {
        return ID;
    }

    public void setID(Integer ID) {
        this.ID = ID;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Point getPoint() {
        return point;
    }

    public void setPoint(Point point) {
        this.point = point;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

}