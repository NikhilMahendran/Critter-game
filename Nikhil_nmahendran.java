import java.util.Random;
import java.awt.Color;
/*
 * Name: Nikhil Mahendran
 * PID: A17317228
 * Email: nmahendran@ucsd.edu
 * References: None
 * 
 * Creates my own critter
 */
public class Nikhil_nmahendran extends Feline{
    private int moveCount;//counter for getMove method before random direction
    private Direction currDir; //Lion's current direction
    private static final String SPECIES_NAME = "Tiger";

    public Nikhil_nmahendran() {
        displayName = SPECIES_NAME;
        moveCount = 0;
        currDir = Direction.EAST;
    }
    @Override
    public Color getColor(){
        return Color.ORANGE;
    }

    @Override
    public Direction getMove(){
        moveCount++;
        int modValue = moveCount % 16;
        if(modValue >= 12 && modValue < 16){
            currDir = Direction.WEST;
        }
        else if(modValue >= 8 && modValue < 12){
            currDir = Direction.EAST;
        }
        else if(modValue >= 4 && modValue < 8){
            currDir = Direction.SOUTH;
        }
        else if(modValue >= 0 && modValue < 4){
            currDir = Direction.NORTH;
        }
        return currDir;
    }

    @Override 
    public Attack getAttack(String opponent){
        if(opponent.equals("Lion")){
            return Attack.POUNCE;
        }
        else if (opponent.equals("Starfish")){
            return Attack.SCRATCH;
        }
        else
            return Attack.ROAR;
            
    }
}