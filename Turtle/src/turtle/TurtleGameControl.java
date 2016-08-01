package turtle;

/**
 *
 * @author biankatpas
 */
public class TurtleGameControl {

    TurtleBoardControl tbc;
    private final int END = 9;
    private final int PEN_UP = 1;
    private final int PEN_DOWN = 2;
    private final int LEFT = 3;
    private final int RIGHT = 4;
    private final int WALK = 5;
    private final int PRINT = 6;

    public TurtleGameControl() {

    }

    public void start() {

        Board board = new Board(20);
        Turtle turtle = new Turtle(new Point(8, 6));
        tbc = new TurtleBoardControl(turtle, board);
        int option;

        do {
            option = options();
            switch (option) {
                case PEN_UP:
                    turtle.pen(false);
                    break;
                case PEN_DOWN:
                    turtle.pen(true);
                    break;
                case LEFT:
                    tbc.turnLeftTurtle();
                    break;
                case RIGHT:
                    tbc.turnRightTurtle();
                    break;
                case WALK:
                    tbc.moveTurtle(new Console().readInteger());
                    break;
                case PRINT:
                    board.print();
                    break;
                case END:
                    break;
                default:
                    System.out.println("Informe um comando valido");
            }

        } while (option != END);

    }

    private int options() {
        System.out.println("Comandos: \n1 - caneta cima");
        System.out.println("2 - caneta baixo");
        System.out.println("3 - virar a esq");
        System.out.println("4 - virar a dir");
        System.out.println("5,x - mover x passos");
        System.out.println("6 - imprimir tabuleiro");
        System.out.println("9 - encerrar");
        System.out.println();

        return new Console().readInteger();
    }
}
