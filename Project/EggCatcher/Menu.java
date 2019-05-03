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
    private HighScore highscore;
    public static IDifficultyStrategy initialStrategy;
    /**
     * Constructor for objects of class MyWorld.
     * 
     */
    public Menu()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(1280, 720, 1); 
        startButton = new StartButton();
        switchModeButton = new SwitchModeButton();
        highscore = new HighScore();
        
        addObject(startButton, 640, 300);
        addObject(switchModeButton, 640, 350);
        addObject(highscore, 640, 400);
    }
    
    public void act() {
        showText(initialStrategy.getMode(), 1200, 20);
    }
}
