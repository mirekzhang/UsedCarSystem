
/**
 * This class stores the details of a car, including Registration Number, Year Made, Colour,
 * Car Make, Car Model and Price.
 * @author Mirek
 * @version 17 Oct. 2017
 */
public class Car
{
    // instance variables - replace the example below with your own
    private String carReg;
    private int yearMade;
    private String colour;
    private String carMake;
    private String carModel;
    private int price;

    /**
     * Constructor for objects of class Car
     */
    public Car()
    {
        // initialise instance variables
        carReg = "";
        yearMade = 0;
        colour = "";
        carMake = "";
        carModel = "";
        price = 0;
    }

    public Car(String newReg, String newYear, String newColour, String newMake, String newModel, String newPrice)
    {
        carReg = newReg;
        yearMade = Integer.parseInt(newYear);
        colour = newColour;
        carMake = newMake;
        carModel = newModel;
        price = Integer.parseInt(newPrice);
    }

    public String getCarMake()
    {
        return carMake;
    }

    public String getCarModel()
    {
        return carModel;
    }

    public String getCarReg()
    {
        return carReg;
    }

    public String getColour()
    {
        return colour;
    }

    public String getDetail()
    {
        return carReg + "," + yearMade + "," + colour + "," + carMake + "," + carModel + "," + price;
    }

    public int getPrice()
    {
        return price;
    }

    public int getYearMade()
    {
        return yearMade;
    }

    public void setCarMake(String newMake)
    {
        carMake = newMake;
    }

    public void setCarModel(String newModel)
    {
        carModel = newModel;
    }

    public void setCarReg(String newReg)
    {
        carReg = newReg;
    }

    public void setColour(String newColour)
    {
        colour = newColour;
    }

    public void setPrice(int newPrice)
    {
        price = newPrice;
    }

    public void setYearMade(int newYear)
    {
        yearMade = newYear;
    }
}
