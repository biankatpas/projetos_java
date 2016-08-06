package exemplo;

/**
 *
 * @author biankatpas
 */
public class GameEngine {

    public GameEngine() {
        _inGame = true;
        _ctx = new SwingContext(300, 300);
    }

    public void start() {
        init();

        while (_inGame) {
            event();
            update();
            draw();
        }
    }

    private void init() {
    }

    private void update() {

    }

    private void event() {

    }

    private void draw() {
        _ctx.draw();
    }

    private boolean _inGame;
    private GameContext _ctx;
}
