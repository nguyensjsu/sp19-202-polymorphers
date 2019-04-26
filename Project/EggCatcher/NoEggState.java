/**
 * Write a description of class NoEggState here.
 * 
 * @author Shivam Waghela
 */
public class NoEggState implements IEggState
{
   
    /**
     * Constructor for objects of class NoEggState
     */
    public NoEggState()
    {
    }

    
    /**
     * Change to OneEggState
     */
    public IEggState nextState() {
        return new OneEggState();
    }
}
