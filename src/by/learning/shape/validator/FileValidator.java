package by.learning.shape.validator;

import by.learning.shape.exception.ReaderException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FileValidator {

    private static final Logger logger = LogManager.getLogger(FileValidator.class);

    public static boolean isFileValid(String path) throws ReaderException {
        Path filePath = Paths.get(path);
        boolean fileExist = Files.exists(filePath);
        boolean isEmpty;
        try {
            long size = Files.size(filePath);
            isEmpty = size > 0;
        } catch (IOException e) {
            logger.error("Can`t read file", e);
            throw new ReaderException(e);
        }
        return (isEmpty && fileExist);
    }
}
