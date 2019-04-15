import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class WhiteEgg here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class WhiteEgg extends Actor
{
    private GreenfootImage whiteEggImage = new GreenfootImage("WhiteEgg.png");
    
    public WhiteEgg(){
        whiteEggImage.scale(30,45);
        setImage(whiteEggImage);
    }
    
    public void act() 
    {   /*
        int random = (int)(Math.random() * 4) + 1;
        if(random == 1){
            
        }*/
        setLocation(this.getX(),this.getY()+2);
        
        if (getY() > 710) {
            getWorld().removeObject(this);
        }
    }    
}
