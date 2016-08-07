package turtle;

/**
 *
 * @author biankatpas
 */
public class Turtle {

    private Point position;
    private Point direction;
    private boolean pen;

    public Turtle() {
        position = new Point();
        direction = new Point();
    }

    public Turtle(Point initialPosition, Point initialDirection) {
        position = initialPosition;
        direction = initialDirection;
    }

    public Point getPosition() {
        return position;
    }

    public void setX(int x) {
        position.setX(x);
    }

    public void setY(int y) {
        position.setY(y);
    }

    public Point getDirection() {
        return direction;
    }

    public void turnRight() {
        direction.setX((0 * direction.getX()) + (-1 * direction.getY()));
        direction.setY((1 * direction.getX() + 0 * direction.getY()));
    }

    public void turnLeft() {
        direction.setX((0 * direction.getX()) + (1 * direction.getY()));
        direction.setY((-1 * direction.getX()) + (0 * direction.getY()));
    }

    public void move(int step) {
        position.sumPoint(direction.multNumber(step));
    }

    public boolean pen() {
        return pen;
    }

    public void pen(boolean status) {
        pen = status;
    }

    public void print() {
        position.print();
    }
}
