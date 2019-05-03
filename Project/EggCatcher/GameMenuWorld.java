import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MyWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class GameMenuWorld extends World
{
    private GameStartButton gameStartButton;
    private SwitchGameModeButton switchGameModeButton;
    private HighScoreButton highscoreButton;
    public static IGameDifficultyStrategy currentStrategy;
    /**
     * Constructor for objects of class MyWorld.
     * 
     */
    public GameMenuWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(1280, 720, 1); 
        gameStartButton = new GameStartButton();
        switchGameModeButton = new SwitchGameModeButton();
        highscoreButton = new HighScoreButton();
        
        addObject(gameStartButton, 640, 300);
        addObject(switchGameModeButton, 640, 350);
        addObject(highscoreButton, 640, 400);
    }
    
    public void act() {
        showText(currentStrategy.getMode(), 1200, 20);
    }
}
