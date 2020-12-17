package by.learning.shape.parser;

import by.learning.shape.model.entity.Point;
import by.learning.shape.validator.PyramidValidator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

public class PyramidParser {
    private static final Logger logger = LogManager.getLogger(PyramidParser.class);

    private final static String POINT_SPLIT_REGEX = ";";
    private final static String COORDINATES_SPLIT_REGEX = ", ";
    private final static int VALUES_AMOUNT = 4;
    private final static int POINT_COORDINATE_AMOUNT = 3;


    public List<Point> parsePyramid(String pyramidString) {
        List<Point> result = new ArrayList<>();
        String[] pointList = pyramidString.split(POINT_SPLIT_REGEX);
        if (pointList.length == VALUES_AMOUNT) {
            PyramidValidator pyramidValidator = new PyramidValidator();
            List<Point> points = new ArrayList<>();
            boolean isPointsValid = true;
            int i = 0;
            while (i < pointList.length) {
                String[] pointString = pointList[i].split(COORDINATES_SPLIT_REGEX);
                if (pointString.length != POINT_COORDINATE_AMOUNT) {
                    isPointsValid = false;
                    logger.warn("Invalid point");
                    break;
                }
                String x = pointString[0];
                String y = pointString[1];
                String z = pointString[2];
                if (!pyramidValidator.isPointValid(x, y, z)) {
                    isPointsValid = false;
                    logger.warn("Invalid points");
                    break;
                }
                Point point = new Point(Double.parseDouble(x), Double.parseDouble(y), Double.parseDouble(z));
                points.add(point);
                i++;
            }

            if (isPointsValid) {
                result = new ArrayList<>(points);
            }
        } else {
            logger.warn("Invalid amount of points");
        }
        return result;
    }
}
