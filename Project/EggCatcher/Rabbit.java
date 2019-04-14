import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Chicken here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Rabbit extends Actor
{
    private int speed = 5;
    private GreenfootImage rabbitImage = new GreenfootImage("Rabbit.png");
    
    public Rabbit(){
        rabbitImage.scale(339, 365);
        setImage(rabbitImage);
        
    }
    
    public void act() 
    {
        
        int x = getX();
        int y = getY();
 
        if(Greenfoot.isKeyDown("left")){
            setLocation(x-20, y);
        }else if(Greenfoot.isKeyDown("right")){
            setLocation(x+20, y);
        }
    }    
}
