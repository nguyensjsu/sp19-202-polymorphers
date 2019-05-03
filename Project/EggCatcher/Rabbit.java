import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.ArrayList;

/**
 * Write a description of class Chicken here.
 * 
 * @author Shivam Waghela
 */
public class Rabbit extends Actor implements IScoreSubject, IEggMissSubject
{
    private int speed = 5;
    private GreenfootImage rabbitImage = new GreenfootImage("RabbitNoEggState.png");
    private ArrayList<IScoreObserver> observers = new ArrayList<>();
    private ArrayList<IEgg> eggList = new ArrayList<>();
    private ArrayList<IEggMissObserver> eggMissObservers = new ArrayList<>();
    
    /* stores the state of rabbit */
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
            if (x <= 100){
                setLocation(x, y);
            }
            else{
            setLocation(x-10, y);
        }
        }else if(Greenfoot.isKeyDown("right")){
            if(x >= 1000){
                setLocation(x, y);
            }
            else{
            setLocation(x+10, y);
        }
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
            if (!(current instanceof FullEggState)){ 
                //removeTouching(GoldenEggDecorator.class);
                eggList.add(new GoldenEggDecorator());
                Greenfoot.playSound("catch.mp3");
                
            }
            else
                notifyObservers();
        } else if (isTouching(SilverEggDecorator.class) ) {
            removeTouching(SilverEggDecorator.class);
            current = current.nextState();
            if (!(current instanceof FullEggState)){
                //removeTouching(SilverEggDecorator.class);
                Greenfoot.playSound("catch.mp3");
                eggList.add(new SilverEggDecorator());
                
            }
            else
                notifyObservers();
        } else if (isTouching(WhiteEgg.class) ) {
            removeTouching(WhiteEgg.class);
            current = current.nextState();
            if (!(current instanceof FullEggState)){
                //removeTouching(WhiteEgg.class);
                Greenfoot.playSound("catch.mp3");
                eggList.add(new WhiteEgg());
            }
            else
                notifyObservers();
        }
        
       String image = "RabbitNoEggState.png";
       if ( current instanceof NoEggState ) {
           image = "RabbitNoEggState.png";
       } else if ( current instanceof OneEggState ) {
           image = "RabbitOneEggState.png";
       } else if ( current instanceof TwoEggState ) {
           image = "RabbitTwoEggState.png";
       } else if ( current instanceof ThreeEggState || current instanceof FullEggState ) {
           image = "RabbitThreeEggState.png";
        }
       rabbitImage = new GreenfootImage(image);
       rabbitImage.scale(203, 219);
       setImage(rabbitImage);
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
    
    
    /**
     * Add Observer to Subscribers List
     * @param obj Observer Object
     */
    public void addObserver( IEggMissObserver obj ) {
        eggMissObservers.add( obj );
    }

    /**
     * Remove Observer from Subscription
     * @param obj Observer Object
     */
    public void removeObserver( IEggMissObserver obj ) {
        eggMissObservers.remove( obj );
    }

    /**
     * Trigger Events to Observers
     */
    public void notifyObservers() {
        for (IEggMissObserver o : eggMissObservers) {
            o.eggMissUpdate();
        }  
    }
}
