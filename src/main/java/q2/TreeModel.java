package q2;

import java.util.HashMap;
import java.util.Map;

class TreeModel {
    private final String species;
    private final String texture;

    public TreeModel(String species, String texture) {
        this.species = species;
        this.texture = texture;
        System.out.println("--- [FLYWEIGHT] Loading heavy assets for: " + species + " ---");
    }

    public String getSpecies() { return species; }
}
