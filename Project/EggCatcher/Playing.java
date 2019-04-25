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
    private WhiteEgg eggTest;

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
        
        int rand = (int)(Math.random() * 3) + 1;
        if(rand == 1){
            eggTest = new WhiteEgg();
        }
        else if(rand == 2){
            eggTest = new GoldenEggDecorator();
        }
        else{
            eggTest = new SilverEggDecorator();
        }

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
        
        
        int random = (int)(Math.random() * 4) + 1;
        int x = 0;
        if(random == 1){
            addObject(eggTest, 100, 150);
        }
        else if (random == 2){
           addObject(eggTest, 340, 150);
           
        }
        else if (random == 3){
           addObject(eggTest, 580, 150);
           
        }
        else{
           addObject(eggTest, 820, 150);
           
        }
        
    }
}
