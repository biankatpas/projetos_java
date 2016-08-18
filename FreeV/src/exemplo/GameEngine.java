package exemplo;

/**
 *
 * @author biankatpas
 */
public class GameEngine {

    private boolean _inGame;
    private GameContext _ctx;
    private DisplayFile _df;

    public GameEngine() {
        _inGame = true;
        _ctx = new SwingContext(800, 800);
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
        int img = _ctx.loadImage("/res/fundo.jpg");
        int img2 = _ctx.loadImage("/res/tartaruga.jpg");
        
        System.out.println(img + " " + img2);
        
        Vec2 pos = new Vec2(30, 30);
        GameEntity entity = new GameEntity(img, pos);
        GameEntity entity2 = new GameEntity(img2, pos);
        
        _df = new DisplayFile(2);
        _df.add(entity, 1);//
        _df.add(entity2, 2);

    }

    private void update() {

    }

    private void event() {

    }

    private void draw() {
        _ctx.draw(_df);
    }

}
