import java.util.ArrayList;

/**
 * This class creates a student that will buy their favourite flavour from
 * the snack machine through the pennies in the Pocket class, eat the crisps,
 * then throw the empty pack away.
 *
 * @author Holly Essen
 * @version 01/12/2025
 */
public class Student
{
    // differentiates each student class created by giving them unique IDs.
    private static int STUDENT_ID = 0;
    // The students favourite flavour of crisps
    private String studentFavCrispFlavour;
    // The snack machine the student will buy from
    private SnackMachine chosenSnackMachine;
    // The student's label
    private String idNum;
    // The student's own pocket
    private Pocket studentPocket;
    // The pack of crisps a student buys
    private PackOfCrisps boughtPack;

    /**
     * Specifies the student's ID number, favourite crisp flavour
     * the snack machine they'll use, the amount of pennies they have 
     * and states that they have not bought a pack of crisps yet.
     * 
     * @param flavour Specifies the  student's favourite flavour of crisps.
     * @param machine Specifies what machine the student will buy from.
     */
    public Student(String flavour, SnackMachine machine)
    {
        //increases the student ID number by one so the students are unique
        STUDENT_ID++;
        //provides the student their ID number
        idNum = "student" + STUDENT_ID;
        //Gives the student a new pocket with a limit of 20 pennies
        studentPocket = new Pocket(20);
        //Applies a favourite flavour to the student
        studentFavCrispFlavour = flavour;
        //chooses the machine the student will use
        chosenSnackMachine = machine;
        //allows a pack of crisps to be bought in the future as the student has none
        boughtPack = null;

   }
   
   /**
    * Causes the student to buy a pack of crisps from the snack machine
    * using the pennies in their pocket, and then storing it as a bought
    * pack of crisps.
    *
    */
    private void buyCrisps()
    {
        //checks to see if the student has enough money
       if (chosenSnackMachine.getCost() <= studentPocket.pennyCount())
       {
           //checks if the machine contains the students favourite crisp flavour
           if (chosenSnackMachine.countPacks(studentFavCrispFlavour) >= 1) 
           {
               //places the student's pennies into the machine until it matches
               //the price of the pack of crisps
               while (chosenSnackMachine.getCost() != chosenSnackMachine.payment) 
                    {
                        chosenSnackMachine.insertMoney(studentPocket.removePenny());
                        
                    }
               //stores the pack the student just bought from the machine
               boughtPack = chosenSnackMachine.buyPack(studentFavCrispFlavour);
               
           }
           else
           {
           System.out.println("The machine has run out of " + idNum + "'s " + " favourite " + studentFavCrispFlavour + " crisps");
           }
        }
       else 
       {
           System.out.println(idNum + " doesn't have enough money to buy a pack!");
        } 
   } 
   
   /**
    * Invokes the student to buy a pack of crisps if they have none, open it if its
    * closed, eat all the crisps until the pack is empty, before throwing 
    * the pack away, and declaring the boughtPack field null.
    */
    public void snackTime() 
    {
       //when the student doesnt have a pack of crisps, they buy one from 
       //the machine
       if (boughtPack == null) 
       {
           System.out.println(idNum + " is buying a pack of crisps");
           buyCrisps();
       }
       if (boughtPack != null)
       {
           //when the pack is closed, the student opens it
           if (boughtPack.isClosed()) 
           {
               System.out.println(idNum + " is opening the packet");
               boughtPack.open();
           }
           //when the pack is open, the student eats crisps until 
           //the pack is empty
               System.out.println(idNum + " is eating their favourite " + studentFavCrispFlavour + " crisps");
           while (!boughtPack.empty()) 
           {
                   boughtPack.eatCrisp();
           }
           //when the pack is empty, the student throws it away
               System.out.println(idNum + " has finished the packet!");
               boughtPack = null;
       }
   }

}