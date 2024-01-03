import java.awt.Color;
import java.util.Random;
/*
 * Name: Nikhil Mahendran
 * PID: A17317228
 * Email: nmahendran@ucsd.edu
 * References: None
 * 
 * Creates Turtle critter
 */
public class Turtle extends Critter {
    private static final String SPECIES_NAME = "Tu";

    /**
     * Default constructor - creates critter with name Tu
     */
    public Turtle() {
        super(SPECIES_NAME);
    }

    @Override
    public Direction getMove() {
        return Direction.WEST;
    }

    /**
     * Returns the color of the Turtle
     * 
     * @return Color green
     */
    @Override 
    public Color getColor(){
        return Color.GREEN;
    }
    @Override
    public boolean eat(){
        String northNeighbor = info.getNeighbor(Direction.NORTH);
        String southNeighbor = info.getNeighbor(Direction.SOUTH);
        String eastNeighbor = info.getNeighbor(Direction.EAST);
        String westNeighbor = info.getNeighbor(Direction.WEST);
 
        if((northNeighbor.equals("") == true ||
            northNeighbor.equals(".") == true || 
            northNeighbor.equals("Tu") == true) &&
           (southNeighbor.equals("") == true ||
            southNeighbor.equals(".") == true ||
            southNeighbor.equals("Tu") == true) &&
          (eastNeighbor.equals("") == true || 
           eastNeighbor.equals(".") == true ||
           eastNeighbor.equals("Tu")) &&
           (westNeighbor.equals("") == true ||
           westNeighbor.equals(".") == true || 
           westNeighbor.equals("Tu") == true)){ 
            //checks nearby squares for hostile creatures               
                return true;
           } 
        else {
            return false;
        } 
    }

    @Override
    public Attack getAttack(String opponent){
       Random attack = new Random();
       if (attack.nextInt(2) == 0){
            return Attack.ROAR;
       }
       //if(attack.nextInt(2) == 1){
        else {
            return Attack.FORFEIT;
        }
    }
}