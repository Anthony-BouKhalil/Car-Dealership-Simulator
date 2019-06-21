/**
   Name: Anthony Bou Khalil
*/
public class Vehicle 
{
	/**
	   PowerSources that can be used
	   GAS_ENGINE
	   DIESEL_ENGINE
	   ELECTRIC_MOTOR
	*/
	public static enum PowerSource
	{
		GAS_ENGINE, DIESEL_ENGINE, ELECTRIC_MOTOR;
	}
	
	//Declaring instance variables
	public PowerSource power;
	String manuf;
	String color;
	int    numWheels;
	private int VIN;
	
	/**
       A constructor that initializes transactionID to the empty string
    */
	public Vehicle()
	{
		this.manuf = "";
	}
	
	/**
       A constructor that initializes manuf, color, numWheels and power with given values
       @param manuf the given manuf, @param color the given color 
       @param numWheels the given numWheels, @param power the given power
    */
	public Vehicle(String manuf, String color, int numWheels, PowerSource power)
	{
	  this.manuf     = manuf;
	  this.color     = color;
	  this.numWheels = numWheels;
	  this.power     = power;
	  VIN = ((int) (Math.random()*(499 - 100))) + 100;
	}
	
    /**
       Accesses the VIN
       @return VIN
    */
	public int getVIN()
	{
		return VIN;
	}
	
	 /**
       Gives a String representation of the Car
       @return for GAS_ENGINE, "VIN: " + VIN + "mfr " + "color " + "price$ " + "SF: " + "safetyRating " + "RNG: " + "maxRange" 
       @return for ELECTRIC_MOTOR, "VIN: " + VIN + "mfr " + "color " + "price$ " + "SF: " + "safetyRating " + "RNG: " + "maxRange " + "batteryType " + "rechargeTime" 
    */
	public String display()
	{
		return "VIN: " + VIN + " " + manuf + " " + color;
	}
	
	 /**
       This method compare the this Car object and the other Car object for equality
       Car objects are equal if their mfr and power and numWheels are equal and if their model and AWD variables are equal
       @return true if Car objects are equal, @return false if Car objects are not equal
    */ 
	public boolean equals(Object other)
	{
		Vehicle otherV = (Vehicle) other;
		return power == otherV.power && manuf.equals(otherV.manuf) && numWheels == otherV.numWheels;
	}
}