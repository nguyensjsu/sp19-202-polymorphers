/**
 * Write a description of class TwoEggState here.
 * 
 * @author Shivam Waghela
 */
public class TwoEggState implements IEggState
{
   
    /**
     * Constructor for objects of class NoEggState
     */
    public TwoEggState()
    {
    }

    
    /**
     * Change to ThreeEggState
     */
    public IEggState nextState() {
        return new ThreeEggState();
    }
}
