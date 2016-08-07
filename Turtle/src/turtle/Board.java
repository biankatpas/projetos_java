package turtle;

/**
 *
 * @author biankatpas
 */
public class Board {

    private int _board[][];
    private final int MOLDURA = 2;

    public Board(int size) {
        _board = new int[size + MOLDURA][size + MOLDURA];
    }

    public void write(int row, int column) {
        _board[column][row] = 1;
    }

    public void print() {

        for (int i = 0; i < _board.length + MOLDURA; ++i) {
            System.out.print("*");
        }

        System.out.println();

        for (int i = 0; i < _board.length; ++i) {
            for (int j = 0; j < _board.length; ++j) {

                if (j == 0) {
                    System.out.print("*");
                }

                if (_board[i][j] == 1) {
                    System.out.print(".");
                } else {
                    System.out.print(" ");
                }
            }

            System.out.println("*");
        }
        for (int i = 0; i < _board.length + MOLDURA; ++i) {
            System.out.print("*");
        }
        System.out.println();
    }

    public int size() {
        return _board.length;
    }

}
