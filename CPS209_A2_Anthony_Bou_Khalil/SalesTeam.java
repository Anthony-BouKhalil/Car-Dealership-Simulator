/**
   Name: Anthony Bou Khalil
*/
//Used to make the members of these packages accessible for this application
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Random;

public class SalesTeam 
{
	//Declaring instance variable
	private LinkedList<String> list1;
	
	/**
       A constructor that initializes manuf, color, model, power, safety, range, awd, price and rechargeTime with given values
    */
	public SalesTeam()
	{
		LinkedList<String> list2 = new LinkedList<String>() ;
		list2.add("Ben");
		list2.add("Michael");
		list2.add("Mark");
		list2.add("Leslie");
		list2.add("Andrew");
		list2.add("Aryan");
		list1 = list2;
	}
	
	/**
       Gives a String representation of a random sales person
       @return either Ben or Michael or Mark or Leslie or Andrew or Aryan 
    */
	public String returnSalesPerson()
	{
		Random r = new Random();
		int low = 0;
		int high = 5;
		int randomNum = r.nextInt(high-low) + low;
		return list1.get(randomNum);
	}
	
	/**
       Gives a String representation of all the sales team
       @return Ben Michael Mark Leslie Andrew Aryan 
    */
	public String returnAllSalesPersons()
	{
		int i = 0;
		String result = "";
		ListIterator<String> litr = list1.listIterator();
	    while (litr.hasNext())
	    {
	    	i++;
	    	if (i == 1)
	    	{
	    		result = litr.next();
	    	}
	    	else
	    		result = result + " " + litr.next();
	    }
		return result;
	}
}