import java.util.*;
/**
 * This .
 *
 * @author Mirek
 * @version 17 Oct. 2014
 */
public class CarSearch
{
    // instance variables - replace the example below with your own
    private CarList list;

    public CarSearch()
    {
        list = new CarList();
    }

    public void byReg()
    {
        System.out.println("Please enter the registration number:");
        Scanner getReg = new Scanner(System.in);
        String carReg = getReg.nextLine();
        String regex = "^[A-Za-z0-9]*$";
        boolean check = carReg.matches(regex);
        if(check)
        {
            if(carReg.length() <= 6 && carReg.length() >=1)
            {
                boolean find = false;
                for(String i :list.getAllDetails())
                {
                    String[] detail = i.split(",");
                    if(detail[0].toLowerCase().contains(carReg.toLowerCase()))
                    {
                        find = true;
                        System.out.println(i);
                    }
                }
                if(find == false)
                    System.out.println("No such car with this Registration Number.");
            }
            else
                System.out.println("Error: Please only enter 1-6 characters!");
        }
        else
            System.out.println("Error: Please only enter English alphabet or digit!");
    }

    public void byMakeAndModel()
    {
        System.out.println("Please enter the Make");
        Scanner getMake = new Scanner(System.in);
        String carMake = getMake.nextLine();
        String regex = "^[A-Za-z0-9]*$";
        boolean checkMake = carMake.matches(regex);
        if(checkMake)
        {
            System.out.println("Please enter the Model");
            Scanner getModel = new Scanner(System.in);
            String carModel = getModel.nextLine();
            boolean checkModel = carModel.matches(regex);
            if(checkModel)
            {
                boolean find = false;
                for(String i :list.getAllDetails())
                {
                    String[] detail = i.split(",");
                    if(detail[3].toLowerCase().contains(carMake.toLowerCase()) && (detail[4].toLowerCase().contains(carModel.toLowerCase()) || carModel.toLowerCase().equals("any")))
                    {
                        find = true;
                        System.out.println(i);
                    }
                }
                if(find == false)
                    System.out.println("No such car with this Car Make and Car Model");
            }
            else
                System.out.println("Error: Please only enter English alphabet or digit!");
        }
        else
            System.out.println("Error: Please only enter English alphabet or digit!");
    }

    public void byAge()
    {
        try
        {
            System.out.println("Please enter in the Age");
            Scanner getAge = new Scanner(System.in);
            int carAge = getAge.nextInt();
            if(carAge >= 0)
            {
                boolean find = false;
                for(String i :list.getAllDetails())
                {
                    String[] detail = i.split(",");
                    if(2017 - Integer.parseInt(detail[1]) <= carAge)
                    {
                        find = true;
                        System.out.println(i);
                    }
                }
                if(find == false)
                    System.out.println("No such car with this maximum age");
            }
            else
                System.out.println("Error: the age of car must be a non-negative integer!");
        }
        catch(Exception e)
        {
            System.out.println("Error: Please enter a number!");
        }
    }

    public void byPrice()
    {
        try
        {
            System.out.println("Please enter the minimum Price");
            Scanner getPrice = new Scanner(System.in);
            int minPrice = getPrice.nextInt();
            if(minPrice > 0)
            {
                System.out.println("Please enter the maximum Price");
                int maxPrice = getPrice.nextInt();
                if(maxPrice >= minPrice)
                {
                    boolean find = false;
                    for(String i :list.getAllDetails())
                    {
                        String[] feature = i.split(",");
                        if(minPrice <= Integer.parseInt(feature[5]) && maxPrice >= Integer.parseInt(feature[5]))
                        {
                            find = true;
                            System.out.println(i);
                        }
                    }
                    if(find == false)
                        System.out.println("No such car with this range");
                }
                else
                    System.out.println("Error: the maximum price should be equal to or greater than the minimum price!");
            }
            else
                System.out.println("Error: the price of car must be a positive integer!");
        }
        catch(Exception e)
        {
            System.out.println("Error: Please enter a number!");
        }
    }
}
