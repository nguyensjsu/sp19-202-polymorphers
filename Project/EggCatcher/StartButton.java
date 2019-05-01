import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Implementation for the start button
 */
public class StartButton extends Button
{
    GreenfootImage startButtonImage = new GreenfootImage("startButton.png");
    GreenfootImage startButtonPressedImage = 
    new GreenfootImage("startButtonPressed.png");
    private boolean mouseDown;
    
    public StartButton(){
        setImage(startButtonImage);
        mouseDown = false;
    }
    
    public void act() 
    {
  
        if (!mouseDown && Greenfoot.mousePressed(this)) {    
            setImage(startButtonPressedImage);
            mouseDown = true; // here
        }    
        if (mouseDown && Greenfoot.mouseClicked(this)) {                
            setImage(startButtonImage);
            mouseDown = false; 
            //Switch to playing world
            //Greenfoot.setWorld(new Playing());
            StartCommand start = new StartCommand();
            start.execute();
            //add also the methods you want to execute here;
            
        }
    }    
}
