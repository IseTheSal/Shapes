package by.learning.shape.model.entity;

public class Square extends Figure {

    private Point pointOne;
    private Point pointTwo;
    private Point pointThree;
    private Point pointFour;

    public Square(Point upperLeftCorner, Point upperRightCorner, Point bottomLeftCorner, Point bottomRightCorner) {
        this.pointOne = upperLeftCorner;
        this.pointTwo = upperRightCorner;
        this.pointThree = bottomLeftCorner;
        this.pointFour = bottomRightCorner;
    }

    public Point getPointOne() {
        return pointOne;
    }

    public void setPointOne(Point pointOne) {
        this.pointOne = pointOne;
    }

    public Point getPointTwo() {
        return pointTwo;
    }

    public void setPointTwo(Point pointTwo) {
        this.pointTwo = pointTwo;
    }


    public Point getPointThree() {
        return pointThree;
    }

    public void setPointThree(Point pointThree) {
        this.pointThree = pointThree;
    }

    public Point getPointFour() {
        return pointFour;
    }

    public void setPointFour(Point pointFour) {
        this.pointFour = pointFour;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        Square square = (Square) o;

        if (pointOne != null ? !pointOne.equals(square.pointOne) : square.pointOne != null)
            return false;
        if (pointTwo != null ? !pointTwo.equals(square.pointTwo) : square.pointTwo != null)
            return false;
        if (pointThree != null ? !pointThree.equals(square.pointThree) : square.pointThree != null)
            return false;
        return pointFour != null ? pointFour.equals(square.pointFour) : square.pointFour == null;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (pointOne != null ? pointOne.hashCode() : 0);
        result = 31 * result + (pointTwo != null ? pointTwo.hashCode() : 0);
        result = 31 * result + (pointThree != null ? pointThree.hashCode() : 0);
        result = 31 * result + (pointFour != null ? pointFour.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Square{");
        sb.append("upperLeftCorner=").append(pointOne);
        sb.append(", upperRightCorner=").append(pointTwo);
        sb.append(", bottomLeftCorner=").append(pointThree);
        sb.append(", bottomRightCorner=").append(pointFour);
        sb.append('}');
        return sb.toString();
    }
}
