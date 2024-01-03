import java.util.Random;
import java.awt.Color;
/*
 * Name: Nikhil Mahendran
 * PID: A17317228
 * Email: nmahendran@ucsd.edu
 * References: None
 * 
 * Creates Ocelot critter
 */
public class Ocelot extends Leopard{
    private static final String SPECIES_NAME = "Oce";

    public Ocelot() {
        displayName = SPECIES_NAME;
        confidence = 0;
    }
    @Override
    public Color getColor(){
        return Color.LIGHT_GRAY;
    }

    @Override
    protected Attack generateAttack(String opponent){
        Attack nextAttack = Attack.FORFEIT;
        if(opponent.equals("Lion") || opponent.equals("Fe") ||
             opponent.equals("Lpd")){
            nextAttack = Attack.SCRATCH;
        }
        else {
            nextAttack = Attack.POUNCE;
        }
        return nextAttack;
    }
}