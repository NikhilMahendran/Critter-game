import java.util.Random;
/*
 * Name: Nikhil Mahendran
 * PID: A17317228
 * Email: nmahendran@ucsd.edu
 * References: None
 * 
 * Creates Feline critter
 */
public class Feline extends Critter {
    private int moveCount;//counter for getMove method before random direction
    private int eatCount; //counter for eating
    private int noEatCount; // counter for not eating
    private Direction currDir; //current direction
    private static final String SPECIES_NAME = "Fe";

    public Feline() {
        super(SPECIES_NAME);
        eatCount = 0;
        noEatCount = 1;
        moveCount = 0;
    }

    @Override
    public Direction getMove() {
        Random move = new Random();
        if(moveCount % 5 == 0){
            int randomDir = move.nextInt(4);
            if (randomDir == 0){
                currDir = Direction.NORTH;
            }
            if(randomDir == 1){
                currDir = Direction.SOUTH;
            }
            if(randomDir == 2){
                currDir = Direction.EAST;
            }
            if (randomDir == 3){
                currDir = Direction.WEST;
            }
            //used to randomly decide next direction
            moveCount++;
        }
        return currDir; 
    }    

    @Override
    public boolean eat() {
        if(noEatCount == 3){
            eatCount++;
            noEatCount = 1;
            return true;
        }
        else{
            noEatCount++;
            return false;
        }
    }

    @Override
    public Attack getAttack(String opponent){
       return Attack.POUNCE;
    }
}