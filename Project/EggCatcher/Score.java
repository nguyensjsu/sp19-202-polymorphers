import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Score class will keep track of current and highscore
 * 
 * @author Shivam Waghela 
 */
public class Score implements IScoreObserver
{
    public int currentscore = 0;
    public static int highscore = 0;
    
    /**
     * Update the score
     */
    public void scoreUpdate(IEgg e) {
        currentscore += e.getEggValue();
        
        if ( currentscore > highscore ) 
            highscore = currentscore;
    }
}
