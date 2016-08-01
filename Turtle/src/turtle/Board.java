package turtle;

/**
 *
 * @author biankatpas
 */
public class Board {

    private int _board[][];

    public Board(int size) {
        _board = new int[size][size];
    }

    public void write(int row, int column) {
        _board[row][column] = 1;

    }

    public void print() {

        for (int i = 0; i < _board.length + 2; ++i) {
            System.out.print("#");
        }

        System.out.println();

        for (int i = 0; i < _board.length; ++i) {
            for (int j = 0; j < _board.length; ++j) {

                if (j == 0) {
                    System.out.print("#");
                }

                if (_board[i][j] == 1) {
                    System.out.print("*");
                } else {
                    System.out.print(" ");
                }
            }

            System.out.println("#");
        }
        for (int i = 0; i < _board.length + 2; ++i) {
            System.out.print("#");
        }
        System.out.println();
    }

}
