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
    private int finalscore;
    private Score score;
    private ArrayList<Actor> numberList;
    //private Lyric lyric;
    
    /**
     * Constructor for objects of class Ending.
     * 
     */
    public Ending(int finalscore)
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(1280, 720, 1);         
       // Greenfoot.playSound("youSuck.mp3");
        startButton = new StartButton();
        switchModeButton = new SwitchModeButton();
        rankingButton = new RankingButton();
        //lyric = new Lyric();
        //addObject(lyric, 700, 200);
        addObject(startButton, 800, 400);
        addObject(switchModeButton, 800, 450);
        addObject(rankingButton, 800, 500);
        
        score = new Score(Integer.toString(finalscore));
        numberList = score.getNumberList();
        
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
