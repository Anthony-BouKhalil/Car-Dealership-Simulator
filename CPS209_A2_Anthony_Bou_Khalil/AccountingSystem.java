/**
   Name: Anthony Bou Khalil
*/
//Used to make the members of these packages accessible for this application
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Random;

public class AccountingSystem 
{
	//Declaring instance variables
	private int transactionID;
	private Calendar calendar;
	private Car car;
	private String salesPerson;
	private String type;
	private double salePrice;

	ArrayList<Transaction> transactionArray;       
	private Transaction transaction ;
	
	/**
       A constructor that initializes transactionArray
    */
	public AccountingSystem()
	{
		transactionArray = new ArrayList<Transaction>();
	}
	
	/**
       Adds the date, car, salesperson, type and salePrice to the transactionArray
       @return a String representation of the transaction information of car purchases, 
       "ID: " + transactionID + " " + sdf.format(transactionDate.getTime()) + " " + transactionType + " SalesPerson: " + salesPerson + " Car: " + car.display();
    */ 
	public String add(Calendar date, Car car, String salesPerson, String type, double salePrice)
	{
		this.calendar = date;
		this.car = car;
		this.salesPerson = salesPerson;
		this.type = type;
		this.salePrice = salePrice;
		Random r = new Random();
		int low = 1;
		int high = 99;
		int randNum = r.nextInt(high-low) + low;
		this.transactionID = randNum;
		transaction = new Transaction(transactionID, calendar, car, salesPerson, type, salePrice);
		transactionArray.add(transaction);
		System.out.println(transaction.display());
		return null;
	}
	
	/**
       Adds the date, car, salesperson, type and salePrice of car returns to the transactionArray
       Gives a String representation of the transaction information of car returns, 
       @return "ID: " + transactionID + " " + sdf.format(transactionDate.getTime()) + " " + transactionType + " SalesPerson: " + salesPerson + " Car: " + car.display();
    */ 
	public String add2(int transactionID, Calendar date, Car car, String salesPerson, String type, double salePrice)
	{
		this.calendar = date;
		this.car = car;
		this.salesPerson = salesPerson;
		this.type = type;
		this.salePrice = salePrice;
		this.transactionID = transactionID;
		transaction = new Transaction(transactionID, calendar, car, salesPerson, type, salePrice);
		transactionArray.add(transaction);
		System.out.println(display2(transactionID, date, car, salesPerson, type, salePrice));
		return null;
	}
	
	/**
       Gives a String representation of the transaction information of car returns, 
       @return "ID: " + transactionID + " " + sdf.format(transactionDate.getTime()) + " " + transactionType + " SalesPerson: " + salesPerson + " Car: " + car.display();
    */
	public String display2(int transactionID, Calendar date, Car car, String salesPerson, String type, double salePrice)
	{
		SimpleDateFormat sdf = new SimpleDateFormat("EEE, MMM dd, yyyy");
		
		return "ID: " + transactionID + " " + sdf.format(date.getTime()) + " " + type + " SalesPerson: " + salesPerson + " Car: " + car.display();
	}
	
	/**
       Accesses the VIN of a car
       @return car.getVIN();
    */
	public int getVIN(int id)
	{
		for (int i = 0; i < transactionArray.size(); i++)
		{
			if (id == transactionArray.get(i).getTransactionID())
			{
				return car.getVIN();
			}
		}
		return 0;
	}

	/**
       Gives a String representation of all the transactions of car purchases and returns in the year 2019 
    */ 
	public void yearlySales()
	{	
		for (int i = 0; i < transactionArray.size(); i++)
		{
			transaction = transactionArray.get(i);
			if (transaction == null)
			{
			System.out.println("transaction is null");
			}
			System.out.println(transaction.display());	
		}
	}

	/**
       Retrieves a car object based on the transactionID parameter
       @return car
    */ 
	public Car addCarBack(int target)
	{
		for (int i = 0; i < transactionArray.size(); i++)
		{
			if (target == transactionArray.get(i).getTransactionID())
			{
				car = transactionArray.get(i).getCar();
			}
		}
		return car;
	}
	
	/**
       Gives a String representation of all the transactions of car purchases and returns in the month specified in the parameter of the year 2019
       0 is January, 11 is December 
    */
	public void transactionsOfMonth(int month)
	{
		for (int i = 0; i < transactionArray.size(); i++)
		{
			if (month == transactionArray.get(i).getMonth())
			{
				transaction = transactionArray.get(i);
				System.out.println(transaction.display());
			}
		}
	}
	
	/**
       Calculates the net earnings of car transactions by adding up all the prices of car purchases 
       then subtracting by the price amount of cars returned
       @return totalPrice
    */ 
	public Double totalSale() 
	{
		double totalPrice = 0;
		
		for (int i = 0; i < transactionArray.size(); i++)
		{
			if (transactionArray.get(i).getTransactionType().equals("RET"))
			{
				totalPrice = totalPrice - transactionArray.get(i).getPrice();
			}
			else
				totalPrice = totalPrice + transactionArray.get(i).getPrice();
		}
		return totalPrice;
	}
	
	/**
       Calculates the yearly average earnings of car transactions by adding up all the prices of car purchases 
       then subtracting by the price amount of cars returned and then dividing by 12
       @return totalPrice/12
    */ 
	public Integer averageSale() 
	{
		int totalPrice = 0;
		
		for (int i = 0; i < transactionArray.size(); i++)
		{
			if (transactionArray.get(i).getTransactionType().equals("RET"))
			{
				totalPrice = totalPrice - (int)transactionArray.get(i).getPrice();
			}
			else
				totalPrice = totalPrice + (int)transactionArray.get(i).getPrice();
		}
		return totalPrice/12;
	}
	
	/**
       Retrieves a car object based on the transactionID parameter and then
       calls the add method to add a new Transaction object that contains the date, car, salesperson, type and salePrice to the transactionArray
    */
	public void getTransaction(int target)
	{
		int carExistsCounter = 0;
		int j = 0;
		String message = "No such ID";
		
		for (int i = 0; i < transactionArray.size(); i++)
		{
			if (target == transactionArray.get(i).getTransactionID() && j == 0) 
			{
				j++;
				add2(target, transactionArray.get(i).setNewDate(), transactionArray.get(i).getCar(), transactionArray.get(i).getSalesPerson(), "RET", transactionArray.get(i).getPrice());
				carExistsCounter++;
			}	
		}
		
		if (carExistsCounter == 0)
		{
			throw new NullPointerException(message);
		}
	}
	
	/**
       Computes the totalNumber of cars bought for the year
       @return totalSold
    */ 
	public int totalSold()
	{
		int totalSold = 0;
		
		for (int i = 0; i < transactionArray.size(); i++)
		{
			if (transactionArray.get(i).getTransactionType().equals("BUY"))
			{
				totalSold = totalSold + 1;
			}
		}
		return totalSold;
	}
	
	/**
       Computes the totalNumber of cars returned for the year
       @return totalSold
    */ 
	public int totalReturned()
	{
		int totalReturned = 0;
		for (int i = 0; i < transactionArray.size(); i++)
		{
			if (transactionArray.get(i).getTransactionType().equals("RET"))
			{
				totalReturned = totalReturned + 1;
			}
		}
		return totalReturned;
	}
    
	/**
       Determines which month in 2019 sold the most cars 
       and prints a string representation, monthString[maxMonthValues.get(i)] + ": cars sold - " + maxMonth
    */ 
	public void bestMonth()
	{
		//Counters for the number of cars bought each month
		int janCount = 0;
		int febCount = 0;
		int marCount = 0;
		int aprCount = 0;
		int mayCount = 0;
		int junCount = 0;
		int julCount = 0;
		int augCount = 0;
		int sepCount = 0;
		int octCount = 0;
		int novCount = 0;
		int decCount = 0;
		
		//Arrays that contain the string represntation of the month and the amount of purchases per month
		String[] monthString = {"Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"};
		int[] monthCounters = {janCount, febCount, marCount, aprCount, mayCount, junCount, julCount, augCount, sepCount, octCount, novCount, decCount};
		ArrayList<Integer> values = new ArrayList<>();	//ArrayList values is initialized
		
		//Add the monthCounters to values
        for (int monthCounter : monthCounters) 
        {
            values.add(monthCounter);
        }
        
        //Increments specific monthCounters based on the month and if the transaction object in the transactionArray contain type "BUY"
		for (int i = 0; i < transactionArray.size(); i++)
		{
			if (transactionArray.get(i).getMonth() == 0 && transactionArray.get(i).getTransactionType().equals("BUY"))
			{
				janCount++;
			}
			else if (transactionArray.get(i).getMonth() == 1 && transactionArray.get(i).getTransactionType().equals("BUY"))
			{
				febCount++;
			}
			else if (transactionArray.get(i).getMonth() == 2 && transactionArray.get(i).getTransactionType().equals("BUY"))
			{
				marCount++;
			}
			else if (transactionArray.get(i).getMonth() == 3 && transactionArray.get(i).getTransactionType().equals("BUY"))
			{
				aprCount++;
			}
			else if (transactionArray.get(i).getMonth() == 4 && transactionArray.get(i).getTransactionType().equals("BUY"))
			{
				mayCount++;
			}
			else if (transactionArray.get(i).getMonth() == 5 && transactionArray.get(i).getTransactionType().equals("BUY"))
			{
				junCount++;
			}
			else if (transactionArray.get(i).getMonth() == 6 && transactionArray.get(i).getTransactionType().equals("BUY"))
			{
				julCount++;
			}
			else if (transactionArray.get(i).getMonth() == 7 && transactionArray.get(i).getTransactionType().equals("BUY"))
			{
				augCount++;
			}
			else if (transactionArray.get(i).getMonth() == 8 && transactionArray.get(i).getTransactionType().equals("BUY"))
			{
				sepCount++;
			}
			else if (transactionArray.get(i).getMonth() == 9 && transactionArray.get(i).getTransactionType().equals("BUY"))
			{
				octCount++;
			}
			else if (transactionArray.get(i).getMonth() == 10 && transactionArray.get(i).getTransactionType().equals("BUY"))
			{
				novCount++;
			}
			else if (transactionArray.get(i).getMonth() == 11 && transactionArray.get(i).getTransactionType().equals("BUY"))
			{
				decCount++;
			}
		}
		
		//A second array for monthCounters with the updated values
		int[] monthCounters2 = {janCount, febCount, marCount, aprCount, mayCount, junCount, julCount, augCount, sepCount, octCount, novCount, decCount};
		int maxMonth = monthCounters[0];	//Initially sets the top performing month to the value of the first monthCounter
		
		ArrayList<Integer> maxMonthValues = new ArrayList<>();	//A second ArrayList to hold the top performing month(s)
		
		//Determines the top performing month(s) 
		for (int i = 0; i < monthCounters2.length; i++)
		{
			if (monthCounters2[i] > maxMonth)
			{
				maxMonth = monthCounters2[i];
			}
		}
		
		//Adds the top performing month(s) to the maxMonthValues ArrayList
		for (int i = 0; i < monthCounters2.length; i++)
		{
			if (monthCounters2[i] == maxMonth)
			{
				maxMonthValues.add(i);
			}
		}
		
		//Prints the result
		for (int i = 0; i < maxMonthValues.size(); i++)
		{
			if (i == 0)
			{
				System.out.print(" " + monthString[maxMonthValues.get(i)]);
			}
			else 
				System.out.print(", " + monthString[maxMonthValues.get(i)]);
		}
		
	    System.out.print(": cars sold - " + maxMonth);
	}

	/**
       Determines which salesperson sold the most cars in 2019 
       and prints a string representation, monthString[maxSaleValues.get(i)] + " " + maxSale
    */ 
	public void topSalesPerson() 
	{
		//Counters for the number of sales made for each salesperson 
		int benCount = 0;
		int michaelCount = 0;
		int markCount = 0;
		int leslieCount = 0;
		int andrewCount = 0;
		int aryanCount = 0;
		
		//Arrays that contain the string represntation of the each sales person and the amount of sales per salesperson
		String[] monthString = {"Ben", "Michael", "Mark", "Leslie", "Andrew", "Aryan"};
		int[] saleCounters = {benCount, michaelCount, markCount, leslieCount, andrewCount, aryanCount};
		ArrayList<Integer> values = new ArrayList<>();	//ArrayList values is initialized
		
		//Add the saleCounters to values
        for (int saleCounter : saleCounters) 
        {
            values.add(saleCounter);
        }
        
        //Increments specific saleCounters based on the salesPerson and if the transaction object in the transactionArray contain type "BUY"
		for (int i = 0; i < transactionArray.size(); i++)
		{
			if (transactionArray.get(i).getSalesPerson().equals("Ben") && transactionArray.get(i).getTransactionType().equals("BUY"))
			{
				benCount++;
			}
			else if (transactionArray.get(i).getSalesPerson().equals("Michael") && transactionArray.get(i).getTransactionType().equals("BUY"))
			{
				michaelCount++;
			}
			else if (transactionArray.get(i).getSalesPerson().equals("Mark") && transactionArray.get(i).getTransactionType().equals("BUY"))
			{
				markCount++;
			}
			else if (transactionArray.get(i).getSalesPerson().equals("Leslie") && transactionArray.get(i).getTransactionType().equals("BUY"))
			{
				leslieCount++;
			}
			else if (transactionArray.get(i).getSalesPerson().equals("Andrew") && transactionArray.get(i).getTransactionType().equals("BUY"))
			{
				andrewCount++;
			}
			else if (transactionArray.get(i).getSalesPerson().equals("Aryan") && transactionArray.get(i).getTransactionType().equals("BUY"))
			{
				aryanCount++;
			}
		}
		
		//A second array for saleCounters with the updated values
		int[] saleCounters2 = {benCount, michaelCount, markCount, leslieCount, andrewCount, aryanCount};
		int maxSale = saleCounters[0];	//Initially sets the top salesPerson to the value of the first monthCounter
		
		ArrayList<Integer> maxSaleValues = new ArrayList<>();	//A second ArrayList to hold the top performing salesPerson(s)
		
		//Determines the top performing salesPeron(s) 
		for (int i = 0; i < saleCounters2.length; i++)
		{
			if (saleCounters2[i] > maxSale)
			{
				maxSale = saleCounters2[i];
			}
		}
		
		//Adds the top performing salesPerson(s) to the maxSaleValues ArrayList
		for (int i = 0; i < saleCounters2.length; i++)
		{
			if (saleCounters2[i] == maxSale)
			{
				maxSaleValues.add(i);
			}
		}
		
		//Prints the result
		System.out.print("Top SP:");
		
		for (int i = 0; i < maxSaleValues.size(); i++)
		{
			System.out.print(" " + monthString[maxSaleValues.get(i)]);
		}
		
	    System.out.print(" " + maxSale);
	}
}