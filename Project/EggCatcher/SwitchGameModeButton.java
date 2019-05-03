import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * implementation for SwitchGameModeButton
 */
public class SwitchGameModeButton extends Button
{
    GreenfootImage switchButtonImage = new GreenfootImage("switchModeButton.png");
    GreenfootImage switchButtonPressedImage = 
    new GreenfootImage("switchModeButtonPressed.png");
    private IGameDifficultyStrategy easyMode;
    private IGameDifficultyStrategy hardMode;
   
    
    public SwitchGameModeButton(){
        setImage(switchButtonImage);
        
        easyMode = new IGameDifficultyStrategy() {
            public int getSpeed() {
               return 2;
            }
            public String getMode() {
                return "Easy Mode";
            }
        };
        
        hardMode = new IGameDifficultyStrategy() {
            public int getSpeed() {
               return 4;
            }
            public String getMode() {
                return "Hard Mode";
            }
        };
        
        GameMenuWorld.currentStrategy = easyMode;
    }
    
    public void act() 
    {
        if (Greenfoot.mouseClicked(this)) {                
            if ( GameMenuWorld.currentStrategy == hardMode ) {
                // easy
                GameMenuWorld.currentStrategy = easyMode;
            } else if (GameMenuWorld.currentStrategy == easyMode) {
                //hard
                GameMenuWorld.currentStrategy = hardMode;
            }
        }
    }    
}
