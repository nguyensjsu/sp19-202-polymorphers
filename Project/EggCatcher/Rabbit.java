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
    private ArrayList<IEgg> eggList = new ArrayList<>();
    
    private IEggState current = new NoEggState();
    
    public Rabbit() {
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
        
        
        // go back to no egg state when it empties in the collector
        if (isTouching(Basket.class) && !(current instanceof NoEggState)) {
            current = new NoEggState();
            for (IEgg egg : eggList) {
                notifyObservers(egg);
            }
            eggList = new ArrayList();
            
        }
        
        if (isTouching(GoldenEggDecorator.class) ) {
            removeTouching(GoldenEggDecorator.class);
            current = current.nextState();
            if (!(current instanceof FullEggState)) 
                eggList.add(new GoldenEggDecorator());
        } else if (isTouching(SilverEggDecorator.class) ) {
            removeTouching(SilverEggDecorator.class);
            current = current.nextState();
            if (!(current instanceof FullEggState))
                eggList.add(new SilverEggDecorator());
        } else if (isTouching(WhiteEgg.class) ) {
            removeTouching(WhiteEgg.class);
            current = current.nextState();
            if (!(current instanceof FullEggState))
                eggList.add(new WhiteEgg());
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
