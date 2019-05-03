import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.*;
/**
 * Write a description of class Ending here.
 * 
 * @author Shivam Waghela, Phuong Tran
 * @version (a version number or a date)
 */
public class GameEndWorld extends World
{
    
    private GameStartButton gameStartButton;
    private SwitchGameModeButton switchGameModeButton;
    private HighScoreButton highscoreButton;
    private int finalscore;
    private ScoreDisplay scoreDisplay;
    private ArrayList<Actor> numberList;
    //private Lyric lyric;
    
    /**
     * Constructor for objects of class Ending.
     * 
     */
    public GameEndWorld(int finalscore)
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(1280, 720, 1);         
       // Greenfoot.playSound("youSuck.mp3");
        gameStartButton = new GameStartButton();
        switchGameModeButton = new SwitchGameModeButton();

        
        //lyric = new Lyric();
        //addObject(lyric, 700, 200);

        highscoreButton = new HighScoreButton();
        
 
        addObject(gameStartButton, 800, 400);
        addObject(switchGameModeButton, 800, 450);
        addObject(highscoreButton, 800, 500);
        
        scoreDisplay = new ScoreDisplay(Integer.toString(finalscore));
        numberList = scoreDisplay.getNumberList();
        
        for(int i = 0; i < numberList.size(); i++ ){
            addObject(numberList.get(i), 530 + i*50, 290);
        }
    }
    
    public void act(){
        
    }
    
    public void setFinalScore(int finalscore){
        this.finalscore = finalscore;
    }
    
    public int getFinalScore(){
        return finalscore;
    }
}
