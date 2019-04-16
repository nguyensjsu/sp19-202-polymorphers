import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MyWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class GameStartWorld extends World
{
    private StartButton startButton;
    private SwitchModeButton switchModeButton;
    private RankingButton rankingButton;
    
    /**
     * Constructor for objects of class MyWorld.
     * 
     */
    public GameStartWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(1280, 720, 1); 
        startButton = new StartButton();
        switchModeButton = new SwitchModeButton();
        rankingButton = new RankingButton();
        
        addObject(startButton, 640, 300);
        addObject(switchModeButton, 640, 350);
        addObject(rankingButton, 640, 400);
    }
}
