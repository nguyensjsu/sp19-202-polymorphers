import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * implementation for SwitchModeButton
 */
public class SwitchModeButton extends Button
{
    GreenfootImage switchButtonImage = new GreenfootImage("switchModeButton.png");
    GreenfootImage switchButtonPressedImage = 
    new GreenfootImage("switchModeButtonPressed.png");
    private boolean easyStrategy = true; // easyMode
    private IDifficultyStrategy easyMode;
    private IDifficultyStrategy hardMode;
   
    
    public SwitchModeButton(){
        setImage(switchButtonImage);
        
        easyMode = new IDifficultyStrategy() {
            public int getSpeed() {
               return 3;
            }
            public String getMode() {
                return "Easy Mode";
            }
        };
        
        hardMode = new IDifficultyStrategy() {
            public int getSpeed() {
               return 4;
            }
            public String getMode() {
                return "Hard Mode";
            }
        };
        
        Menu.initialStrategy = easyMode;
    }
    
    public void act() 
    {
        if (Greenfoot.mouseClicked(this)) {                
            if ( Menu.initialStrategy == hardMode ) {
                // easy
                Menu.initialStrategy = easyMode;
            } else if (Menu.initialStrategy == easyMode) {
                //hard
                Menu.initialStrategy = hardMode;
            }
        }
    }    
}
