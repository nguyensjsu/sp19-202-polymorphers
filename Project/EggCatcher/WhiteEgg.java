import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class WhiteEgg here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class WhiteEgg extends Actor implements IEgg
{
    private GreenfootImage whiteEggImage = new GreenfootImage("WhiteEgg.png");
    
    public WhiteEgg(){
        whiteEggImage.scale(30,45);
        setImage(whiteEggImage);
    }
    
    public void act() 
    {   
        setLocation(this.getX(),this.getY()+2);
        
        if (getY() > 710) {
            getWorld().removeObject(this);
        }
    }
    
    public int eggValue(){
        return 1;
    }
}
