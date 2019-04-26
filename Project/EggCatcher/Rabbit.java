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
        
        
        
        if (isTouching(GoldenEggDecorator.class) ) {
            removeTouching(GoldenEggDecorator.class);
            notifyObservers(new GoldenEggDecorator());
        } else if (isTouching(SilverEggDecorator.class) ) {
            removeTouching(SilverEggDecorator.class);
            notifyObservers(new SilverEggDecorator());
        } else if (isTouching(WhiteEgg.class) ) {
            removeTouching(WhiteEgg.class);
            notifyObservers(new WhiteEgg());
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
    public void notifyObservers(IEgg e) {
        for (IScoreObserver o : observers) {
            o.scoreUpdate(e);
        }   
    }
}
