package ar.edu.unju.edm.app.data.source;

import ar.edu.unju.edm.app.data.repository.PointRepository;
import ar.edu.unju.edm.app.domain.model.Point;
import ar.edu.unju.edm.app.domain.services.AppService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AppServiceImpl implements AppService {

    private final PointRepository POINT_DATABASE;

    public AppServiceImpl(PointRepository POINT_DATABASE) {
        this.POINT_DATABASE = POINT_DATABASE;
    }

    @Override
    public List<Point> getPointList() {
        return POINT_DATABASE.findAllByState(true);
    }

}