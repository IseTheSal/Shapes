package by.learning.shape.model.service;

import by.learning.shape.exception.ServiceException;
import by.learning.shape.model.entity.Point;
import by.learning.shape.model.entity.pyramid.Pyramid;

public interface PyramidService {

    double calcSideLength(Point p1, Point p2);

    double calcBaseArea(Pyramid pyramid);

    double calcHeightLength(Pyramid pyramid) throws ServiceException;

    double calcTriangleArea(Point point1, Point point2, Point point3);

    double calcPyramidSurfaceArea(Pyramid pyramid);

    double calcPyramidVolume(Pyramid pyramid) throws ServiceException;

    boolean isBaseOnCoordinatePlane(Pyramid pyramid);
}
