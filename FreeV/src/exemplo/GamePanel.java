package exemplo;

import java.awt.Graphics;
import java.awt.Color;
import java.awt.Graphics2D;
import javax.swing.JPanel;

/**
 *
 * @author biankatpas
 */
public class GamePanel extends JPanel {

    @Override
    public void paint(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        g2d.setColor(Color.red);
        g2d.fillRect(10, 10, 30, 30);
    }
}
