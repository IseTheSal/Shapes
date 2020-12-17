package by.learning.shape.model.entity.pyramid;


import by.learning.shape.model.entity.Figure;
import by.learning.shape.model.entity.Point;
import by.learning.shape.model.entity.Square;
import by.learning.shape.model.observer.CustomObserver;
import by.learning.shape.model.observer.Observable;
import by.learning.shape.model.observer.PyramidEvent;

import java.util.ArrayList;
import java.util.List;

public class Pyramid extends Figure implements Observable {

    private Point height;
    private Square base;
    private List<CustomObserver> observers = new ArrayList<>();

    public Pyramid(Point height, Square base) {
        this.height = height;
        this.base = base;
    }

    public Point getHeight() {
        return height;
    }

    public void setHeight(Point height) {
        this.height = height;
        notifyObservers();
    }

    public Square getBase() {
        return base;
    }

    public void setBase(Square base) {
        this.base = base;
        notifyObservers();
    }


    @Override
    public void attach(CustomObserver observer) {
        if (observer != null) {
            observers.add(observer);
        }
    }

    @Override
    public void detach(CustomObserver observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers() {
        PyramidEvent pyramidEvent = new PyramidEvent(this);
        for (CustomObserver observer : observers) {
            observer.parameterChanged(pyramidEvent);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        Pyramid pyramid = (Pyramid) o;

        if (height != null ? !height.equals(pyramid.height) : pyramid.height != null) return false;
        return base != null ? base.equals(pyramid.base) : pyramid.base == null;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (height != null ? height.hashCode() : 0);
        result = 31 * result + (base != null ? base.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Pyramid{");
        sb.append("height=").append(height);
        sb.append(", base=").append(base);
        sb.append('}');
        return sb.toString();
    }

}
