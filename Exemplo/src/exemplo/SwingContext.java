package exemplo;

import javax.swing.JFrame;

/**
 *
 * @author biankatpas
 */
public class SwingContext extends GameContext {

    private JFrame _frame;
    private GamePanel _gamePanel;

    public SwingContext(int x, int y) {
        super(x, y);

        _frame = new JFrame("FreeV");
        _frame.add(new GamePanel());
        _frame.setVisible(true);
        _frame.setSize(x, y);
        _frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        _frame.setResizable(false);
        _frame.setFocusable(true);
        _frame.requestFocus();

    }

    public void draw() {
        _frame.repaint();
    }

    private void _wait() {
        try {
            Thread.sleep(0);
        } catch (InterruptedException e) {

        }
    }

    @Override
    public void draw(DisplayFile df) {
        for (int i = 0; i < df.layerSize(); i++) {
            
        }
    }

    @Override
    public int loadImage(String path) {
        return _gamePanel.loadImage(path);
    }

}
