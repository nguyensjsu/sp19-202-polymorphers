import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Chicken here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Chicken extends Actor
{
    private GifImage chickenGIF = new GifImage("chicken1.gif");
    
    public Chicken(){
        
        //((GreenfootImage)obj).scale(342, 326);
        //for (GreenfootImage img : chickenGIF.getImages()) img.scale(257, 245);
    }
    
    public void act() 
    {
        // Add your action code here.
        setImage(chickenGIF.getCurrentImage());
    }    
}
