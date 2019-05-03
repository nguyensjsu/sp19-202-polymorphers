/**
 * Game Start Command to start the game.
 * 
 * @author Viraj Upadhyay
 */
import greenfoot.*;

public class GameStartCommand implements IMenuCommand 
{
  
    public void execute(){
       Greenfoot.setWorld(new GamePlayWorld(GameMenuWorld.currentStrategy));
    }
}
