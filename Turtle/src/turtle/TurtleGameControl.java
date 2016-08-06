package turtle;

/**
 *
 * @author biankatpas
 */
public class TurtleGameControl {

    private final int END = 9;
    private final int PEN_UP = 1;
    private final int PEN_DOWN = 2;
    private final int LEFT = 3;
    private final int RIGHT = 4;
    private final int WALK = 5;
    private final int PRINT = 6;
    private final int SIZE = 18;
    private TurtleBoardControl tbc;

    public TurtleGameControl() {

    }

    public void start() {

        tbc = new TurtleBoardControl(new Turtle(new Point(1, 1), new Point(1, 0)), new Board(SIZE));
        int option;

        do {
            option = options();
            switch (option) {
                case PEN_UP:
                    tbc.write(false);
                    break;
                case PEN_DOWN:
                    tbc.write(true);
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
                    tbc.printBoard();
                    //tbc.printTurtle();
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
