/**
   Name: Anthony Bou Khalil
*/
public class ElectricCar extends Car
{
	  //Declaring instance variables
	  int    rechargeTime;//minutes
	  String batteryType;
	  
	  /**
	     A constructor that initializes manuf, color, model, power, safety, range, awd, price and rechargeTime with given values
         @param manuf the given manuf, @param color the given color
         @param model the given model, @param power the given power 
         @param safety the given safety, @param range the given range
         @param awd the given awd, @param price the given price
         @param rch the given rechargeTime
	  */
	  public ElectricCar(String manuf, String color, Model model, Vehicle.PowerSource power, 
			     double safety, int range, boolean awd, double price, int rch)
	  {
		  super(manuf, color, model, Vehicle.PowerSource.ELECTRIC_MOTOR, safety, range, awd, price);
		  rechargeTime = rch;
		  batteryType = "Lithium";
	  }
	  
	  /**
         Sets the rechargeTime
         @param time the rechargeTime
      */  
	  public void setRechargeTime(int time)
	  {
		  rechargeTime = time;
	  }
	  
	  /**
         Sets the batteryType
         @param type the batteryType
      */ 
	  public void batteryType(String type)
	  {
		  batteryType = type;
	  }
	  
      /**
         Gives a String representation of the Car
         @return for GAS_ENGINE, "VIN: " + VIN + "mfr " + "color " + "price$ " + "SF: " + "safetyRating " + "RNG: " + "maxRange" 
         @return for ELECTRIC_MOTOR, "VIN: " + VIN + "mfr " + "color " + "price$ " + "SF: " + "safetyRating " + "RNG: " + "maxRange " + "batteryType " + "rechargeTime " 
      */
	  public String display()
	  {
		  return super.display() + " " + "EL, BAT: " + batteryType + " RCH: " + rechargeTime;
	  }
}