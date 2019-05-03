import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import javax.swing.*;
/**
 * Implementation for Ranking Button class
 */
public class HighScore extends Button
{
    GreenfootImage rankingButtonImage = new GreenfootImage("rankingButton.png");
    GreenfootImage rankingButtonPressedImage = 
    new GreenfootImage("rankingButtonPressed.png");
    
    
    
    public HighScore(){
    }
    public void act() 
    {
        
        if ( Greenfoot.mouseClicked(this)) {                
            setImage(rankingButtonImage);
            JOptionPane.showMessageDialog(new JFrame(), "High Score: " + Scoreboard.highscore);
        }
    }    
}
