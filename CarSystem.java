import java.util.*;
/**
 * Write a description of class CarSystem here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class CarSystem
{
    private CarList list;
    private CarSearch search;

    /**
     * Constructor for objects of class CarSystem
     */
    public CarSystem()
    {
        list = new CarList();
        search = new CarSearch();
    }

    public void deleteCar()
    {
        System.out.println("Please enter the registration number");
        Scanner getReg = new Scanner(System.in);
        String carReg = getReg.nextLine();
        if(carReg.length() != 6)
        {  
            System.out.println("Please type the Correct Number");
        }
        else 
        {
            list.deleteCar(carReg);
        }
    }

    public void addCar()
    {
        System.out.println("Please type the detail of the car,split by \",\"");
        Scanner carDetails = new Scanner(System.in);
        String newCar = carDetails.nextLine();
        String[] newCarDetail = newCar.split(",");
        list.addCar(newCarDetail);
    }

    public void search()
    {
        for (int i = 0; i < 1;)
        {
            System.out.println("\nCar Searching Options:");
            System.out.println("(1) By Registration Number");
            System.out.println("(2) By Car Make and Car Model");
            System.out.println("(3) By Age");
            System.out.println("(4) By Price (range)");
            System.out.println("(5) Back to Main Menu");
            Scanner getOption = new Scanner(System.in);
            try
            {        
                int option = getOption.nextInt();
                switch (option)
                {
                    case 1:
                    search.byReg();
                    break;
                    case 2:
                    search.byMakeAndModel();
                    break;
                    case 3:
                    search.byAge();
                    break;
                    case 4:
                    search.byPrice();
                    break;
                    case 5:
                    startSystem();
                    break;
                    default:
                    System.out.println("Error: Please only choose 1-5.");
                    break;
                }
            } 
            catch(Exception e)
            {
                System.out.println("Error: Please enter a number between 1-5");
            }
        }
    }

    public void startSystem()
    {
        for (int i = 0; i < 1;)
        {
            System.out.println("\nWelcome to Used Car Warehouse Database System");
            System.out.println("(1) Search Cars");
            System.out.println("(2) Add Car");
            System.out.println("(3) Delete Car");
            System.out.println("(4) Exit System");
            Scanner getChoice = new Scanner(System.in);
            try
            {
                int choice = getChoice.nextInt();
                switch (choice)
                {
                    case 1:
                    search();
                    break;
                    case 2:
                    addCar();
                    break;
                    case 3:
                    deleteCar();
                    break;
                    case 4:
                    System.out.println("Goodbye!");
                    System.exit(0);
                    break;
                    default:
                    System.out.println("Error: Please only choose 1-4!");
                    break;
                }
            } 
            catch(Exception e)
            {
                System.out.println("Error: Please enter a number between 1-4!");
                startSystem();
            }
        }
    }
}
