/**
 * Write a description of class OneEggState here.
 * 
 * @author Shivam Waghela
 */
public class OneEggState implements IEggState
{
   
    /**
     * Constructor for objects of class NoEggState
     */
    public OneEggState()
    {
    }

    
    /**
     * Change to TwoEggState
     */
    public IEggState nextState() {
        return new TwoEggState();
    }
}
