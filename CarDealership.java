/**
 * @author Parth Patel(#500893723)
 * CarDealership class this class has methods that will be used in CarDealershipSimulator
 *
 */
import java.util.*;
public class CarDealership 
{	
	private boolean AWDFilter; 
	private boolean electricCarFilter;
	private boolean priceFilter;
	private ArrayList<Car> cars;
	private double maxPrice;
	private double minPrice;
		
	
	/**
	 * this constructor method initializes the variable type ArrayList cars
	 */
	public CarDealership() 
	{
		cars = new ArrayList<Car>();		
	}
	
	
	/**
	 * @return cars
	 * returns the ArrayList cars
	 */
	public ArrayList<Car> getCars() 
	{
		return cars;
	}
	
	
	/**
	 * @param newCars
	 * takes the parameter newCars type ArrayList and adds the list of car objects to the ArrayList cars
	 */
	public void addCars(ArrayList<Car> newCars) 
	{
		for(Car a: newCars) 
		{
		cars.add(a);
		}
	}
	
	
	/**
	 * @return i
	 * returns the size of an ArrayList 
	 */
	public int listSize() 
	{
		int i = getCars().size();
		return i;				
	}
	
	
	/**
	 * @param index
	 * @return tempCar
	 * this method takes an integer as a parameter and removes the car object at the specified index and returns the object,
	 * and if the index is out of the range of ArrayList index it returns null
	 */
	public Car buyCar(int index)
	{
	try{
		if(index >= 0 && index < cars.size())
		{		
			Car tempCar = cars.get(index);
			cars.remove(index);
			return tempCar;
		}
		else
			return null;
	}
	catch(Exception e) {
		System.out.println(e);
		return null;
	}
	
}

	
	/**
	 * @param returncar 
	 * this method adds the removed car back to the ArrayList of cars 
	 */
	public void returnCar(Car returncar) 
	{
		if(returncar != null)
			cars.add(returncar);
	}
	
		
	/**
	 * @return AWDFilter
	 * this method returns the private variable AWDFilter
	 */
	public boolean isAWDFilter() 
	{
		return AWDFilter;
	}	


	/**
	 * @return electricCarFilter
	 * this method returns the private variable electricCarFilter
	 */
	public boolean isElectricCarFilter() {
		return electricCarFilter;
	}


	/**
	 * @return priceFilter
	 * this method returns the private variable priceFilter
	 */
	public boolean isPriceFilter() {
		return priceFilter;
	}


	

/**
 * this method checks which one of the filters are on, that is "true" 
 * and prints the information about the objects accordingly
 */
public void displayInventory() {
	for(int x = 0; x < cars.size(); x++){
		//Checks if electric car filter and AWD filter is on 
        if(isElectricCarFilter() == true && isAWDFilter() == true)
        {
            //if te above filters are on, then it checks if the price filter is on
        	if (isPriceFilter() == true)
            {
                if(cars.get(x).getPower() == 1 && cars.get(x).getPrice() > minPrice && cars.get(x).getPrice() < maxPrice && cars.get(x).getAWD() == true)
                {
                    System.out.println(x + " " + cars.get(x).display());
                }
                else{;}
            }
        	//if the price filter is off it jumps to this block
            else{
                if(cars.get(x).getPower() == 1 && cars.get(x).getAWD() == true)
                {
                    System.out.println(x + " " + cars.get(x).display());
                }
                else{;}

            }

        }
        //checks of the electric car filter is on and AWD filter is off
        else if (isElectricCarFilter() == true && isAWDFilter() == false)
        {
            //if the above condition is satisfied then it executes the following block only if the price filter is on
        	if (isPriceFilter() == true)
            {
                if(cars.get(x).getPower() == 1 && cars.get(x).getPrice() >= minPrice && cars.get(x).getPrice() <= maxPrice)
                {
                    System.out.println(x + " " + cars.get(x).display());
                }
                else{;}
            }
            //if price filter is off the program would jump to this block of code and execute it
        	else
            {
                if(cars.get(x).getPower() == 1)
                {
                    System.out.println(x + " " + cars.get(x).display());
                }
                else{;}

            }
        }
      //checks of the electric car filter is off and AWD filter is on
        else if (isElectricCarFilter() == false && isAWDFilter() == true)
        {
        	//if the above condition is satisfied then it executes the following block only if the price filter is on
        	if (isPriceFilter() == true)
            {
                if(cars.get(x).getPrice() >= minPrice && cars.get(x).getPrice() <= maxPrice && cars.get(x).getAWD() == true)
                {
                    System.out.println(x + " " + cars.get(x).display());
                }
                else{;}
            }
        	//if price filter is off the program would jump to this block of code and execute it
            else {
                if(cars.get(x).getAWD() == true)
                {
                    System.out.println(x + " " + cars.get(x).display());
                }
                else{;}
            }

        }
      //checks of the electric car filter is off and AWD filter is off
        else if (isElectricCarFilter() == false && isAWDFilter() == false)
        {
        	//if the above condition is satisfied then it executes the following block only if the price filter is on
        	if (isPriceFilter() == true)
            {
                if(cars.get(x).getPrice() >= minPrice && cars.get(x).getPrice() <= maxPrice)
                {
                    System.out.println(x + " " + cars.get(x).display());
                }
                else{;}
            }
        	//if price filter is off the program would jump to this block of code and execute it
            else
            {
                System.out.println(x + " " + cars.get(x).display());
            }
        }
	}
}

	
	
	
	/**
	 * This is an inner class made to implement the interface Comparator
	 * to compare two objects based on the maxRange attribute
	 *
	 */
	class maxRangeSort implements Comparator<Object>
	{
		
	
		/** 
		 * @param1 Object o1 is the first object
		 * @param2 Object o2 is the second object
		 * this method overrides the abstract method from the Comparator interface
		 * it takes two objects as parameters and casts them into Car objects
		 * compares them with respect to the attribute maxRange and returns an integer according to the condition
		 * 
		 */
		public int compare(Object o1, Object o2) 
		{
			Car o3 = (Car) o1;
			Car o4 = (Car) o2;
			
			if(o4.getMaxRange() < o3.getMaxRange())
				return 1;
			else if(o4.getMaxRange() > o3.getMaxRange())
				return -1;
			else
				return 0;
		}
	}
		
	
	/**
	 * this is an inner class to implement the Comparator interface 
	 * to compare two objects based on safetyRating attribute
	 *
	 */
	class safetyRatingSort implements Comparator<Object>
	{
		
		/** 
		 * @param1 Object o1 is the first object
		 * @param2 Object o2 is the second object
		 * this method overrides the abstract method from the Comparator interface
		 * it takes two objects as parameters and casts them into Car objects
		 * compares them with respect to the attribute safetyRating and returns an integer according to the condition
		 */
		public int compare(Object o1, Object o2) 
		{
			Car o3 = (Car) o1;
			Car o4 = (Car) o2;
			
			if(o4.getSafetyRating() < o3.getSafetyRating())
				return 1;
			else if(o4.getSafetyRating() > o3.getSafetyRating())
				return -1;
			else
				return 0;
		}
	}	
	
	
	
	/**
	 * this method turns on the electricCarFilter on that is it assigns boolean true to the variable electricCarFilter
	 */
	public void electricCarFilter() 
	{
		this.electricCarFilter = true;	
	}
	
	
	/**
	 * this method turns on the AWDFilter on that is it assigns boolean true to the variable AWDFilter
	 */
	public void AWDFilter() 
	{
		this.AWDFilter = true;
	}
	
	
	/**
	 * @param minPrice1
	 * @param maxPrice1 
	 * this method turns on the priceFilter on that is it assigns boolean true to the variable priceFilter and assigns 
	 * the value passed as parameters to the minPrice and maxPrice variables 
	 */
	public void priceFilter(double minPrice1, double maxPrice1) 
	{
		this.maxPrice = maxPrice1;
		this.minPrice = minPrice1;
		this.priceFilter = true;
	}
	
	
	/**
	 * this method turns off all the filters that is it assigns boolean false
	 * to AWDFilter, electricCarFilter and priceFilter instance variables
	 * also makes the variables maxPrice and minPrice 0
	 */
	public void filtersClear() 
	{
		this.AWDFilter = false;
		this.electricCarFilter = false;
		this.priceFilter= false;
		this.maxPrice = 0;
		this.minPrice = 0;
	}
	
	
	/**
	 * this method calls the framework collections and sort the cars according in ascending order 
	 * with respect to their prices
	 */
	public void sortByPrice() 
	{
		Collections.sort(cars);
	}
	
	
	/**
	 * this method calls the framework collections and sort the cars according in ascending order 
	 * with respect to their safetyRating
	 */
	public void sortBySafetyRating() 
	 {
		Collections.sort(cars ,new safetyRatingSort()); 
	 }
 
	
	/**
	 * this method calls the framework collections and sort the cars according in ascending order 
	 * with respect to their maxRange 
	 */
	public void sortByMaxRange() 
	  { 
		Collections.sort(cars, new maxRangeSort());	  
	  }
	  



}
