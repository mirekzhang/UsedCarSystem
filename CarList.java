import java.util.*;
import java.io.*;
/**
 * This class stores the details of all cars.
 *
 * @author Mirek
 * @version 17 Oct. 2017
 */
public class CarList
{
    // instance variables - replace the example below with your own
    private ArrayList <Car> newCar;
    private String[] carList;

    public CarList()
    {
        newCar = new ArrayList<>();
        loadFile();
    }

    public void loadFile()
    {
        String fileName = "usedcars.txt";
        try
        {
            FileReader inputFile = new FileReader(fileName);
            Scanner parser = new Scanner(inputFile);
            while(parser.hasNextLine())
            {
                String eachCar = parser.nextLine();
                String[] carDetail = eachCar.split(",");
                newCar.add(new Car(carDetail[0],carDetail[1],carDetail[2],carDetail[3],carDetail[4],carDetail[5]));
            }
            inputFile.close();
        }
        catch(IOException e)
        {
            System.out.println("Unexpected I/O error occured");
        }
        catch(Exception e)
        {
            System.out.println(fileName +" not found");
        }
    }

    public void saveToFile() 
    {
        try
        {
            PrintWriter outputFile = new PrintWriter("usedcars.txt");
            for(Car i : newCar)
            {
                outputFile.println(i.getDetail());
            }
            outputFile.close();
        }
        catch(IOException e)
        {
            System.out.println("Unexpected I/O error occured");
        }
    }

    public void listAllCars()
    {
        for(Car i : newCar)
        {
            System.out.println(i.getDetail());
        }
    }

    public void getOneDetail(int num)
    {
        String[] details = new String[newCar.size()];
        int j=0;
        for(Car i : newCar)
        {
            details[j] = i.getDetail();
            j++;
        }
        System.out.println(details[num]);
    }

    public String[] getAllDetails()
    {
        String[] details = new String[newCar.size()];
        int j=0;
        for(Car i : newCar)
        {
            details[j] = i.getDetail();
            j++;
        }
        return details;
    }

    public void addCar(String[] carDetail)
    {
        System.out.println(carDetail.length);
        newCar.add(new Car(carDetail[0],carDetail[1],carDetail[2],carDetail[3],carDetail[4],carDetail[5]));
        try
        {
            saveToFile();
        }
        catch(Exception e)
        {
            System.out.println("Error");
        }
    }

    public void deleteCar(String carReg)
    {
        boolean find = false;
        carList = new String[newCar.size()];
        int j = 0;
        for(Car c : newCar)
        {
            carList[j] = c.getDetail();
            String[] feature = carList[j].split(",");
            if(feature[0].equals(carReg))
            {
                newCar.remove(c);
                find = true;
                saveToFile();
                System.out.println("The car has been deleted sucessfully");
            }
        }
        if (find == false)
        {
            System.out.println("No matching Car");
        }
    }
}
