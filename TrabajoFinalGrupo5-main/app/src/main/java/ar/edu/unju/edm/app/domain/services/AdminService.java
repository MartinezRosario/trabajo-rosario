package ar.edu.unju.edm.app.domain.services;

import java.util.List;

import ar.edu.unju.edm.app.domain.model.Point;
import ar.edu.unju.edm.app.domain.model.User;
import org.springframework.stereotype.Service;

@Service
public interface AdminService {

    public List<User> getUserList();
    public List<Point> getPointList();

}
