package q2;

class TreeBuilder {
    private Tree tree;

    public TreeBuilder() {
        this.reset();
    }

    public void reset() {
        this.tree = new Tree();
    }

    public TreeBuilder setPosition(int x, int y) {
        // TODO: Set x and y on the internal 'tree' object
        return this;
    }

    public TreeBuilder setType(String species, String texture) {
        // TODO: Call the TreeFactory to get the shared TreeModel
        // TODO: Assign that model to the internal 'tree' object
        return this;
    }

    public TreeBuilder setHealth(int health) {
        // TODO: Set health on the internal 'tree' object
        return this;
    }

    public Tree build() {
        // TODO: Capture the current tree, reset the builder, and return the tree
        return null;
    }
}
