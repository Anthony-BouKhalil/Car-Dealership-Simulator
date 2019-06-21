/**
   Name: Anthony Bou Khalil
*/
//Used to make the members of these packages accessible this application
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class CarDealershipSimuator 
{

	  public static void main(String[] args) throws IOException
	  {
		  //Declaring variables and object references
		  SalesTeam sales = new SalesTeam();
		  CarDealership dealership = new CarDealership();
		  Car currentCar = null;
		  String currentString = null;
		  int VIN = -1;
		  int id = -1;
		  
		  //Create some new cars of different types
		  ArrayList<Car> newCars = new ArrayList<Car>();
		  
		  //Scanner Object called scanner
		  Scanner scanner = new Scanner(System.in);
		  System.out.print(">");
		  
		  //While the scanner has another line
		  while (scanner.hasNextLine())
		  {
			  try 
			  {
			  String inputLine = scanner.nextLine();				//Read the input line 
			  if (inputLine == null || inputLine.equals("")) 
	          {
				System.out.print("\n>");
	            continue;
			  }
			  
			  Scanner commandLine = new Scanner(inputLine);			//Scanner object called commandLine that reads from the inputLine scanner
			  String command = commandLine.next();					//Read the next word from the commandLine scanner 
			  
			  //Check if the word is equal to null or the empty string and if so, it will be caught by the (NoSuchElementException e)
			  if (command == null || command.equals("")) 
			  {
	             System.out.print("\n>");
		         continue;
	          }
			  
			  //Check if the word is equal to "L" and cars have been previously added, if so, call the dealership object’s displayInventory() method
			  else if (command.equals("L"))
			  {
				  dealership.displayInventory();
			  }
			  
			  //Check if the word is equal to "Q" or "QUIT" and if so, quit the program
			  else if (command.equals("Q") || command.equals("QUIT"))
			  {	  
				  System.exit(0);
			  }
			  
			  //Check if the word is equal to "BUY" and check if the integer from the current input line represents a valid VIN of a car the user wants to buy,
			  //if so, call the dealership object’s buyCar(VIN) method
			  else if (command.equals("BUY"))
			  {
				  VIN = commandLine.nextInt(); 
				  String s = dealership.buyCar(VIN);
				  currentString = s;
			  }
			  
			  //Check if the word is equal to "SALES" and if so, call the dealership object’s Sales2019() method
			  else if (inputLine.equals("SALES"))
			  {
				  dealership.Sales2019();
			  }
			  
			  //Check if the word is equal to "RET" and if so, call the dealership object’s returnCar(VIN) method
			  else if (command.equals("RET"))
			  {
					VIN = commandLine.nextInt(); 
				    dealership.returnCar(VIN); 
			  }
			  
			  //Check if the word is equal to "ADD" and if so, read the data from "cars.txt" and 
			  //call the dealership object’s addCars(ArrayList<Car> newCars) method
			  else if (command.equals("ADD"))
			  {
					String[] name = new String[30];
				    String filename = "cars.txt";
				    Scanner input = new Scanner(new File(filename)); 
				    
						int words = 0; 
						Vehicle.PowerSource power = null;
						Car.Model model = null;
						boolean awd = false;
						while (input.hasNextLine()) 
						{ 
							words = 0;
						    String fileLine = input.nextLine() ;
						    
						    Scanner in = new Scanner(fileLine); 
					        while (in.hasNext())
					        {
					        	name[words] = in.next();
					        	words++;
						    }
					        
					        if (name[2].equals("SEDAN"))
					        {
					        	model = Car.Model.SEDAN;
					        }
					        else if (name[2].equals("MINIVAN"))
					        {
					        	model = Car.Model.MINIVAN;
					        }
					        else if (name[2].equals("SPORTS"))
					        {
					        	model = Car.Model.SPORTS;
					        }
					        else if (name[2].equals("SUV"))
					        {
					        	model = Car.Model.SUV;
					        }
					        
					    	if (name[3].equals("GAS_ENGINE"))
					    	{
					    		power = Vehicle.PowerSource.GAS_ENGINE;
					    	} 
					    	
					    	else if (name[3].equals("ELECTRIC_MOTOR"))
					    	{
					    		power = Vehicle.PowerSource.ELECTRIC_MOTOR;
					    	}
					    	
					    	if (name[6].equals("2WD"))
					    	{
					    		awd = false;
					    	} 
					    	else if (name[6].equals("AWD"))
					    	{
					    		awd = true;
					    	}
					    	else if (!(name[6].equals("2WD")) || !(name[6].equals("AWD")))
					    	{
					    		throw new NumberFormatException("All cars must either be AWD or 2WD.");
					    	}
					    	
					    	if (words == 9)
					    	{
					    		int rechargeTime = Integer.parseInt(name[8]);
					    		newCars.add(new ElectricCar(name[0], name[1], model, power, Double.parseDouble(name[4]),
						        		Integer.parseInt(name[5]), awd, Double.parseDouble(name[7]), rechargeTime));
					    	} 
					        else if (words == 8)
					    	{
					    		newCars.add(new Car(name[0], name[1], model, power, Double.parseDouble(name[4]),
						        		Integer.parseInt(name[5]), awd, Double.parseDouble(name[7])));
					    	}
					    	dealership.addCars(newCars);
						}
			  } 
			  
			  //Check if the word is equal to "SPR" and cars have been previously added, if so, call the dealership object’s sortByPrice() method
			  else if (command.equals("SPR"))
			  {
				  dealership.sortByPrice();
			  }
			  
			  //Check if the word is equal to "SSR" and cars have been previously added, if so, call the dealership object’s sortBySafetyRating() method
			  else if (command.equals("SSR"))
			  {
				  dealership.sortBySafetyRating();
			  }
			  
			  //Check if the word is equal to "SMR" and cars have been previously added, if so, call the dealership object’s sortByMaxRange() method
			  else if (command.equals("SMR"))
			  {
				  dealership.sortByMaxRange();
			  }
			  
			  //Check if the word is equal to "FPR" and check if read there are 2 valid double values from the current input line representing the min and max price range,
			  //and if so, call the dealership object’s filterByPrice(double minPrice, double maxPrice) method
			  else if (command.equals("FPR"))
			  {
				  double minPrice = 0; 
				  double maxPrice = 0;
				  //Filter
				  if (!commandLine.hasNextDouble())
				  {				  
					  System.out.println("Invalid arguements");
					  continue;
				  }
				  minPrice = commandLine.nextDouble();
				  if (!commandLine.hasNextDouble())
				  {				  
					  System.out.println("Invalid arguements");
					  continue;
				  }	  
			      maxPrice = commandLine.nextDouble();
			      if (minPrice < 0 || maxPrice < 0 || minPrice > maxPrice)
			      {				  
					  System.out.println("Invalid arguements");
					  continue;
				  }	
				  dealership.filterByPrice(minPrice,maxPrice);
			  }
			  
			  //Check if the word is equal to "FEL" and if so, call the dealership object’s filterByElectric() method
			  else if (command.equals("FEL"))
			  {
				  dealership.filterByElectric();
			  }
			  
			  //Check if the word is equal to "FAW" and if so, call the dealership object’s filterByAWD() method
			  else if (command.equals("FAW"))
			  {
				  dealership.filterByAWD();
			  }
			  
			  //Check if the word is equal to "FCL" and if so, call the dealership object’s filtersClear() method
			  else if (command.equals("FCL"))
			  {
				  dealership.filtersClear();
			  }
			 
			  //Different command for SALES
			  else if (command.equals("SALES"))
			  {
				  String option = commandLine.next();
				  
				  //Check if option is equal to "TEAM" and if so, call the sales object’s returnAllSalesPersons() method
				  if (option.equals("TEAM"))
				  {
					  System.out.println(sales.returnAllSalesPersons());
				  }
				  
				  //Check if option is equal to "STATS" and if so,
				  //call the dealership object’s returnTotalSales(), returnTotalSold(), returnAverageSales(), returnTotalReturned() and returnBestMonth() methods
				  else if (option.equals("STATS"))
				  {
					  System.out.print("Total Sales: ");
					  dealership.returnTotalSales();
					  System.out.print(" Total Sold: ");
					  dealership.returnTotalSold();
					  System.out.print(" Avg Sales: ");
					  dealership.returnAverageSales();
					  System.out.print(" Total Returned: ");
					  dealership.returnTotalReturned();
					  System.out.print(" Best Month:");
					  dealership.returnBestMonth();
					  System.out.println("");
				  }
				  
				  //Check if option is equal to "TOPSP" and if so, call the dealership object’s returnTopSalesPerson() method
				  else if (option.equals("TOPSP"))
				  {
					  dealership.returnTopSalesPerson();
					  System.out.println("");
				  }
				  
				 //Check if option is not equal to a number between 0 and 11 (inclusive) and if so, print an error message
				  else if (Integer.parseInt(option) < 0 || Integer.parseInt(option) > 11)
				  {
					  System.out.println("Enter a valid month");
				  }
				  
				  //Check if option is equal to a number between 0 and 11 (inclusive) and if so, call the sales object’s returnMonthSales(month) method
				  else if (Integer.parseInt(option) >=0 && Integer.parseInt(option) <=11)
				  {
					  dealership.returnMonthSales(Integer.parseInt(option)); 
				  }
			  }
			  
			  //Exceptions caught
			  else 
				  throw new NoSuchElementException();
			  	  System.out.print("\n>");
		      }
							catch (IOException e) 
							{
								System.out.println("Problem reading file.");
								System.err.println("IOException: " + e.getMessage());	
							}
			  				catch (NoSuchElementException e)
							{
								System.out.println("Error (Null Command): " + e);
								System.out.print("\n>");
							}
							catch (NullPointerException e)
							{
								System.out.println("NullPointerException: " + e.getMessage());
								System.out.print("\n>");
							}
						    catch (NumberFormatException e)
						    {
						    	System.out.println("Error : " + e);
						    	System.out.print("\n>");
						    }
		  	  }
	  }
}