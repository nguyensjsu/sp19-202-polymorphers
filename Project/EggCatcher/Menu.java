import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MyWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Menu extends World
{
    private StartButton startButton;
    private SwitchModeButton switchModeButton;
    private RankingButton rankingButton;
    
    /**
     * Constructor for objects of class MyWorld.
     * 
     */
    public Menu()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(1920, 1080, 1); 
        startButton = new StartButton();
        switchModeButton = new SwitchModeButton();
        rankingButton = new RankingButton();
        
        addObject(startButton, 960, 600);
        addObject(switchModeButton, 960, 650);
        addObject(rankingButton, 960, 700);
    }
}
