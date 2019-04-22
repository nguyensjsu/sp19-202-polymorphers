/**
 * IEggMissSubject is an Observable interface.
 * 
 * @author Shivam Waghela
 */
public interface IEggMissSubject  
{
    /**
     * Add Observer to Subscribers List
     * @param obj Observer Object
     */
    void addObserver( IEggMissObserver obj ) ;

    /**
     * Remove Observer from Subscription
     * @param obj Observer Object
     */
    void removeObserver( IEggMissObserver obj ) ;

    /**
     * Trigger Events to Observers
     */
    void notifyObservers();
}
