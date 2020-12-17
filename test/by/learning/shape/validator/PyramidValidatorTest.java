package by.learning.shape.validator;

import by.learning.shape.model.entity.Point;
import by.learning.shape.model.entity.pyramid.Pyramid;
import by.learning.shape.model.entity.Square;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class PyramidValidatorTest {

    PyramidValidator pyramidValidator = new PyramidValidator();

    Point point1;
    Point point2;
    Point point3;
    Point point4;
    Point height;
    Square square;
    Pyramid pyramid;


    @BeforeTest
    public void fillPoints() {
        point1 = new Point(2, 0, 1);
        point2 = new Point(4, 0, 1);
        point3 = new Point(4, 0, 3);
        point4 = new Point(2, 0, 3);
        height = new Point(3, 7, 2);
        square = new Square(point1, point2, point3, point4);
        pyramid = new Pyramid(height, square);
    }

    @Test
    public void testIsSquareValid() {
        boolean condition = pyramidValidator.isSquareValid(point1, point2, point3, point4);
        Assert.assertTrue(condition);
    }

    @Test
    public void testIsHeightCorrect() {
        boolean heightCorrect = pyramidValidator.isHeightCorrect(point1, point2, point3, point4, height);
        Assert.assertTrue(heightCorrect);
    }

    @Test
    public void testIsPyramidParallelToAxis() {
        boolean condition = pyramidValidator.isPyramidParallelToAxis(point1, point2, point3, point4);
        Assert.assertTrue(condition);
    }

    @AfterTest
    public void fillNull() {
        point1 = null;
        point2 = null;
        point3 = null;
        point4 = null;
        height = null;
        square = null;
        pyramid = null;
    }
}