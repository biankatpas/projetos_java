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

        int newX = ((0 * direction.getX()) + (-1 * direction.getY()));
        int newY = ((1 * direction.getX() + 0 * direction.getY()));

        direction.setX(newX);
        direction.setY(newY);

    }

    public void turnLeft() {

        int newX = ((0 * direction.getX()) + (1 * direction.getY()));
        int newY = ((-1 * direction.getX()) + (0 * direction.getY()));

        direction.setX(newX);
        direction.setY(newY);

    }

    public void move(int step) {
        int moveInX = direction.getX() * step;
        int moveInY = direction.getY() * step;

        position.setX(position.getX() + moveInX);
        position.setY(position.getY() + moveInY);

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
