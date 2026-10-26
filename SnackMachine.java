import java.util.ArrayList;
/**
 * This class represents a real world snack machine, that allows for the payment
 * of crisps from the PackOfCrisps class.
 * 
 * It allows the insertion of many Penny and PackOfCrisps objects (if the 
 * maximum amount of crisps allowed in the machine is not exceeded), and provides
 * a pack of crisps if the right number of Penny onjects are inserted.
 * 
 * This class counts the price of the crisps, the amount of crisps of a specified 
 * flavour within the machine, the amount of Penny objects already inserted 
 * (if no packs have been bought yet) and the amount of packs bought from the 
 * machine.
 *
 * @author Holly Essen
 * @version 01/12/2025
 */

public class SnackMachine

{
    // The packets inside of the machine
    ArrayList<PackOfCrisps> packets;
    // The maximum number of packets allowed to be stored in the machine at any time
    int capacity;
    // The cost of one pack of crisps
    int cost;
    // The number of Penny objects in the machine
    int payment;
    // Holds the list of Penny objects in the machine
    ArrayList<Penny> pennies;

    /**
     * Creates a snack machine that sells crisps after a certain number of
     * pennies are inserted into it.
     * 
     * @param maxNumOfPackets sets up the capacity of crisps the machine can hold
     * 
     * @param costOfPack sets up the cost of each pack of crisp
     */
    public SnackMachine(int maxNumOfPackets, int costOfPack)
    {
        // assigns the max number to the machines capacity
        capacity = maxNumOfPackets;
        // initialises the payment as nothing as nothing has been bought yet
        payment = 0;
        // assigns the cost to the cost of each pack
        cost = costOfPack;
        // creates a new empty arraylist to be filled by packs of crisps
        packets = new ArrayList<PackOfCrisps>();
        // creates a new empty penny arraylist to be filled by pennies
        pennies = new ArrayList<Penny>();
    }

    /**
     * returns the price of a pack of crisps.
     * @return The cost of each crisp packet.
     */
    public int getCost() 
    {
        return cost;
    }
    
    /**
     * Adds a pack of crisps object to the machine by checking if the capacity of 
     * the machine has been surpassed, and adding a pack if it has not been 
     * surpassed. if it has been surpassed a statement is printed.
     */
    public void addPack(PackOfCrisps pack) 
    {
        //when the capacity hasnt been surpassed, a pack is added to the machine
        if (capacity > packets.size()) 
        {
            packets.add(pack); 
        }
        else 
        {
            System.out.println("The machine is already at full capacity");
        }
    }
    
    /**
     * Counts the number of packs in the machine of a given string flavour.
     * This method goes through every pack in the machine and increments the
     * numOfFlavours by 1 whenever the specified string flavour is equal to the
     * pack string flavour.
     * 
     * @param flavour the flavour that is going to be counted.
     * @return the amount of packs of a specified flavour.
     */
    public int countPacks(String flavour) 
    {
        // Initialises the number of the specified flavours in the machine as 0
        int numOfFlavours = 0;
        //searches the machine for the crisp flavour, and once one is found
        //its number count is incremented by one
        for (PackOfCrisps currentPacket : packets)
        {
            if(currentPacket.getFlavour().equals(flavour)) 
            {
                numOfFlavours++;
            }
        } 
        
        return numOfFlavours;
    }
    
    /**
     * Inserts a Penny object into the machine, and stores it in the pennies
     * arrayList and payment fields.
     */
    public void insertMoney(Penny penny) 
    {
        pennies.add(penny);
        payment++;
    }
    
    /**
     * Allows the payment and retrieval of a pack of crisps flavour from the machine 
     * after the number of penny objects in the machine is equal to the cost of 
     * a pack, and if there are any pack flavours of the specified String flavour
     * in the machine.
     * 
     * @param flavour the flavour to be bought from the machine.
     * @return a packet of crisps
     */
    public PackOfCrisps buyPack(String flavour) 
    {
        // The newly bought crisps packet.
        PackOfCrisps boughtFlavour;
        //when enough pennies are inserted, a crisp flavour can be bought
        if (pennies.size() >= cost) 
         {
            //searches the machine for the specified crisp flavour
            for (PackOfCrisps currentFlavour : packets) 
            {
                    //once the desired crisp flavour is found, it is bought
                    if(currentFlavour.getFlavour().equals(flavour))
                    {
                        //stores the current crisps flavour as a bought flavour
                        boughtFlavour = currentFlavour;
                        packets.remove(boughtFlavour);
                        //resets the amount of pennies paid to zero
                        payment = 0;
                        return boughtFlavour;
                    }
            }
            System.out.println("The machine is empty!");
            return null;
         }
        
        else 
        {
            System.out.println("insert more pennies!");
            return null;
        }
        
    }
    
    /**
     * Describes the current state of the snack machine.
     */
    public void describe() 
    {
        System.out.println("The snack machine has " + packets.size() + " packets of crisps left and has taken " + payment + " pennies in payment.");
    }
}
