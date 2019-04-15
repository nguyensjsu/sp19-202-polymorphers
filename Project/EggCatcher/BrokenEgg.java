import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class BrokenEgg here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class BrokenEgg extends Actor
{
    private GreenfootImage brokenEgg = new GreenfootImage("brokenEgg.png");
    
    public BrokenEgg(){
        brokenEgg.scale(90,72);
        setImage(brokenEgg);
    }
    
    public void act() 
    {
        // Add your action code here.
    }    
}
