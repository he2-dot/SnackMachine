import java.util.HashSet;
/**
 * This class creates a pocket for the Student class so that the students
 * have a way of storing pennies before inserting them into the snack 
 * machine.
 *
 * @author Holly Essen
 * @version 01/12/2025
 */
public class Pocket
{
    // Holds the list of penny objects in the pocket.
    HashSet<Penny> pocketPennies; 

    /**
     * Creates a pocket which already has a predetermined amount of pennies
     * in it.
     * 
     * @param sizeOfPocket The maximum amount of pennies the pocket can store
     */
    public Pocket(int sizeOfPocket)
    {
        // creates a new arrayList of penny objects.
        pocketPennies = new HashSet<Penny>();
        
        for (int currentPenny = 0; currentPenny < sizeOfPocket; currentPenny++) 
        {
            pocketPennies.add(new Penny());
        } 
        
    }

    /**
     * Counts the amount of Penny objects in the pocket.
     * 
     * @return Number of pennies in the pocket.
     */
    public int pennyCount()
    {
        return pocketPennies.size();
    }
    
    /**
     * Removes and then returns a Penny removed from the pocket.
     * 
     * @return The penny that was removed
     * @return There are no pennies available to remove.
     */
    public Penny removePenny() 
    {
        //finds a penny in the pocket and removes it
        for (Penny currentPenny : pocketPennies) 
        {
            if (pocketPennies.size() > 0) 
            {
                pocketPennies.remove(currentPenny);
                return currentPenny;
            }
        }
        return null;
    }
}