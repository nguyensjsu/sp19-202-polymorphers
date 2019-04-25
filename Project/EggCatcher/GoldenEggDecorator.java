import greenfoot.*;
public class GoldenEggDecorator extends WhiteEgg 
{
    private GreenfootImage goldenEggImage = new GreenfootImage("GoldenEgg.png");

    /**
     * Constructor for objects of class GoldenEggDecorator
     */
    public GoldenEggDecorator()
    {
        goldenEggImage.scale(30,45);
        setImage(goldenEggImage);
    }
    
    
    
    /**
     * An example of a method - replace this comment with your own
     * 
     * @param  y   a sample parameter for a method
     * @return     the sum of x and y 
     */
    public int eggValue()
    {
        return 10;
    }
}
