package q2;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.*;

class TreeSystemTest {
    private TreeBuilder builder;

    @BeforeEach
    void setUp() {
        builder = new TreeBuilder();
    }

    @Test
    void testFlyweightPattern_MemorySharing() {
        // Arrange & Act
        // Build two trees of the same species
        Tree oak1 = builder.setType("Oak", "oak_texture.png")
                .setPosition(10, 10)
                .build();

        Tree oak2 = builder.setType("Oak", "oak_texture.png")
                .setPosition(20, 20)
                .build();

        // Assert
        assertNotNull(oak1.getModel(), "Tree model should not be null");
        assertNotNull(oak2.getModel(), "Tree model should not be null");

        // CRITICAL: This checks if both trees point to the exact same object in memory
        assertSame(oak1.getModel(), oak2.getModel(),
                "FAILURE: Flyweight failed. Oak1 and Oak2 should share the same TreeModel instance.");
    }

    @Test
    void testBuilderPattern_UniqueState() {
        // Arrange & Act
        Tree tree = builder.setType("Pine", "pine_texture.png")
                .setPosition(100, 500)
                .setHealth(75)
                .build();

        // Assert
        assertEquals(100, tree.getX(), "Builder failed to set unique X coordinate.");
        assertEquals(500, tree.getY(), "Builder failed to set unique Y coordinate.");
        assertEquals(75, tree.getHealth(), "Builder failed to set unique Health.");
        assertEquals("Pine", tree.getModel().getSpecies(), "Builder failed to associate correct Flyweight species.");
    }

    @Test
    void testBuilderReset_AfterBuild() {
        // Arrange
        builder.setType("Birch", "birch.png").setPosition(1, 1).build();

        // Act
        // Building a second tree without setting position (should be default 0,0 if reset works)
        Tree secondTree = builder.setType("Oak", "oak.png").build();

        // Assert
        assertEquals(0, secondTree.getX(), "Builder did not reset its internal state after build().");
    }
}
