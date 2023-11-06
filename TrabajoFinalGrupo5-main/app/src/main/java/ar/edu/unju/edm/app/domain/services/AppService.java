package ar.edu.unju.edm.app.domain.services;

import ar.edu.unju.edm.app.domain.model.Point;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface AppService {

    public List<Point> getPointList();

}