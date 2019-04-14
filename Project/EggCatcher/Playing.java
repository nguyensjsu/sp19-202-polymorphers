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
    /**
     * Constructor for objects of class Playing.
     * 
     */
    public Playing()
    {    
        
        
        super(1920, 1080, 1);
        Greenfoot.setSpeed(60);
        rabbit = new Rabbit();
        
        addObject(rabbit, 960, 898);
    }
}
