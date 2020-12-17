package by.learning.shape.reader;

import by.learning.shape.exception.ReaderException;
import by.learning.shape.validator.FileValidator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

public class FigureReader {

    private static final Logger logger = LogManager.getLogger(FigureReader.class);

    private static final String DEFAULT_PATH = "resources\\data\\correctPyramid.txt";

    public List<String> readFile(String path) throws ReaderException {
        List<String> result;
        if (!FileValidator.isFileValid(path)) {
            path = DEFAULT_PATH;
        }
        try (FileReader reader = new FileReader(path)) {
            BufferedReader bufferedReader = new BufferedReader(reader);
            result = bufferedReader.lines().collect(Collectors.toList());
        } catch (IOException e) {
            logger.error("Can`t read file", e);
            throw new ReaderException(e);
        }
        return result;
    }

}
