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
    boolean easyStrategy;
    
    public WhiteEgg(){
        whiteEggImage.scale(25,39);
        setImage(whiteEggImage);
    }
    public void easy(){
        boolean easyStrategy = true;
    }
    public void hard(){
        boolean easyStrategy = false;
        
    }
    
    public void act() 
    {   
        if (easyStrategy == true){

            
            setLocation(this.getX(),this.getY()+4);
        }
        else if (easyStrategy == false){
            setLocation(this.getX(),this.getY()+5);

        setLocation(this.getX(),this.getY()+2);
        }
        else if (easyStrategy == false){
        setLocation(this.getX(),this.getY()+4);

        }
        /*
        if (getY() > 550) {
            getWorld().removeObject(this);
        }
        */
       if (getY() > 700) {
           // Egg missed
           Greenfoot.playSound("eggDrop.mp3");
           getWorld().removeObject(this);
           notifyObservers();
        }
    }
    
    public int eggValue(){
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
