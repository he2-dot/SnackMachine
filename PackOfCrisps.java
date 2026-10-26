
/**
 * Creates an object that acts like a pack of crisps. This means it can be 
 * closed/open, empty/contain crisps, has its own flavour and can be eaten from.
 * 
 *
 * @author Holly Essen
 * @version 01/12/2025
 */
public class PackOfCrisps
{
    // determines if a pack is open or not
    boolean open;
    // determines the number of crisps in an individual pack
    int numOfCrisps;
    // determines the flavour of the crisps in the pack
    String flavour;

    /**
     * Creates a closed pack of crisps containing 20 crisps
     * with a specified flavour.
     * 
     * @param flavourOfCrisps the crisp flavour.
     */
    public PackOfCrisps(String flavourOfCrisps)
    {
        // the pack starts of as being closed (not open)
        open = false;
        // sets the max number of crisps in a pack
        numOfCrisps = 20;
        // sets the flavour of the crisps
        flavour = flavourOfCrisps;
    }

    /**
     * decides if the pack is empty by checking if the number of crisps is 
     * equal to 0.
     * @return a boolean about if the pack is empty or not.
     */
    public boolean empty()
    {
        //when the number of crisps is zero, the pack is empty
        if (numOfCrisps == 0)
        {
            return true;
        }
        else 
        {
            return false;
        }
    }
    
    /**
     * decides if the pack is open or closed.
     * @return a boolean about if the pack is open or closed.
     */
    public boolean isClosed() 
    {
        if (open == false)
        {
            return true;
        }
        else 
        {
            return false;
        }
    }
    
    /**
     * This opens the pack of crisps.
     */
    public void open() 
    {
        open = true;
    }
    
    /**
     * @return the flavour of the crisps.
     */
    public String getFlavour() 
    {
        return flavour;
    }
    
    /**
     * This enables an individual crisp to be eaten by checking if the pack
     * is open and if its not empty, then reducing the amount of crisps by 1.
     */
    public void eatCrisp() 
    {
        //when the pack is open, a crisp can be eaten
        if (open == true)
        {
            //when the pack contains one or more crisps, they'll be eaten
            if (numOfCrisps >= 1) 
            {
                numOfCrisps--;
            }
            else 
            {
                System.out.println("The packet is empty!");
            }
        }
        else 
        {                
             System.out.println("Need to open the packet first!");
         }
    }
}