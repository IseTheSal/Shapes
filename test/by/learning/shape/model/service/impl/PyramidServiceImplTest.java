package by.learning.shape.model.service.impl;

import by.learning.shape.exception.ServiceException;
import by.learning.shape.model.entity.Point;
import by.learning.shape.model.entity.Pyramid;
import by.learning.shape.model.entity.Square;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class PyramidServiceImplTest {

    PyramidServiceImpl pyramidService = new PyramidServiceImpl();

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
    public void testCalcSideLength() {
        double actual = pyramidService.calcSideLength(point1, point2);
        double expected = 2;
        Assert.assertEquals(actual, expected);
    }

    @Test
    public void testCalcBaseArea() {
        double actual = pyramidService.calcBaseArea(pyramid);
        double expected = 4;
        Assert.assertEquals(actual, expected);
    }

    @Test
    public void testCalcHeightLength() {
        double height = 0;
        try {
            height = pyramidService.calcHeightLength(pyramid);
            System.out.println(height);
        } catch (ServiceException e) {
            Assert.fail();
        }
        double actual = height;
        double expected = 7;
        Assert.assertEquals(actual, expected);
    }

    @Test
    public void testCalcTriangleArea() {
        double actual = pyramidService.calcTriangleArea(point1, point2, height);
        double expected = 7.0710678118654755;
        Assert.assertEquals(actual, expected);
    }

    @Test
    public void testCalcPyramidSurfaceArea() {
        double actual = pyramidService.calcPyramidSurfaceArea(pyramid);
        double expected = 32.2842712474619;
        Assert.assertEquals(actual, expected);
    }

    @Test
    public void testCalcPyramidVolume() {
        double actual = 0;
        try {
            actual = pyramidService.calcPyramidVolume(pyramid);
        } catch (ServiceException e) {
            Assert.fail();
        }
        double expected = 9.333333333333334;
        Assert.assertEquals(actual, expected);
    }


    @Test
    public void testIsBaseOnCoordinatePlane() {
        boolean condition = pyramidService.isBaseOnCoordinatePlane(pyramid);
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