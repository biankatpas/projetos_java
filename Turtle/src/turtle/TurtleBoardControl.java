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

    public void printTurtle() {
        //implementar

    }

    private void writeMove(int step) {
        Point direction = new Point(turtle.getDirection().getX(), turtle.getDirection().getY());
        Point posTurtle = new Point(turtle.getPosition().getX(), turtle.getPosition().getY());

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
        turtle.move(step);
    }

    private void checkOutOfBoard(Point turtlePosition) {
        //implementar
    }

}
