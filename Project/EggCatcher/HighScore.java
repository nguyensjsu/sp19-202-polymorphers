import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Implementation for Ranking Button class
 */
public class HighScore extends Button
{
    GreenfootImage rankingButtonImage = new GreenfootImage("rankingButton.png");
    GreenfootImage rankingButtonPressedImage = 
    new GreenfootImage("rankingButtonPressed.png");
    
    private boolean mouseDown;
    
    public HighScore(){
        mouseDown = false;
    }
    public void act() 
    {
        if (!mouseDown && Greenfoot.mousePressed(this)) {    
            setImage(rankingButtonPressedImage);
            mouseDown = true; // here
        }    
        if (mouseDown && Greenfoot.mouseClicked(this)) {                
            setImage(rankingButtonImage);
            mouseDown = false; 
            
            //add also the methods you want to execute here;  
        }
    }    
}
