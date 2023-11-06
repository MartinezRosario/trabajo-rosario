package ar.edu.unju.edm.app.domain.model;

import org.springframework.stereotype.Component;

import javax.persistence.*;

@Component
@Entity
public class Review {

}
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer ID;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "fk_user")
    private User user;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "fk_point")
    private Point point;
    private Integer review;

    public Review() {}

    public Review(Integer ID, User user, Point point, Integer review) {
        this.ID = ID;
        this.user = user;
        this.point = point;
        this.review = review;
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

    public Integer getReview() {
        return review;
    }

    public void setReview(Integer review) {
        this.review = review;
    }

}