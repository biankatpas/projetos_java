package exemplo;

import java.awt.Graphics;
import java.awt.Graphics2D;
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
        _gamePanel = new GamePanel();
        _frame.add(_gamePanel);
        _frame.setVisible(true);
        _frame.setSize(x, y);
        _frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        _frame.setResizable(false);
        _frame.setFocusable(true);
        _frame.requestFocus();

    }

     private void _wait() {
     try {
     Thread.sleep(100);
     } catch (InterruptedException e) {

     }
     }
    @Override
    public void draw(DisplayFile df) {
       
         _gamePanel.setDisplayFile(df);
        _frame.repaint();
        
       this._wait();
       
       
    }

    @Override
    public int loadImage(String path) {
        return _gamePanel.loadImage(path);
    }

}
