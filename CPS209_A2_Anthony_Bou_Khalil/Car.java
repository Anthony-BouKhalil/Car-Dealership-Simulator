/**
   Name: Anthony Bou Khalil
*/
import java.util.Collections;
import java.util.Comparator;

public class Car extends Vehicle implements Comparable<Car>
{
	  /**
	     Models that can be used
	     SEDAN
	     SUV
	     SPORTS
	     MINIVAN
	  */
	  public enum Model
	  {
		  SEDAN, SUV, SPORTS, MINIVAN;
	  }
	  
	  //Declaring variables
	  Model   model; 
	  int     maxRange; 
	  double  safetyRating;
	  boolean AWD;
	  double  price;
	  
	  /**
	     A constructor that initializes model of a car to SEDAN
      */
	  public Car()
	  {
		  this.model = Model.SEDAN;
	  }
	  
	  /**
	     A constructor that initializes manuf, color, model, power, safety, range, awd and price with given values
         @param manuf the given manuf, @param color the given color
         @param model the given model, @param power the given power 
         @param safety the given safety, @param range the given range
         @param awd the given awd, @param price the given price
      */
	  public Car(String manuf, String color, Model model, Vehicle.PowerSource power, 
			     double safety, int range, boolean awd, double price)
	  {
		  super(manuf, color, 4, power);
		  this.model = model;
		  this.price = price;
		  AWD = awd;
		  safetyRating = safety;
		  maxRange = range;
	  }
	  
      /**
         Gives a String representation of the Car
         @return for GAS_ENGINE, "VIN: " + VIN + "mfr " + "color " + "price$ " + "SF: " + "safetyRating " + "RNG: " + "maxRange" 
         @return for ELECTRIC_MOTOR, "VIN: " + VIN + "mfr " + "color " + "price$ " + "SF: " + "safetyRating " + "RNG: " + "maxRange " + "batteryType " + "rechargeTime" 
      */
	  public String display()
	  {
		  return super.display() + " " + model + " " + price + "$" + " SF: " + safetyRating + " RNG: " + maxRange;
	  }
	  
      /**
         Overrides the toString method of the superclass
      */
	  public String toString()
	  {
		return "";
	  }
	  
	  /**
         This method compare the this Car object and the other Car object for equality
         Car objects are equal if their model and their AWD variables are equal
         @return true if Car objects are equal, @return false if Car objects are not equal
      */ 
	  public boolean equals(Object other)
	  {
		  Car otherCar = (Car) other;
		  return super.equals(other) && this.model == otherCar.model && this.AWD == otherCar.AWD; 
	  }
	  
	  /**
	     Compares two different Car objects based on their price in form of Comparable interface
	     The sorting is from small values to larger values.
         @return 1 if this one has a bigger value, -1 if smaller, 0 if same
	  */
	  public int compareTo(Car other)
	  {
	    if      (this.price > other.price) return  1;
		else if (this.price < other.price) return -1;
		else                               return  0;
	  }
}