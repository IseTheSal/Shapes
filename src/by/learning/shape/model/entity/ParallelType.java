package by.learning.shape.model.entity;

public enum ParallelType {
    NOT_PARALLEL(0),
    OXY(1),
    OXZ(2),
    OZY(3);

    private final int value;

    ParallelType(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
