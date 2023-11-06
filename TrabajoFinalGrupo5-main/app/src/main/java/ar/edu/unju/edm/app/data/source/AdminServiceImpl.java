package ar.edu.unju.edm.app.data.source;

import ar.edu.unju.edm.app.data.repository.PointRepository;
import ar.edu.unju.edm.app.data.repository.UserRepository;
import ar.edu.unju.edm.app.domain.model.Point;
import ar.edu.unju.edm.app.domain.model.User;
import ar.edu.unju.edm.app.domain.services.AdminService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminServiceImpl implements AdminService {

    private final UserRepository USER_DATABASE;
    private final PointRepository POINT_DATABASE;

    public AdminServiceImpl(UserRepository USER_DATABASE, PointRepository POINT_DATABASE) {
        this.USER_DATABASE = USER_DATABASE;
        this.POINT_DATABASE = POINT_DATABASE;
    }

    @Override
    public List<User> getUserList() {
        return USER_DATABASE.findAllByState(true);
    }

    @Override
    public List<Point> getPointList() {
        return POINT_DATABASE.findAllByState(true);
    }

}