package exemplo;

/**
 *
 * @author biankatpas
 */
public abstract class GameContext {

    public GameContext(int h, int w) {
        _h = h;
        _w = w;
    }

    public abstract void draw();

    private final int _w;
    private final int _h;
}
