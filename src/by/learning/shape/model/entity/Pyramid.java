package by.learning.shape.model.entity;


public class Pyramid extends Figure {

    private Point height;
    private Square base;

    public Pyramid(Point height, Square base) {
        this.height = height;
        this.base = base;
    }

    public Point getHeight() {
        return height;
    }

    public void setHeight(Point height) {
        this.height = height;
    }

    public Square getBase() {
        return base;
    }

    public void setBase(Square base) {
        this.base = base;
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
