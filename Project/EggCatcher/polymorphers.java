import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class polymorphers here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class polymorphers extends Actor
{
    private GifImage polymorphers = new GifImage("Polymorphers.gif");
    
    public polymorphers(){
        for (GreenfootImage img : polymorphers.getImages()) {
            img.scale(230, 215);
        }
        
    }
    
    public void act() 
    {
        setImage(polymorphers.getCurrentImage());
    }    
}
