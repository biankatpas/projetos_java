package exemplo;

/**
 *
 * @author biankatpas
 */
public abstract class GameContext {

    private int _w;
    private int _h;

    public GameContext(int h, int w) {
        _h = h;
        _w = w;
    }

    public abstract void draw(DisplayFile df);

    public abstract int loadImage(String path);
}
