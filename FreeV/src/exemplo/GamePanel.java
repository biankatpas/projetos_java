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

    private ImageKeeper _imageKeeper;
    private DisplayFile _df;

    public GamePanel() {
        _imageKeeper = new ImageKeeper();
        _df = new DisplayFile(1);

    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        Graphics2D g2d = (Graphics2D) g;
        //g2d.setColor(Color.red);
        // g2d.fillRect(10, 10, 30, 30);

        for (int i = 0; i < _df.layerSize(); i++) {
            for (int j = 0; j < _df.size(i); j++) {
                System.out.println(j + " " + i );
                g.drawImage(_imageKeeper.getImage(_df.get(j, i).getImage()), 0, 0, null);
            }
        }

    }

    public void setDisplayFile(DisplayFile df) {
        _df = df;
    }

    public int loadImage(String path) {
        return _imageKeeper.loadImage(path);
    }

}
