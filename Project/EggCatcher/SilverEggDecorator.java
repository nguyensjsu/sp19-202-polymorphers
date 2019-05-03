import greenfoot.*;

public class SilverEggDecorator extends WhiteEgg
{
    private GreenfootImage silverEggImage = new GreenfootImage("SilverEgg.png");

    /**
     * Constructor for objects of class SilverEggDecorator
     */
    public SilverEggDecorator(IDifficultyStrategy initial)
    {
        super(initial);
        silverEggImage.scale(30,45);
        setImage(silverEggImage);
    }
    
    public SilverEggDecorator() {
    }

    
    
    public int eggValue()
    {
        return 5;
    }
}
