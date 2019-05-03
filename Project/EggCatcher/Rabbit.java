import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.ArrayList;

/**
 * Write a description of class Chicken here.
 * 
 * @author Shivam Waghela, Phuong Tran
 */
public class Rabbit extends Actor implements IScoreSubject, IEggMissSubject
{
    private GreenfootImage rabbitImage = new GreenfootImage("RabbitNoEggState.png");
    private ArrayList<IScoreObserver> scoreObservers = new ArrayList<>();
    private ArrayList<IEgg> eggList = new ArrayList<>();
    private ArrayList<IEggMissObserver> eggMissObservers = new ArrayList<>();
    
    /* stores the state of rabbit */
    private IEggState currentState = new NoEggState();
    
    public Rabbit() {
        rabbitImage.scale(203, 219);
        setImage(rabbitImage);
    }
    
    public void act() 
    {
        int x = getX();
        int y = getY();
 
        if(Greenfoot.isKeyDown("left")) {
            if (x <= 100) {
                setLocation(x, y);
            }
            else{
                setLocation(x-10, y);
            }
        } else if(Greenfoot.isKeyDown("right")) {
            if (x >= 1000) {
                setLocation(x, y);
            }
            else {
                setLocation(x+10, y);
            }
        }
        
        
        // go back to no egg state when it empties in the collector
        if (isTouching(Basket.class) && !(currentState instanceof NoEggState)) {
            Greenfoot.playSound("dumping.mp3");
            currentState = new NoEggState();
            for (IEgg egg : eggList) {
                notifyObservers(egg);
            }
            eggList = new ArrayList();
        }
        
        if (isTouching(GoldenEggDecorator.class) ) {
            removeTouching(GoldenEggDecorator.class);
            currentState = currentState.nextState();
            if (!(currentState instanceof FullEggState)){ 
                eggList.add(new GoldenEggDecorator());
                Greenfoot.playSound("catch.mp3");
                
            }
            else
                notifyObservers();
        } else if (isTouching(SilverEggDecorator.class) ) {
            removeTouching(SilverEggDecorator.class);
            currentState = currentState.nextState();
            if (!(currentState instanceof FullEggState)) {
                Greenfoot.playSound("catch.mp3");
                eggList.add(new SilverEggDecorator());
                
            }
            else
                notifyObservers();
        } else if (isTouching(WhiteEgg.class) ) {
            removeTouching(WhiteEgg.class);
            currentState = currentState.nextState();
            if (!(currentState instanceof FullEggState)){
                Greenfoot.playSound("catch.mp3");
                eggList.add(new WhiteEgg());
            }
            else
                notifyObservers();
        }
        
       String image = "RabbitNoEggState.png";
       if ( isTouching(Basket.class)  ) {
           image = "RabbitDump.png";
       } else if ( currentState instanceof NoEggState ) {
           image = "RabbitNoEggState.png";
       } else if ( currentState instanceof OneEggState ) {
           image = "RabbitOneEggState.png";
       } else if ( currentState instanceof TwoEggState ) {
           image = "RabbitTwoEggState.png";
       } else if ( currentState instanceof ThreeEggState || currentState instanceof FullEggState ) {
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
        scoreObservers.add(obj);
    }

    /**
     * Remove Observer from Subscription
     * @param obj Observer Object
     */
    public void removeObserver( IScoreObserver obj ) {
        scoreObservers.remove(obj);
    }

    /**
     * Trigger Events to Observers
     */
    public void notifyObservers(IEgg e) {
        for (IScoreObserver o : scoreObservers) {
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
