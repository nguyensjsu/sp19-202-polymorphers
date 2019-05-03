import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.ArrayList;
/**
 * Write a description of class WhiteEgg here.
 * 
 * @author Phoung Tran, Shivam Waghela
 */
public class WhiteEgg extends Actor implements IEgg, IEggMissSubject
{
    private GreenfootImage whiteEggImage = new GreenfootImage("WhiteEgg.png");
    private ArrayList<IEggMissObserver> observers = new ArrayList<>();
    private IGameDifficultyStrategy currentMode;
    
    public WhiteEgg() {
    }
    
    public WhiteEgg(IGameDifficultyStrategy initial){
        whiteEggImage.scale(25,39);
        setImage(whiteEggImage);    
        currentMode = initial;
    }
  
    
    public void act() 
    {   
           setLocation(this.getX(),this.getY() + currentMode.getSpeed());
 
       if (getY() > 550) {
           // Egg missed
           Greenfoot.playSound("eggDrop.mp3");
           getWorld().removeObject(this);
           notifyObservers();
        }
    }
    
    public int getEggValue(){
        return 1;
    }
    
    /**
     * Add Observer to Subscribers List
     * @param obj Observer Object
     */
    public void addObserver( IEggMissObserver obj ) {
        observers.add( obj );
    }

    /**
     * Remove Observer from Subscription
     * @param obj Observer Object
     */
    public void removeObserver( IEggMissObserver obj ) {
        observers.remove( obj );
    }

    /**
     * Trigger Events to Observers
     */
    public void notifyObservers() {
        for (IEggMissObserver o : observers) {
            o.eggMissUpdate();
        }
    }
    
}
