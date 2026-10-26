import java.util.Random;
import java.util.ArrayList;
/**
 * Creates a snack bar where different students can buy their own unique favourite
 * crisp flavour, eat it, then throw it away. 
 * This repeats over a specified number of steps, and each step has a description
 * of the snack machine and student's actions.
 *
 * @author Holly Essen
 * @version 01/12/2025
 */
public class SnackBar
{
    // creates a random object generator
    Random randomObject;
    // creates a list of crisp flavours
    String[] crispFlavours;
    // creates the snack machine in the snack bar
    SnackMachine currentMachine;
    // creates a list of students
    ArrayList<Student> students;
    /**
     * This creates a snack bar with an assortment of different crisp flavours,
     * a snack machine filled with random crisp flavours, and a list of students
     * each with their own random favourite crisp flavour.
     * 
     * @param numOfStudents number of students in snack bar
     * @param maxNumOfPacks capacity of the snack machine
     * @param costOfPack cost of each pack in the snack machine
     */
    public SnackBar(int numOfStudents, int maxNumOfPacks, int costOfPack)
    {
        //creates a new random generator
        randomObject = new Random();
        //creates a list of crisp flavour names
        crispFlavours = new String[]{"Salt & Vinegar", "Cheese & Onion", "Prawn Cocktail", "Ready Salted"};
        //creates a new snack machine in the snack bar
        currentMachine = new SnackMachine(maxNumOfPacks, costOfPack);
        
        //adds a set amount of crisp packets to the snack machine with random flavours
        for (int currentPack = 0; maxNumOfPacks > currentPack; currentPack++ ) 
        {
            PackOfCrisps packetFlavour = new PackOfCrisps(randomFlavour());
            currentMachine.addPack(packetFlavour);
        }
        
        // creates a new arraylist of students
        students = new ArrayList<Student>();
        //provides each student their own random favourite crisp flavour
        for (int currentStudent = 0; numOfStudents > currentStudent; currentStudent++)
        {
            students.add(new Student(randomFlavour(), currentMachine));
        }
    }
    
    /**
     * This method randomly selects a crisp flavour.
     * 
     * @return a random crisp flavour
     */
    private String randomFlavour()
    {
        //creates a random flavour generator
        int randomFlavourNum = randomObject.nextInt(crispFlavours.length);
        return crispFlavours[randomFlavourNum];
    }
    
    /**
     * Describes how many students are at the snack bar, and how many
     * of each flavour of crisps the snack machine has.
     */
    public void describe()
    {
        System.out.println("The SnackBar has " + students.size() + " hungry students.");
        System.out.println("The SnackMachine has:");
        System.out.println(currentMachine.countPacks(crispFlavours[0]) + " packets of " + crispFlavours[0]);
        System.out.println(currentMachine.countPacks(crispFlavours[1]) + " packets of " + crispFlavours[1]);
        System.out.println(currentMachine.countPacks(crispFlavours[2]) + " packets of " + crispFlavours[2]);
        System.out.println(currentMachine.countPacks(crispFlavours[3]) + " packets of " + crispFlavours[3]);
        
    }
    
    /**
     * Over a specified number of steps, each step involves picking a random
     * student to buy and eat their favourite crisp flavour from the snack
     * machine.
     * 
     * @param nSteps the number of steps random students buy packs from the machine
     */
    public void runSnackBar(int nSteps) 
    {
        //ensures theres enough students to buy packs of crisps from the 
        //snack machine
        int timeStep = 1;
        if (students.size() > 0)
        {
            //each step involves a random student buying their 
            //favourite flavour of crisps from the machine
            for (int currentStep = 0; currentStep < nSteps; currentStep++)
            {
                System.out.println("Time Step " + timeStep++);
            
                describe();
                
                //creates a random student generator
                int randomStudentNum = randomObject.nextInt(students.size());
                Student currentStudent = students.get(randomStudentNum);
                currentStudent.snackTime();
            }
        }
        else 
        {
            System.out.println("There are no students at the snack bar");
        }
    }
    
    /**
     * allows the snackBar to be run without blueJ.
     * 
     * @param args The first item in the string creates the number of 
     * students in the snack bar, the second item determines the number 
     * of steps the snack bar will take.
     */
    public static void main(String[] args)
    {
        //creates a new snackbar class to be run
        SnackBar snackBar = new SnackBar(Integer.parseInt(args[0]), 100, 1);
        snackBar.runSnackBar(Integer.parseInt(args[1]));
        
    }
}