import java.awt.Color;
/*
 * Name: Nikhil Mahendran
 * PID: A17317228
 * Email: nmahendran@ucsd.edu
 * References: None
 * 
 * Creates Starfish critter
 */
public class Starfish extends Critter {
    private static final String SPECIES_NAME = "Patrick";

    /**
     * Default constructor - creates critter with name Patrick
     */
    public Starfish() {
        super(SPECIES_NAME);
    }

    @Override
    public Direction getMove() {
        return Direction.CENTER;
    }

    /**
     * Returns the color of the Starfish
     * 
     * @return Color pink
     */
    @Override 
    public Color getColor() {
        return Color.PINK;
    }
}