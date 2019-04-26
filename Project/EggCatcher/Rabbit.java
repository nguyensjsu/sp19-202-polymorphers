import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.ArrayList;

/**
 * Write a description of class Chicken here.
 * 
 * @author Shivam Waghela
 */
public class Rabbit extends Actor implements IScoreSubject
{
    private int speed = 5;
    private GreenfootImage rabbitImage = new GreenfootImage("Rabbit.png");
    private ArrayList<IScoreObserver> observers = new ArrayList<>();
    
    public Rabbit(){
        rabbitImage.scale(203, 219);
        setImage(rabbitImage);
        
    }
    
    public void act() 
    {
        
        int x = getX();
        int y = getY();
 
        if(Greenfoot.isKeyDown("left")){
            setLocation(x-10, y);
        }else if(Greenfoot.isKeyDown("right")){
            setLocation(x+10, y);
        }
        
        if (isTouching(WhiteEgg.class)) {
            removeTouching(WhiteEgg.class);
            notifyObservers();
        }
    } 
    
    
    /**
     * Add Observer to Subscribers List
     * @param obj Observer Object
     */
    public void addObserver( IScoreObserver obj ) {
        observers.add(obj);
    }

    /**
     * Remove Observer from Subscription
     * @param obj Observer Object
     */
    public void removeObserver( IScoreObserver obj ) {
        observers.remove(obj);
    }

    /**
     * Trigger Events to Observers
     */
    public void notifyObservers() {
        for (IScoreObserver o : observers) {
            o.scoreUpdate();
        }   
    }
}
