import java.util.Random;
import java.awt.Color;
/*
 * Name: Nikhil Mahendran
 * PID: A17317228
 * Email: nmahendran@ucsd.edu
 * References: None
 * 
 * Creates Lion critter
 */
public class Lion extends Feline{
    private int moveCount; //counter for getMove method before random direction
    private int fightsWon; //number of fights won
    private boolean hungry; //Whether lion is hungry or not
    private Direction currDir; //Lion's current direction
    private static final String SPECIES_NAME = "Lion";

    public Lion() {
        displayName = SPECIES_NAME;
        moveCount = 0;
        fightsWon = 0;
        currDir = Direction.EAST;
        hungry = false;
    }
    @Override
    public Color getColor(){
        return Color.YELLOW;
    }

    @Override
    public Direction getMove(){
        moveCount++;
        int modValue = moveCount % 20;
        if(modValue >= 15 && modValue < 20){
            currDir = Direction.NORTH;
        }
        else if(modValue >= 10 && modValue < 15){
            currDir = Direction.WEST;
        }
        else if(modValue >= 5 && modValue < 10){
            currDir = Direction.SOUTH;
        }
        else if(modValue >= 0 && modValue < 5){
            currDir = Direction.EAST;
            //used to determine which direction the lion sets for the next 5
        }
        return currDir;
    }

    @Override
    public boolean eat(){
        if(hungry == true){
            hungry = false;
            return true;
        }
        else{
            return false;
        }
    }

    @Override
    public void sleep(){
        displayName = "noiL";
        hungry = false; // questionable
    }

    @Override
    public void wakeup(){
        displayName = "Lion";
    }

    @Override
    public void win(){
        fightsWon++;
        hungry = true;
    }

}