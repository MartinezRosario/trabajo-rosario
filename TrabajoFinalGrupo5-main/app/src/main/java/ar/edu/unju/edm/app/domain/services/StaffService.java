package ar.edu.unju.edm.app.domain.services;

import ar.edu.unju.edm.app.domain.model.Point;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface StaffService {

    public List<Point> getPointList();
    public Point getPoint(Integer ID);
    public void addPoint(Point point);
    public void editPoint(Point point);
    public void deletePoint(Integer ID);

}