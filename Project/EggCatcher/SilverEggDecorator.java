import greenfoot.*;

public class SilverEggDecorator extends WhiteEgg
{
    private GreenfootImage silverEggImage = new GreenfootImage("SilverEgg.png");

    /**
     * Constructor for objects of class SilverEggDecorator
     */
    public SilverEggDecorator()
    {
        silverEggImage.scale(30,45);
        setImage(silverEggImage);
    }

    
    
    public int eggValue()
    {
        return 5;
    }
}
