
import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Playing here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

public class Playing extends World
{
    private Rabbit rabbit;
    private Chicken chicken1;
    private Chicken chicken2;
    private Chicken chicken3;
    private Chicken chicken4;
    private BrokenEgg brokenEgg;
    private BrokenEgg brokenEgg2;
    private BrokenEgg brokenEgg3;
    private WhiteEgg whiteEgg;
    private WhiteEgg extraWhiteEgg;
    private WhiteEgg goldenEgg;
    private WhiteEgg silverEgg;
    
    private long lastAdded = System.currentTimeMillis();

    /**
     * Constructor for objects of class Playing.
     * 
     */
    public Playing()
    {    
        super(1280, 720, 1);

        init();
    }

    public void init(){
        Greenfoot.setSpeed(100);
        chicken1 = new Chicken();
        chicken2 = new Chicken();
        chicken3 = new Chicken();
        chicken4 = new Chicken();
        rabbit = new Rabbit();
        brokenEgg = new BrokenEgg();
        brokenEgg2 = new BrokenEgg();
        brokenEgg3 = new BrokenEgg();
        
        whiteEgg = new WhiteEgg();
        extraWhiteEgg = new WhiteEgg();
        silverEgg = new SilverEggDecorator();
        goldenEgg = new GoldenEggDecorator();

        addObject(chicken1, 100, 120);
        addObject(chicken2, 340, 120);
        addObject(chicken3, 580, 120);
        addObject(chicken4, 820, 120);
        addObject(brokenEgg, 1020, 437);
        addObject(brokenEgg2, 1115, 437);
        addObject(brokenEgg3, 1210, 437);

        addObject(rabbit, 640, 610);
        
    }

    public void act() 
    
    {   
         
        long curTime  = System.currentTimeMillis();
        if (curTime >= lastAdded + 1900) //5000ms = 5s
        {            
            int random = (int)(Math.random() * 4) + 1;
            if(random == 1 ){
               addObject(eggType(), 100, 150); 
            }
            else if (random == 2){
               addObject(eggType(), 340, 150); 
            }
            else if (random == 3){
               addObject(eggType(), 580, 150);  
            }
            else{
               addObject(eggType(), 820, 150);  
            }
            lastAdded  = curTime;
        }
        
    }
   
    
    public WhiteEgg eggType(){
        int rand = (int)(Math.random() * 3) + 1;       
              
        if(rand == 1){
            whiteEgg = extraWhiteEgg;
            //addObject(whiteEgg, 100, 150);
        }
        
        else if(rand == 2){
            whiteEgg = silverEgg;
            //addObject(whiteEgg, 100, 150);
        }
        
        else if(rand == 3){
           whiteEgg = goldenEgg;
           //addObject(whiteEgg, 100, 150);
        }
        
      return whiteEgg;
    }
}
