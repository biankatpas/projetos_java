package turtle;

/**
 *
 * @author biankatpas
 */
public class TurtleBoardControl {

    private Turtle turtle;
    private Board board;

    public TurtleBoardControl(Turtle turtle, Board board) {
        this.turtle = turtle;
        this.board = board;
    }

    public void moveTurtle(int step) {
        if (turtle.pen()) {
            writeMove(step);
        } else {
            noWriteMove(step);
        }
    }

    public void turnLeftTurtle() {
        turtle.turnLeft();
    }

    public void turnRightTurtle() {
        turtle.turnRight();
    }

    public void write(boolean status) {
        turtle.pen(status);
    }

    public void printBoard() {
        board.print();
    }

    private void writeMove(int step) {
        Point direction = new Point(turtle.getDirection().getX(), turtle.getDirection().getY());
        Point posTurtle = new Point(turtle.getPosition().getX(), turtle.getPosition().getY());

        step = checkOutOfBoard(posTurtle, direction, step);

        for (int i = 0; i < step; i++) {

            if (direction.getX() == 1) {
                board.write(posTurtle.getX() + i, posTurtle.getY());
            }
            if (direction.getX() == -1) {
                board.write(posTurtle.getX() - i, posTurtle.getY());
            }
            if (direction.getY() == 1) {
                board.write(posTurtle.getX(), posTurtle.getY() + i);
            }
            if (direction.getY() == -1) {
                board.write(posTurtle.getX(), posTurtle.getY() - i);
            }
        }

        turtle.move(step);

    }

    private void noWriteMove(int step) {
        Point direction = new Point(turtle.getDirection().getX(), turtle.getDirection().getY());
        Point posTurtle = new Point(turtle.getPosition().getX(), turtle.getPosition().getY());
        step = checkOutOfBoard(posTurtle, direction, step);
        turtle.move(step);

    }

    private int checkOutOfBoard(Point turtlePosition, Point turtleDirection, int step) {

        if (turtleDirection.getX() == 1) {
            if (turtlePosition.getX() + step > board.size()) {
                return 0;
            }
        }
        if (turtleDirection.getX() == -1) {
            if (turtlePosition.getX() - step < 0) {
                return 0;
            }
        }
        if (turtleDirection.getY() == 1) {
            if (turtlePosition.getY() + step > board.size()) {
                return 0;
            }

        }
        if (turtleDirection.getY() == -1) {
            if (turtlePosition.getY() - step < 0) {
                return 0;
            }
        }

        return step;
    }

}
