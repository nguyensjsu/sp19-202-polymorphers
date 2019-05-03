import greenfoot.*;
public class GoldenEggDecorator extends WhiteEgg 
{
    private GreenfootImage goldenEggImage = new GreenfootImage("GoldenEgg.png");

    /**
     * Constructor for objects of class GoldenEggDecorator
     */
    public GoldenEggDecorator(IGameDifficultyStrategy initial)
    {
        super(initial);
        goldenEggImage.scale(30,35);
        setImage(goldenEggImage);
    }
    
    public GoldenEggDecorator() {
    }
    
    /**
     * An example of a method - replace this comment with your own
     * 
     * @param  y   a sample parameter for a method
     * @return     the sum of x and y 
     */
    public int getEggValue()
    {
        return 10;
    }
}
