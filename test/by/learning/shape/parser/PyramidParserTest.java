package by.learning.shape.parser;

import by.learning.shape.exception.ReaderException;
import by.learning.shape.model.entity.Point;
import by.learning.shape.reader.FigureReader;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class PyramidParserTest {

    PyramidParser pyramidParser = new PyramidParser();
    List<Point> correctPoints;

    final static String PATH = "resources\\data\\correctPyramid.txt";

    @BeforeClass
    public void initCorrectPoints() {
        correctPoints = new ArrayList<>();
        Point pointOne = new Point(2, 0, 1);
        Point pointTwo = new Point(4, 0, 1);
        Point pointThree = new Point(4, 0, 3);
        Point pointFour = new Point(2, 0, 3);
        Point pointHeight = new Point(3, 7, 2);
        correctPoints.add(pointOne);
        correctPoints.add(pointTwo);
        correctPoints.add(pointThree);
        correctPoints.add(pointFour);
        correctPoints.add(pointHeight);
    }

    @Test
    public void testParsePyramid() {
        FigureReader figureReader = new FigureReader();
        try {
            List<String> pointList = figureReader.readFile(PATH);
            String pointString = pointList.get(0);
            List<Point> actual = pyramidParser.parsePyramid(pointString);
            List<Point> expected = correctPoints;
            Assert.assertEquals(actual, expected);
        } catch (ReaderException e) {
            Assert.fail();
        }
    }

    @AfterClass
    public void clearList() {
        correctPoints = null;
    }
}