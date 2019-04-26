/**
 * Write a description of class FullEggState here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class FullEggState implements IEggState
{
  
    /**
     * Constructor for objects of class FullEggState
     */
    public FullEggState()
    {
    }

   /**
    * Remain in the same state
    */
   public IEggState nextState() {
        return new FullEggState();
    }
}
