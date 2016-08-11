package exemplo;

/**
 *
 * @author biankatpas
 */
public class GameEntity {

    private int _entityImage;
    private Vec2 _position;

    public GameEntity(int img, Vec2 pos) {
        _entityImage = img;
        _position = pos;
    }

    public Vec2 getPosition() {
        return _position;
    }

    public int getImage() {
        return _entityImage;
    }

}
