
import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.ArrayList;
/**
 * Write a description of class Playing here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

public class Playing extends World
{
    private Ending gameEndWorld;
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
    private Basket basket;
    private Scoreboard board;
    private EggMiss eggMiss;
    private Score score;
    private polymorphers Poly;
    private ArrayList<Actor> numberList = new ArrayList<>();
    
    // Music
    private GreenfootSound music = new GreenfootSound("farm-ambience.mp3");
    
    private long lastAdded = System.currentTimeMillis();
    private IDifficultyStrategy initial;
    /**
     * Constructor for objects of class Playing.
     * 
     */
    public Playing(IDifficultyStrategy initial)
    {    
        super(1280, 720, 1);
        this.initial = initial;
        init();
    }

    public void init(){
        Greenfoot.setSpeed(100);
        music.playLoop();
        chicken1 = new Chicken();
        chicken2 = new Chicken();
        chicken3 = new Chicken();
        chicken4 = new Chicken();
        rabbit = new Rabbit();
        brokenEgg = new BrokenEgg();
        brokenEgg2 = new BrokenEgg();
        brokenEgg3 = new BrokenEgg();
        
        whiteEgg = new WhiteEgg(initial);
        extraWhiteEgg = new WhiteEgg(initial);
        silverEgg = new SilverEggDecorator(initial);
        goldenEgg = new GoldenEggDecorator(initial);
        Poly = new polymorphers();
        basket = new Basket();

        addObject(chicken1, 100, 120);
        addObject(chicken2, 340, 120);
        addObject(chicken3, 580, 120);
        addObject(chicken4, 820, 120);
        addObject(basket, 1150, 660);
        addObject(Poly, 1120, 260);

        addObject(rabbit, 640, 610);
       
        
        // Add observer for scoreboard
        board = new Scoreboard();
        rabbit.addObserver(board);
        
        // Add observer for Lives
        eggMiss = new EggMiss();
        extraWhiteEgg.addObserver(eggMiss);
        silverEgg.addObserver(eggMiss);
        goldenEgg.addObserver(eggMiss);
        rabbit.addObserver(eggMiss);
    }

    public void act() 
    
    {   
         
        long curTime  = System.currentTimeMillis();
        if (curTime >= lastAdded + 1900) //5000ms = 5s
        {            
            int random = (int)(Math.random() * 4) + 1;
            if(random == 1 ){
               playSound();
               addObject(eggType(), 100, 150); 
            }
            else if (random == 2){
               playSound();
               addObject(eggType(), 340, 150); 
            }
            else if (random == 3){
               playSound();
               addObject(eggType(), 580, 150);  
            }
            else{
               playSound();
               addObject(eggType(), 820, 150);  
            }
            lastAdded  = curTime;
        }
        
        if (eggMiss.lives < 1) {
            // switch to end world
            music.stop();
            Greenfoot.setWorld(new Ending(board.score));
        }
        
        // show lives aka broken eggs'
        switch (eggMiss.lives) {
            case 3: break; // don't display anything
            case 2:
                
                addObject(brokenEgg, 1020, 437); break;
            case 1:
                
                addObject(brokenEgg, 1020, 437);
                addObject(brokenEgg2, 1115, 437); break;
            case 0:
                
                addObject(brokenEgg, 1020, 437);
                addObject(brokenEgg2, 1115, 437); 
                addObject(brokenEgg3, 1210, 437); break;
            default: 
                System.out.println("cannot display lives"); 
        }
        
        // displays score
        for(int i = 0; i < numberList.size(); i++ ){
            removeObject(numberList.get(i));
        }
        score = new Score(Integer.toString(board.score));
        numberList = score.getNumberList();
        
        for(int i = 0; i < numberList.size(); i++ ){
            addObject(numberList.get(i), 1090 + i*50, 365);
        }
    }
   
    
    public WhiteEgg eggType(){
        int rand = (int)(Math.random() * 10) + 1;       
              
        if(rand >= 1 && rand <= 5){
            whiteEgg = extraWhiteEgg;
            //addObject(whiteEgg, 100, 150);
        }
        
        else if(rand >= 6 && rand <= 8){
            whiteEgg = silverEgg;
            //addObject(whiteEgg, 100, 150);
        }
        
        else if(rand == 9 || rand == 10){
           whiteEgg = goldenEgg;
           //addObject(whiteEgg, 100, 150);
        }
        
      return whiteEgg;
    }
    
    public void playSound(){
        int rand = (int)(Math.random() * 8) + 1;
        String fileName = "";
        
        if(rand == 1){
            fileName = "chicken1.mp3";
        }
        else if(rand == 2){
            fileName = "chicken2.mp3";
        }
        else if(rand == 3){
            fileName = "chicken3.mp3";
        }
        else if(rand == 4){
            fileName = "chicken4.mp3";
        }
        else if(rand == 5){
            fileName = "chicken5.mp3";
        }
        else if(rand == 6){
            fileName = "chicken6.mp3";
        }
        else if(rand == 7){
            fileName = "chicken7.mp3";
        }
        else if(rand == 8){
            fileName = "chicken8.mp3";
        }
        
        Greenfoot.playSound(fileName);
    }
}
