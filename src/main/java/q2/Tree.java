package q2;

class Tree {
    private TreeModel model;
    private int x, y;
    private int health;

    // Setters
    void setModel(TreeModel model) { this.model = model; }
    void setX(int x) { this.x = x; }
    void setY(int y) { this.y = y; }
    void setHealth(int health) { this.health = health; }
    //Getters
    public int getX() { return x; }
    public int getY() { return y; }
    public int getHealth() { return health; }
    public TreeModel getModel() { return model; }

    public void render() {
        // TODO: Print the tree's unique data (x, y, health)
        // AND the shared data (species) from the model reference.
        System.out.println(getX() +" "+ getY() +" "+ getHealth() + " " + getModel());
    }
}
