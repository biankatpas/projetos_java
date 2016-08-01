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

    public Turtle(Point initialPosition) {
        position = new Point();
        direction = new Point();
        position.setX(initialPosition.getX());
        position.setY(initialPosition.getY());
        direction.setX(initialPosition.getX());
        direction.setY(initialPosition.getY() + 1);

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

    public void turnLeft() {
        int X = 0, Y = 0;

        X = ((0 * direction.getX()) + (-1 * direction.getY()));
        Y = ((1 * direction.getX()) + (0 * direction.getY()));

        direction.setX(X);
        direction.setY(Y);

    }

    public void turnRight() {
        int newX = 0;
        int newY = 0;

        newX = ((0 * direction.getX()) + (1 * direction.getY()));
        newY = ((-1 * direction.getX()) + (0 * direction.getY()));

        direction.setX(newX);
        direction.setY(newY);

    }

    public void move(int step) {
        if (direction.getX() == position.getX()) {
            moveY(step);
        } else if (direction.getY() == position.getY()) {
            moveX(step);
        }
    }

    private void moveY(int step) {
        if (position.getY() < direction.getY()) {
            position.setY(position.getY() + step);
            direction.setY(position.getY() + 1);
        } else {
            position.setY(position.getY() - step);
            direction.setY(position.getY() - 1);
        }
    }

    private void moveX(int step) {

        if (position.getX() < direction.getX()) {
            position.setX(position.getX() + step);
            direction.setX(position.getX() + 1);
        } else {
            position.setX(position.getX() - step);
            direction.setX(position.getX() - 1);
        }
    }

    public boolean pen() {
        return pen;
    }

    public void pen(boolean status) {
        pen = status;
    }

}
