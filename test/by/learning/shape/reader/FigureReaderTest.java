package by.learning.shape.reader;

import by.learning.shape.exception.ReaderException;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class FigureReaderTest {

    FigureReader figureReader = new FigureReader();
    private static final String PATH = "src\\by\\learning\\shape\\resources\\data\\figures.txt";

    @Test
    public void testReadFile() {
        try {
            List<String> strings = figureReader.readFile(PATH);
            System.out.println(strings);
        } catch (ReaderException e) {
            Assert.fail();
        }
    }
}