/**
 * Write a description of class ThreeEggState here.
 * 
 * @author Shivam Waghela
 */
public class ThreeEggState implements IEggState
{
   
    /**
     * Constructor for objects of class NoEggState
     */
    public ThreeEggState()
    {
    }

    
    /**
     * Change to FullEggState
     */
    public IEggState nextState() {
        return new FullEggState();
    }
}
