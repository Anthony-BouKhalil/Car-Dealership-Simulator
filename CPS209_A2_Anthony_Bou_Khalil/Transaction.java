/**
   Name: Anthony Bou Khalil
*/
//Used to make the members of these package accessible for this application
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Random;

public class Transaction 
{
	//Declaring instance variables
	private int transactionID;
	private Calendar transactionDate;
	private Car car;
	private String salesPerson;
	private String transactionType;
    private Double salePrice;
	
	/**
       A constructor that initializes transactionID, transactionDate, car, salesPerson, transactionType and salePrice with given values
       @param transactionID the given transactionID, @param transactionDate the given transactionDate 
       @param car the given car, @param transactionType the given transactionType 
       @param salePrice the given salePrice
    */
	public Transaction(int transactionID, Calendar transactionDate, Car car, String salesPerson, String transactionType, double salePrice)
	{
		this.transactionID = transactionID;
		this.transactionDate = transactionDate;
		this.car = car;
		this.salesPerson = salesPerson;
		this.transactionType = transactionType;
		this.salePrice = salePrice;
	}
	
    /**
       Gives a String representation of the returned Car for car purchases
       @return "ID: " + transactionID + " " + sdf.format(transactionDate.getTime()) + " " + transactionType + " SalesPerson: " + salesPerson + " Car: " + car.display();
    */
	public String display()
	{
		SimpleDateFormat sdf = new SimpleDateFormat("EEE, MMM dd, yyyy");
		if (transactionDate == null)
		{
			System.out.println("transactionDate is null");
		}
		if (car == null)
		{
			System.out.println("car is null");
		}
		
		return "ID: " + transactionID + " " + sdf.format(transactionDate.getTime()) + " " + transactionType + " SalesPerson: " + salesPerson + " Car: " + car.display();
	}
	
	/**
       Sets the transactionDate
    */  
	public Calendar setNewDate() 
	{
		Random r = new Random();
		int randomNum = r.nextInt(4-1) + 1;
		int dayOfMonth = transactionDate.get(Calendar.DAY_OF_MONTH);
		int dayOfWeek  = transactionDate.get(Calendar.DAY_OF_WEEK);

		transactionDate.set(Calendar.DAY_OF_WEEK, dayOfWeek + randomNum);
		transactionDate.set(Calendar.DAY_OF_MONTH, dayOfMonth + randomNum);
		return transactionDate;
	}
	
	/**
       Accesses the transactionID
       @return transactionID
    */
	int getTransactionID() 
	{
		return transactionID;
	}

	/**
       Accesses the transactionDate
       @return transactionDate
    */
	public Calendar getDate() 
	{
		SimpleDateFormat sdf = new SimpleDateFormat("EEE, MMM dd, yyyy");
		System.out.println(sdf.format(transactionDate.getTime()));
		return transactionDate;
	}
	
	/**
       Accesses the transactionDate Month
       @return transactionDate.get(Calendar.MONTH)
    */
	public int getMonth()
	{
		return transactionDate.get(Calendar.MONTH);
	}
	
	/**
       Accesses the transactionType
       @return transactionType
    */
	public String getTransactionType()
	{
		return transactionType;
	}
	
	/**
       Accesses the car
       @return car
    */
	public Car getCar()
	{
		return car;
	}
	
	/**
       Accesses the salesPerson
       @return salesPerson
    */
	public String getSalesPerson()
	{
		return salesPerson;
	}
	
	/**
       Accesses the salePrice
       @return salePrice
    */
	public double getPrice()
	{
		return salePrice;
	}
}