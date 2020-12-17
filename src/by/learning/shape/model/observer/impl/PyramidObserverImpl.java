package by.learning.shape.model.observer.impl;

import by.learning.shape.exception.ServiceException;
import by.learning.shape.model.entity.Point;
import by.learning.shape.model.entity.Square;
import by.learning.shape.model.entity.pyramid.Pyramid;
import by.learning.shape.model.entity.pyramid.PyramidProperty;
import by.learning.shape.model.observer.CustomObserver;
import by.learning.shape.model.observer.PyramidEvent;
import by.learning.shape.model.service.impl.PyramidServiceImpl;
import by.learning.shape.model.warehouse.PyramidPropertyWarehouse;
import by.learning.shape.validator.PyramidValidator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class PyramidObserverImpl implements CustomObserver {

    private static final Logger logger = LogManager.getLogger(PyramidObserverImpl.class);

    @Override
    public void parameterChanged(PyramidEvent event) {
        Pyramid pyramid = event.getSource();
        Square pyramidBase = pyramid.getBase();
        Point pointOne = pyramidBase.getPointOne();
        Point pointTwo = pyramidBase.getPointTwo();
        Point pointThree = pyramidBase.getPointThree();
        Point pointFour = pyramidBase.getPointFour();
        Point height = pyramid.getHeight();
        PyramidValidator pyramidValidator = new PyramidValidator();
        if (pyramidValidator.isPyramidValid(pointOne, pointTwo, pointThree, pointFour, height)) {
            PyramidServiceImpl pyramidService = new PyramidServiceImpl();
            try {
                double pyramidVolume = pyramidService.calcPyramidVolume(pyramid);
                double baseArea = pyramidService.calcBaseArea(pyramid);
                PyramidProperty pyramidProperty = new PyramidProperty(pyramidVolume, baseArea);
                PyramidPropertyWarehouse.getWarehouse().put(pyramid.getId(), pyramidProperty);
            } catch (ServiceException e) {
                logger.info("Exception with service", e);
            }
        }
    }

}
