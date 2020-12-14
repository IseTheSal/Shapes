package by.learning.shape.util.generator;

public class IdGenerator {

    private static long figureId = 0;

    public static long getFigureId() {
        return figureId++;
    }
}
