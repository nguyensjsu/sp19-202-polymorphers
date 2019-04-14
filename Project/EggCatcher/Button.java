import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Button here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Button extends Actor
{
   private boolean mouseDown;
    
    public Button(){       
        mouseDown = false;
    }
    
    public void act() 
    {
        if (!mouseDown && Greenfoot.mousePressed(this)) {              
            mouseDown = true; // here
        }    
        if (mouseDown && Greenfoot.mouseClicked(this)) {                
            mouseDown = false; // and here
            //add also the methods you want to execute here;  
        }
    }  
}
