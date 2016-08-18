package exemplo;

import java.util.ArrayList;

/**
 *
 * @author biankatpas
 */
public class DisplayFile {

    private ArrayList<GameEntity>[] _layers;

    public DisplayFile(int numberOfLayers) {
        _layers = new ArrayList[numberOfLayers];

        for (int i = 0; i < numberOfLayers; i++) {
            _layers[i] = new ArrayList<GameEntity>();
        }
    }

    public void add(GameEntity e, int layer) {
        _layers[layer-1].add(e);

    }

    public int layerSize() {
        return _layers.length;
    }

    public int size(int layer) {
        return _layers[layer].size();
    }

    public GameEntity get(int idx, int layer) {
        return _layers[layer].get(idx);
    }

}
