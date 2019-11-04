
/**
 * @author Parth Patel #500893723
 * Car class inherits Vehicle class
 * 
 */
class Car extends Vehicle implements Comparable<Object>
{
	private int model; 
	private int maxRange;
	private double safetyRating;
	private boolean AWD;
	private double price;
	public static final int SEDAN = 1;
	public static final int SUV = 2;
	public static final int SPORTS = 3;
	public static final int MINIVAN = 4;
	
	
	/**
	 * @param mfr is the manufacturer name (Inherited from the Vehicle class)
	 * @param color is the Color of car (Inherited from the Vehicle class)
	 * @param power is the power source of the car (Inherited from the Vehicle class)
	 * @param numWheels is the number of wheels (Inherited from the Vehicle class)
	 * @param model is the model type
	 * @param maxRange is the maximum range of the car
	 * @param safetyRating is the safety rating of a car
	 * @param AWD is the boolean type instance variable for All-wheel drive type cars
	 * 		  if it is set "true" it means the car is AWD if "false" then car is 2WD
	 * @param price is  the price of the Car
	 */
	public Car(String mfr, String color, int power, int numWheels, int model, 
			int maxRange, double safetyRating, boolean AWD, double price) 
	{
		super(mfr, color, power, numWheels);
		this.model = model;
		
		this.maxRange = maxRange;
		this.safetyRating = safetyRating;
		this.AWD = AWD;
		this.price = price;		
	}
	
	
	/**
	 * @return AWD 
	 * this method returns true or false based on the input for the AWD input in the constructor
	 */
	public boolean getAWD() //this method returns the value of the instance variable AWD
	{
		return AWD;
	}
	
	
	/**
	 * @return string containing the type of model 
	 * this method is made specially for the display method since it takes
	 * an input from the constructor and returns the model type
	 */
	public String getModelType()
	{
		
		if(model == 1)
			return "SEDAN";
		else if(model == 2)
			return "SUV";
		else if(model == 3)
			return "SPORTS";
		else if(model == 4)
			return "MINIVAN";
		else
			return null;			
	}
	
	
	/**
	 * @return model
	 * returns the model type in the form of integer
	 */
	public int getModel() 
	{
		return model;
	}
	
	
	/**
	 * @param model1 sets the instance variable model to the parameter passed and 
	 * it checks whether the input is within the valid range
	 */
	public void setModel(int model1)
	{
		if(model1 > 0 && model1 <=4) 
			model = model1;		
		else
			System.out.println("Invalid model type input please enter a value from 1-4");
	}
	
	
	/**
	 * @return maxRange
	 * returns the variable maxRange
	 */
	public int getMaxRange()
	{
		return maxRange;
	}
	
	
	/**
	 * @param maxRange1
	 * this method sets the instance variable maxRange to the parameter passed 
	 */
	public void setMaxRange(int maxRange1)
	{
		maxRange = maxRange1;
	}
	
	
	/**
	 * @return safetyRating
	 * returns a double type value assigned to the instance variable safetyRating
	 */
	public double getSafetyRating()
	{
		return safetyRating;
	}
	
	
	/**
	 * @param safetyRating1
	 * sets the variable safetyRating to the value passed to the method as a parameter
	 */
	public void setSafetyRating(double safetyRating1) 
	{
		safetyRating = safetyRating1;
	}
	
	
	/**
	 * @return price
	 * returns the price of a Car
	 */
	public double getPrice() //returns the price of the car 
	{
		return price;
	}
	
	
	/**
	 * @param price1
	 * Sets the price of a Car to the parameter value passed to the method
	 */
	public void setPrice(double price1)
	{
		price = price1;
	}	
	
	
	/**
	 * @return String 
	 * This method is made specially for the display method 
	 * so that it returns a string when depending on the boolean passed
	 * for the variable AWD. So, if it is "true" it will return a string "AWD",
	 * if "false" it will return "2WD".
	 */
	public String getWheelsType()
	{
		boolean b = getAWD();
		if(b == true)
			return "AWD";
		else
			return "2WD";		
	}
	
	
	/** 
	 * @return boolean
	 * This method overrides the equals method from Vehicle class
	 * it checks if two objects are equal based on the the following attributes
	 * Model type(model), All-Wheel Drive(AWD), Manufacturer name(mfr),
	 * Type of engine/power source(power) and Number of wheels(numWheels).
	 * And it returns a boolean value after checking all the conditions 
	 */
	@Override
	public boolean equals(Object other) 
	{
		Car otherO = (Car)other;
		if(super.equals(otherO) && 
		  ((this.model) == otherO.getModel()) && 
		  (this.AWD == otherO.AWD))
			return true;
		else
			return false;		
	}
	
	
	/**
	 * This method overrides the display() method from the Vehicle class
	 * @returns a string containing all the information needed to identify the Car
	 * that is, all the attributes to differentiate between Car objects
	 * 
	 */
	@Override
	public String display() 
	{
		return super.display() +"  " +"Model: "+ getModelType() +"  "+ getEngineType() + "  " +
	"SF: "+ getSafetyRating() + "  " + "RNG: " + getMaxRange() + "  " +
				getWheelsType() +"  "+"Price: $"+ getPrice();
	}
	
	
	/**
	 * This method overrides the abstract method compareTo 
	 * from the interface Comparable it compares the price of the cars
	 * and returns an integer upon the conditions specified
	 * 
	 */
	public int compareTo(Object other) 
	{
		Car other1 = (Car)other;
		if(this.price > other1.price)
			return 1;
		else if(this.price < other1.price)
			return -1;
		else
			return 0;
		
	}
	
}



















