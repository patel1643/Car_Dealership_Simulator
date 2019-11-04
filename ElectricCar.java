
/**
 * @author Parth Patel #500893723
 * ElectricCar class inherits everything from Car
 *
 */
public class ElectricCar extends Car {
	private int rechargeTime;
	private String batteryType;
	
	/**
	 * @param mfr is the manufacturer name (Inherited from the Vehicle class)
	 * @param color is the Color of car (Inherited from the Vehicle class)
	 * @param power is the power source of the car (Inherited from the Vehicle class)
	 * @param numWheels is the number of wheels (Inherited from the Vehicle class)
	 * @param model is the model type
	 * @param maxRange
	 * @param safetyRating
	 * @param AWD
	 * @param price
	 * @param rechargeTime
	 * @param batteryType
	 */
	public ElectricCar(String mfr, String color, int power, int numWheels, int model,
						int maxRange, double safetyRating, boolean AWD, double price, int rechargeTime, String batteryType) 
	{
		super(mfr, color, power, numWheels,model, maxRange, safetyRating, AWD, price);
		this.rechargeTime = rechargeTime;
		this.batteryType = batteryType;
	}
	
	
	/**
	 * @return rechargeTime 
	 * this method returns the recharge time for the car
	 */
	public int getRechargeTime() 
	{	
		return rechargeTime;
	}
	

	/**
	 * @param rechargeTime1
	 * this method sets the recharge time for the variable rechargeTime to the parameter passed
	 */
	public void setRechargeTime(int rechargeTime1) 
	{
		rechargeTime = rechargeTime1;
	}
	

	/**
	 * @return batteryType
	 * returns a string containing the type of the battery the car has
	 */
	public String getBatteryType() 
	{
		return batteryType;
	}
	

	/**
	 * 
	 * @param batteryType1
	 * sets the variable batteryType to the stirng parameter passed to the method
	 */
	public void setBatteryType(String batteryType1) 
	{
		batteryType = batteryType1;
	}
	
	
	/**
	 * @return String
	 * this method overrides the method display() in the Car class and adds the extra attributes to the string
	 * that an Electric Car would have
	 */
	@Override
	public String display() 
	{
		return super.display() +  " " + "BAT: " + getBatteryType() + "  "+ "RCH: "+ getRechargeTime();
	}
}
