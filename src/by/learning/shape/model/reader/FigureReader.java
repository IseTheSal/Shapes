package by.learning.shape.model.reader;

import by.learning.shape.exception.ReaderException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

public class FigureReader {

    private static final Logger logger = LogManager.getLogger(FigureReader.class);

    public List<String> readFile(String path) throws ReaderException {
        List<String> result;
        try (FileReader reader = new FileReader(path)) {
            BufferedReader bufferedReader = new BufferedReader(reader);
            result = bufferedReader.lines().collect(Collectors.toList());
        } catch (IOException e) {
            logger.error("Cant read file", e);
            throw new ReaderException(e);
        }
        return result;
    }

}
