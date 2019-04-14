import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.*;
/**
 * Write a description of class Ending here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Ending extends World
{
    
    private StartButton startButton;
    private SwitchModeButton switchModeButton;
    private RankingButton rankingButton;
    private int highscore;
    private Score score;
    private ArrayList<Actor> numberList;
    
    /**
     * Constructor for objects of class Ending.
     * 
     */
    public Ending()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(1920 , 1080, 1);         
        
        startButton = new StartButton();
        switchModeButton = new SwitchModeButton();
        rankingButton = new RankingButton();
        
        addObject(startButton, 1200, 600);
        addObject(switchModeButton, 1200, 650);
        addObject(rankingButton, 1200, 700);
        
        highscore = 2222;
        score = new Score(Integer.toString(highscore));
        numberList = score.getNumberList();
        
        for(int i = 0; i < numberList.size(); i++ ){
            addObject(numberList.get(i), 800 + i*110, 430);
        }
    }
    
    public void setHighScore(int highscore){
        this.highscore = highscore;
    }
    
    public int getHighScore(){
        return highscore;
    }
}
