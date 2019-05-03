/**
 * Write a description of class StartCommand here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import greenfoot.*;

public class StartCommand implements IMenuCommand 
{
  
    public void execute(){
       Greenfoot.setWorld(new Playing(Menu.initialStrategy));
    }
}
