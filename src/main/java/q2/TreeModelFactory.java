package q2;

import java.util.HashMap;
import java.util.Map;

class TreeFactory {
    private static final Map<String, TreeModel> models = new HashMap<>();

    public static TreeModel getTreeType(String species, String texture) {
        // TODO: Implement the Flyweight Pattern logic:
        // 1. Create a unique key (e.g., species + texture).
        // 2. Check if 'models' map already contains this key.
        // 3. If not, create a new TreeModel and put it in the map.
        // 4. Return the model from the map.
        return null;
    }
}
