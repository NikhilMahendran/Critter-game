import java.util.Random;
import java.awt.Color;
/*
 * Name: Nikhil Mahendran
 * PID: A17317228
 * Email: nmahendran@ucsd.edu
 * References: None
 * 
 * Creates Leopard critter
 */
public class Leopard extends Feline{
    protected static int confidence;
    private static final String SPECIES_NAME = "Lpd";

    public Leopard() {
        displayName = SPECIES_NAME;
        confidence = 0;
    }
    @Override
    public Color getColor(){
        return Color.RED;
    }

    @Override
    public Direction getMove(){
        Direction currDir = Direction.EAST;
        String northNeighbor = info.getNeighbor(Direction.NORTH);
        String southNeighbor = info.getNeighbor(Direction.SOUTH);
        String eastNeighbor = info.getNeighbor(Direction.EAST);
        String westNeighbor = info.getNeighbor(Direction.WEST);
        if(northNeighbor.equals(".")||northNeighbor.equals("Patrick")){
            return Direction.NORTH;
        }
        else if(southNeighbor.equals(".")||southNeighbor.equals("Patrick")){
            return Direction.SOUTH;
        }
        else if(eastNeighbor.equals(".")||eastNeighbor.equals("Patrick")){
            return Direction.EAST;
        }
        else if(westNeighbor.equals(".")||westNeighbor.equals("Patrick")){
            return Direction.WEST;
        }
        else {
            Random move = new Random();
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
            return currDir;
        }
    }

    @Override
    public boolean eat(){
        Random chance = new Random();
        int chanceOfEating = chance.nextInt(10);
        //used to make chance of eating a percent based on confidence
        if(chanceOfEating < confidence){
            return true;
        }
        else{
            return false;
        }
    }

    @Override
    public void win(){
        if(confidence >= 0 && confidence < 10){
            confidence++;
        }
    }
    @Override
    public void lose(){
        if(confidence > 0 && confidence <= 10){
            confidence--;
        }
    }
    protected Attack generateAttack(String opponent){
        Random attack = new Random();
        int attackNumber = attack.nextInt(3);
        Attack nextAttack = Attack.FORFEIT;
        if(opponent.equals("Patrick")){
            nextAttack = Attack.FORFEIT;
        }
        else if(attackNumber == 0){
            nextAttack = Attack.POUNCE;
        }
        else if(attackNumber == 1){
            nextAttack = Attack.ROAR;
        }
        else if(attackNumber == 2){
            nextAttack = Attack.SCRATCH;
        }
        return nextAttack;
    }

    @Override 
    public Attack getAttack(String opponent){
        if(opponent.equals("Tu") || confidence > 5){
            return Attack.POUNCE;
        }
        else
            return this.generateAttack(opponent);
    }

    @Override
    public void reset(){
        confidence = 0;
    }
}