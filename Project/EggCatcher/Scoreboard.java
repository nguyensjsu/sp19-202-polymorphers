import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Scoreboard here.
 * 
 * @author Shivam Waghela 
 */
public class Scoreboard extends Actor implements IScoreObserver
{
    public int score = 0;
    /**
     * Act - do whatever the Scoreboard wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        
    }   
   
    
    /**
     * Update the score
     */
    public void scoreUpdate(IEgg e) {
        score += e.eggValue();
        //System.out.println(score);
    }
}
