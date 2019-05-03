import greenfoot.*;
/**
 * Write a description of class EggMiss here.
 * 
 * @author Shivam Waghela
 */
public class EggMissDisplay extends Actor implements IEggMissObserver
{
    public int lives = 3;

    /**
     * Constructor for objects of class EggMiss
     */
    public EggMissDisplay()
    {
    }

    /**
     * Update the Egg miss count 
     */
    public void eggMissUpdate(){
        lives -= 1;
    }
}
