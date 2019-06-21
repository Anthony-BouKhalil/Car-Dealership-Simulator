/**
   Name: Anthony Bou Khalil
*/
//Used to make the members of these packages accessible for this application
import java.io.*;
import java.util.*;
import java.util.Locale.Category;
import java.text.SimpleDateFormat;

public class CarDealership 
{
	  //Declaring variables and object references
	  AccountingSystem accounting = new AccountingSystem();
	  SalesTeam sales = new SalesTeam();
	  Calendar calendar;
	  ArrayList<Integer> vinNumbers = new ArrayList<>();
	  ArrayList<Integer> transactionIDNumbers = new ArrayList<>();
	  ArrayList<Integer> purchasedCars = new ArrayList<>();
	  ArrayList<Car> cars;
	  
	  //Declaring instance variables
	  private Car car ;
	  
	  //Filters
	  boolean electricFilter = false;
	  boolean priceFilter = false;
	  double  priceMin    = 0;
	  double  priceMax    = 0;
	  boolean AWDFilter = false;
	  
	  /**
	     A constructor that initializes array to an empty array list of type Car objects and the array list cars is initialized to array
	  */
	  public CarDealership()
	  {
		  cars = new ArrayList<Car>();
	  }
	  
	  /**
         Adds an array list of cars
         @param newCars is added to cars
      */ 
	  public void addCars(ArrayList<Car> newCars)
	  {
		  cars.addAll(newCars);
		  newCars.clear();
	  }
	  
	  /**
         Calls the yearlySales() method of the AccountingSystem class to print the yearly sales
      */
	  public void Sales2019()
	  {
		  accounting.yearlySales();
	  }
	  

	  /**
	     Removes the index car object from the array list and returns a reference to it
	     @param VIN
	     @return a string representation of a car object or throws an exception if it does not exist
	  */
	  public String buyCar(int VIN)
	  {
		    double price = 0.0;
		  	int index = 0;
		  	String message = "Invalid VIN";
		  	String message2 = "Car already bought";	
		  	
		  	
		  	if (purchasedCars.contains(VIN))
		  	{
		  		throw new NullPointerException(message2);
		  	}
		  	
		  	purchasedCars.add(VIN);
		  	
		  	for (int i = 0; i < cars.size(); i++)
		  	{
		  		vinNumbers.add(cars.get(i).getVIN());
		  	}
		  	
		  	if (!vinNumbers.contains(VIN))
		  	{
		  		throw new NullPointerException(message);
		  	}
		  	
			//Case for last car
			if (cars.get(cars.size()-1).getVIN() == VIN)
			{
				index = cars.size()-1;
				cars.get(cars.size()-1);
				price = cars.get(cars.size()-1).price;
				car = (Car)cars.remove(index);
			}
			
			//Case for other cars
			else if (cars.get(cars.size()-1).getVIN() != VIN)
				for (int i = 0; i < cars.size()-1; i++)
				{
					if (cars.get(i).getVIN() == VIN)
					{
						index = i;
						cars.get(i);
						price = cars.get(index).price;
						car = (Car)cars.remove(index);
					}
				}

			String salesPerson = sales.returnSalesPerson();
			int month = ((int) (Math.random()*(11 - 0))) + 0;
			int day = ((int) (Math.random()*(20 - 1))) + 1;
			
			calendar = new GregorianCalendar(2019,month,day);
			return accounting.add(calendar, car, salesPerson, "BUY", price);	
	  }
	  
	  /**
         Takes a transaction number and adds the associated car to the back of the ArrayList of car objects,
         if the transaction number is not found an exception is thrown
         @param transaction
      */
	  public void returnCar(int transaction)
	  {		  	
		  accounting.getTransaction(transaction);
		  cars.add(accounting.addCarBack(transaction));

		  for (int i = 0; i < purchasedCars.size(); i++)
		  {
			  int VIN = accounting.getVIN(transaction);
			  if (VIN == purchasedCars.get(i))
			  {
				  purchasedCars.remove(i);
			  }
		  }
	  }
	  
	  /**
         Calls the transactionsOfMonth(int month) method of the AccountingSystem class to print the monthly sales
      */
	  public void returnMonthSales(int month)
	  {
		  accounting.transactionsOfMonth(month);
	  }
 
	  /**
         Calls the totalSale() method of the AccountingSystem class to print the net yearly sales 
      */
	  public void returnTotalSales()
	  {
		  System.out.print(accounting.totalSale());
	  }
	  
	  /**
         Calls the totalSold() method of the AccountingSystem class to print the total numbers of cars sold 
      */
	  public void returnTotalSold()
	  {
		  System.out.print(accounting.totalSold());
	  }
	  
	  /**
         Calls the totalReturned() method of the AccountingSystem class to print the total numbers of cars returned 
      */
	  public void returnTotalReturned()
	  {
		  System.out.print(accounting.totalReturned());
	  }
	  
	  /**
         Calls the averageSale() method of the AccountingSystem class to print the average yearly sales  
      */
	  public void returnAverageSales()
	  {
		  System.out.print(accounting.averageSale());
	  }
	  
	  /**
         Calls the bestMonth() method of the AccountingSystem class to print the month with the most car purchases 
      */
	  public void returnBestMonth()
	  {
		  accounting.bestMonth();  
	  }
	  
	  /**
         Calls the topSalesPerson() method of the AccountingSystem class to print the salesperson with the most car sales 
      */
	  public void returnTopSalesPerson()
	  {
		  accounting.topSalesPerson();
	  }
	  
	  /**
         Prints information about cars in the array list based on a set of filter values
      */ 
	  public void displayInventory()
	  {
		  System.out.println("");
		  
		  for (int i = 0; i < cars.size(); i++)
		  {
			Car car = cars.get(i);
			
			if (priceFilter && (car.price < priceMin || car.price > priceMax))
			   continue;
			
			if (electricFilter && car.power != Vehicle.PowerSource.ELECTRIC_MOTOR)
			   continue;
			
			if (AWDFilter && !car.AWD)
			   continue;
			
			System.out.println(car.display());
		  }
		  System.out.println("");
	  }
	  
	  /**
         Sets AWD to false, electric to false and price to false
      */ 
	  public void filtersClear()
	  {
		  electricFilter = false;
		  priceFilter = false;
		  AWDFilter = false;
	  }
	  
	  /**
         Sets price to true, and sets the minPrice and maxPrice
         @param minPrice the this.minPrice
         @param maxPrice the this.maxPrice
      */ 
	  public void filterByPrice(double min, double max)
	  {
		  priceFilter = true;
		  priceMin    = min;
		  priceMax    = max;
	  }
	  
	  /**
         Sets electric to true
      */ 
	  public void filterByElectric()
	  {
		  electricFilter = true;
	  }
	  
	  /**
         Sets AWD to true
      */ 
	  public void filterByAWD()
	  {
		  AWDFilter = true;
	  }
	  
	  /**
         Sorts the car objects by price, from least expensive to most expensive (ascending)
      */
	  public void sortByPrice()
	  {
		  Collections.sort(cars);
	  }
	  
	  /**
         Compares two different Car objects based on their safetyRating in form of Comparator interface
         The sorting is from larger values to smaller values.
         @return 1 if Car a has a bigger value, -1 if smaller, 0 if same
      */
	  private class SafetyRatingComparator implements Comparator<Car>
	  {
	  	public int compare(Car a, Car b)
	  	{
	  	  if      (a.safetyRating < b.safetyRating) return  1;
	  	  else if (a.safetyRating > b.safetyRating) return -1;
	  	  else                                      return  0;		  
	  	}
	  }
	  
	  /**
         Sorts the car objects by safetyRating, from highest safetyRating to lowest safetyRating (descending)
      */
	  public void sortBySafetyRating()
	  {
		Collections.sort(cars,new SafetyRatingComparator());
	  }
	  
	  /**
         Compares two different Car objects based on their maxRange in form of Comparator interface
         The sorting is from larger values to smaller values.
         @return 1 if Car a has a bigger value, -1 if smaller, 0 if same
      */
	  private class RangeComparator implements Comparator<Car>
	  {
	  	public int compare(Car a, Car b)
	  	{
	  	  if      (a.maxRange < b.maxRange) return  1;
	  	  else if (a.maxRange > b.maxRange) return -1;
	  	  else                              return  0;		  
	  	}
	  }
	  
	  /**
         Sorts the car objects by maxRange, from highest maxRange to lowest maxRange (descending) 
      */
	  public void sortByMaxRange()
	  {
		Collections.sort(cars,new RangeComparator());
	  }
}