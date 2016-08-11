package exemplo;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;
import javax.imageio.ImageIO;

/**
 *
 * @author biankatpas
 */
public class ImageKeeper {

    private ArrayList<BufferedImage> _images;

    public ImageKeeper() {
        _images = new ArrayList<>();
    }

    public int loadImage(String path) {
        try {
            BufferedImage img = ImageIO.read(this.getClass().getResourceAsStream(path));
            _images.add(img);

        } catch (IOException e) {
        }
        return _images.size()-1;
    }

    public BufferedImage getImage(int key) {
        return _images.get(key);
    }
}
