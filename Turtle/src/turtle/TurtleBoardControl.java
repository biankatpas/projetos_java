package turtle;

/**
 *
 * @author biankatpas
 */
public class TurtleBoardControl {

    private Turtle turtle;
    private Board board;

    public TurtleBoardControl() {
    }

    public TurtleBoardControl(Turtle turtle, Board board) {
        this.turtle = turtle;
        this.board = board;
    }

    public void moveTurtle(int step) {
        turtle.move(step-1);
        write(turtle.pen(), step-1);

    }

    public void turnLeftTurtle() {
        turtle.turnLeft();
    }

    public void turnRightTurtle() {
        turtle.turnRight();
    }

    private void write(boolean status, int step) {
        if (status) {
            writeMove(step);
        } else {
            noWriteMove(step);
        }
    }

    public void print() {

    }

    private void writeMove(int step) {
        if (turtle.getPosition().getX() == turtle.getDirection().getX()) {
            if (turtle.getPosition().getY() < turtle.getDirection().getY()) {
                algumaSoma(turtle.getPosition().getX(), turtle.getPosition().getY(), step, "y");
            } else if (turtle.getPosition().getY() > turtle.getDirection().getY()) {
                algumaDiminui(turtle.getPosition().getX(), turtle.getPosition().getY(), step, "y");

            }
        } else if (turtle.getPosition().getY() == turtle.getDirection().getY()) {
            if (turtle.getPosition().getX() < turtle.getDirection().getX()) {
                algumaSoma(turtle.getPosition().getY(), turtle.getPosition().getX(), step, "x");
            } else if (turtle.getPosition().getX() > turtle.getDirection().getX()) {
                algumaDiminui(turtle.getPosition().getY(), turtle.getPosition().getX(), step, "x");
            }

        }
    }

    private void noWriteMove(int step) {
        turtle.move(step);
    }

    private void checkOutOfBoard(Point turtlePosition) {
        

    }

    private void algumaSoma(int posicao, int analisado, int step, String letra) {
        int aux = analisado;
        for (int i = aux; i <= aux + step; i++) {
            if (letra.equals("y")) {
                board.write(posicao, i);
            } else {
                board.write(i, posicao);
            }
        }

    }

    private void algumaDiminui(int posicao, int analisado, int step, String letra) {

        int aux = analisado;
        for (int i = aux; i >= aux - step; i--) {
            if (letra.equals("y")) {
                board.write(posicao, i);
            } else {
                board.write(i, posicao);
            }
        }
    }
}
