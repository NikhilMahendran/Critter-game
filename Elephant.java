import java.awt.Color;
import java.util.Random;
/*
 * Name: Nikhil Mahendran
 * PID: A17317228
 * Email: nmahendran@ucsd.edu
 * References: None
 * 
 * Creates Elephant critter
 */
public class Elephant extends Critter{
    private static final String SPECIES_NAME = "El";
    protected static int goalX;
    protected static int goalY;

    public Elephant() {
        super(SPECIES_NAME);
        goalX = 0;
        goalY = 0; //creates starting coordinates
    }

    @Override 
    public Color getColor(){
        return Color.GRAY;
    }

    @Override
    public Direction getMove(){
        Random newCoord = new Random();
        int currentX = info.getX();
        int currentY = info.getY();
        int distanceX = 0;
        int distanceY = 0;
        if(currentX == goalX && currentY == goalY){
            goalX = newCoord.nextInt(info.getWidth());
            goalY = newCoord.nextInt(info.getHeight());
        }
        if(goalX >= currentX){
            distanceX = goalX - currentX;
        }
        else 
            distanceX = currentX - goalX;
        //used to find positive distance between current and goal pos
        if(goalY >= currentY)
            distanceY = goalY - currentY;
        else
            distanceY = currentY - goalY;
        if(distanceX > distanceY){
            if(goalX > currentX){
                return Direction.EAST;
            }
            else 
                return Direction.WEST;
        }
        else if (distanceY > distanceX){
            if(goalY > currentY){
                return Direction.SOUTH;
            }
            else 
                return Direction.NORTH;
        }
        else {
            if(goalX > currentX){
                return Direction.EAST;
            }
            else 
                return Direction.WEST;
        }
    }

    @Override
    public boolean eat(){
        return true;
    }

    @Override
    public void mate() {
        this.incrementLevel(2);
    }

    @Override 
    public void reset(){
        goalX = 0;
        goalY = 0;

    }
    
}