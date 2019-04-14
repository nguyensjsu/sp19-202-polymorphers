import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.*;
/**
 * Write a description of class Score here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Score 
{
    private ArrayList<Actor> numberList;
    
    
    public Score(String highscore){
        numberList = new ArrayList<>();
        int i = 0;
        while(i < highscore.length()){
           if(highscore.substring(i, i+1).equals("1")){
               numberList.add(new One());
               i++;
            }
            else if (highscore.substring(i, i+1).equals("2")){
               numberList.add(new Two());
               i++;
            }
            else if (highscore.substring(i, i+1).equals("3")){
               numberList.add(new Three());
               i++;
            }
            else if (highscore.substring(i, i+1).equals("4")){
               numberList.add(new Four());
               i++;
            }
            else if (highscore.substring(i, i+1).equals("5")){
               numberList.add(new Five());
               i++;
            }
            else if (highscore.substring(i, i+1).equals("6")){
               numberList.add(new Six());
               i++;
            }
            else if (highscore.substring(i, i+1).equals("7")){
               numberList.add(new Seven());
               i++;
            }
            else if (highscore.substring(i, i+1).equals("8")){
               numberList.add(new Eight());
               i++;
            }
            else if (highscore.substring(i, i+1).equals("9")){
               numberList.add(new Nine());
               i++;
            }
            else{
               numberList.add(new Zero());
               i++; 
            }
        }
        
        
    }
    
    public ArrayList<Actor> getNumberList(){
        return numberList; 
    }
}
