package by.learning.shape.model.observer;

public interface Observable {
    void attach(CustomObserver observer);

    void detach(CustomObserver observer);

    void notifyObservers();
}
