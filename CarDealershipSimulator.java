import java.util.*;
import java.io.File;
import java.io.FileNotFoundException;
/**
 * @author Parth Patel(#500893723)
 * This class has the main method where all the objects are made
 * this class uses all the other classes to simulate the CarDealership
 *
 */
public class CarDealershipSimulator
{
	public static ArrayList<Car> readFile() {
        //Empty ArrayList created to save car objects
		ArrayList<Car> carsList = new ArrayList<Car>();
		//Initialized a scanner object
        Scanner scanner = null;
        
        //throws the exception if file not found
        try
        {
            scanner = new Scanner(new File("cars.txt"));
        } 
        
        catch(FileNotFoundException e) 
        {
           System.out.println("File not found exception thrown");
        }
        //this loop reads each line in the file until next line
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            ArrayList<String> myList = new ArrayList<String>(Arrays.asList(line.split(",")));

            //This condition checks if the car is ElectricCar type by checking the number of parameters 
            //because ElectricCar object constructor has 11 parameters
            if(myList.size() == 11)
            {
            	//if the size of line is 11 then it would make an object of ElectricCar
            	ElectricCar electricCar = new ElectricCar(myList.get(0),myList.get(1),
            			Integer.parseInt(myList.get(2)),Integer.parseInt(myList.get(3)),Integer.parseInt(myList.get(4)),
            			Integer.parseInt(myList.get(5)),Double.parseDouble(myList.get(6)),Boolean.parseBoolean(myList.get(7)),
            			Double.parseDouble(myList.get(8)),Integer.parseInt(myList.get(9)),myList.get(10));
                carsList.add(electricCar);

            }
            else
            {
            	//else it would automatically consider it as a Car type and make a Car object
                Car engineCar = new Car(myList.get(0),myList.get(1),Integer.parseInt(myList.get(2)),
                		Integer.parseInt(myList.get(3)),Integer.parseInt(myList.get(4)),Integer.parseInt(myList.get(5)),
                		Double.parseDouble(myList.get(6)),Boolean.parseBoolean(myList.get(7)),Double.parseDouble(myList.get(8)));
                carsList.add(engineCar);
            }
        }
        return carsList;
    }
	
	
	
	
	public static void main(String[] args)
	{
	  //carDealershipObj is the object created(type ArrayList) to store all the cars 
	  CarDealership carDealershipObj = new CarDealership();
	  
	  // carsList is created to initially save the car objects
	  ArrayList<Car> carsList = readFile();
	  
//	  ArrayList<Car> carsList = new ArrayList<Car>();
//Uncomment the above line if the file I/O doesn't work.. thanks!!	  
	  
	  Car lastObjectBought = null;
	  	//These objects have been commented out in case the I/O file exception doesn't work
	  	//if the file I/O exception doesn't work please uncomment these and run the code thanks!!
	  	//Creating all the objects type Car and ElectricCar
  	
	  

//	  	Car c1 = new Car("Toyota", "blue", 0, 4, 1, 500, 9.5, false, 25000);
//		Car c2 = new Car("Honda", "red", 0, 4,3, 450, 9.2, false, 30000);
//		Car c3 = new Car("Kia", "white", 0, 4,4, 550, 9.7, false, 20000);
//		Car c4 = new Car("BMW", "black", 0, 4, 1, 600, 9.6, true, 55000);
//		Car c6 = new Car("Chevy", "red", 0, 4, 3, 475, 9.25, false, 40000);
//		Car c8 = new Car("Bentley","black", 0, 4, 1, 575, 9.8, false, 150000);
//		ElectricCar c5 = new ElectricCar("Tesla", "red", 1,4, 1, 425, 9.1, true, 85000, 30, "LITHIUM");		
//		ElectricCar c7 = new ElectricCar("ChevyVolt", "green", 1, 4, 1, 375, 8.9, true, 37000, 45, "LITHIUM");		
//		ElectricCar c9 = new ElectricCar("NissanLeaf","green", 1, 4, 1, 325, 8.8, true, 32000, 55, "LITHIUM");
//		
//		//Adding all the objects to the ArrayList carsList using the add() method
//		carsList.add(c1);
//		carsList.add(c2);
//		carsList.add(c3);
//		carsList.add(c4);
//		carsList.add(c5);
//		carsList.add(c6);
//		carsList.add(c7);
//		carsList.add(c8);
//		carsList.add(c9);
	 
	//scanner object that takes the input in the console area	
	Scanner scanner = new Scanner(System.in);
	
	//checks the command entered input  
	while(scanner.hasNext()) 
	 {
		// 
		String string = scanner.nextLine();				
				//checks if the input is "L" if yes it will call the method displayInventory() from the CarDealership class
				if (string.equals("L")) 
				{
					if(carDealershipObj.listSize() == 0) 
					{
						System.out.println("The list is empty please use ADD command to add the cars to the list");
					}
					else
						carDealershipObj.displayInventory();
				
				}
				//checks if the input is "Q" if yes it will quit the program
				else if (string.equals("Q")) 
				{
					scanner.close();
					return;
				}
				
				//checks if the input is "BUY" followed by an int type value that is the index of the car objects in the ArrayList
				//and would call the method buyCar() from the CarDealership class and remove the car from that index specified
				else if (string.contains("BUY")) 
				{ 								
					try 
					{
						String s = string;
						ArrayList<String> listA = new ArrayList<String>(Arrays.asList(s.split("\\s+")));
						int newIndex = Integer.parseInt(listA.get(1));
						if(newIndex >=0 && newIndex < carDealershipObj.listSize()) 
						{
							lastObjectBought = carDealershipObj.buyCar(newIndex);						
						}
						else
							System.out.println("Value entered is out of index");
					}
					
					catch(Exception e) 
					{
						System.out.println("Please enter an index number of the car after the command \nBUY *index number from the list of cars*");
						System.out.println(e);
					}
					
				}
				//checks if the input is "RET" it would return the car by calling the returnCar() method from the CarDealership class
				//if no car was bought it would print an error 
				else if (string.equals("RET")) 
				{ 
					 if (lastObjectBought != null){
		                    carDealershipObj.returnCar(lastObjectBought);
		                    lastObjectBought = null;
		                }
		                else{
		                    System.out.println("NO CAR IS BOUGHT YET");
		                }
				}
				
				//checks if the input is "ADD" it would add the list of car objcts to the carDealershipObj 
				//by calling the addCars method from the CarDealership class
				else if (string.equals("ADD")) 
				{ 
					if(carDealershipObj.listSize() == 0) 
					{
						carDealershipObj.addCars(carsList);
					}
					else
						{;}
				}
				
				//checks if the input is "SPR" and then calls sortByPrice() method from CarDealership Class
				else if (string.equals("SPR")) 
				{
					carDealershipObj.sortByPrice();
				}
				
				//checks if the input is "SSR" and the calls sortBySafetyRating() method from CarDealership Class
				else if (string.equals("SSR")) 
				{
					carDealershipObj.sortBySafetyRating();
				}
				
				//checks if the input is "SMR" and the calls sortByMaxRange() method from CarDealership Class
				else if (string.equals("SMR")) 
				{
					carDealershipObj.sortByMaxRange();
				}
				
				//checks if the input is "FPR" and the calls priceFilter() method from CarDealership Class after checking if the values are in range 
				//if not it would display an error message by using Exception Class
				else if (string.contains("FPR")) 
				{ 																	
					try 
					{
						
						String s = string;
						ArrayList<String> listA = new ArrayList<String>(Arrays.asList(s.split("\\s+")));
					
						double minimum = Double.parseDouble(listA.get(1));
						double maximum = Double.parseDouble(listA.get(2));
						if(maximum >= minimum)
							carDealershipObj.priceFilter(minimum, maximum);
						else
							System.out.println("Price range invalid!!\nminimum price should be less than maximum price!!\nPlease try again..");
					}
					catch(Exception e) 
					{
						System.out.println("Please enter the price range for the command FPR to filter out the cars in that particular price range");
						System.out.println("Exception: " + e);
					}
					
				}
				
				//checks if the input is "FEL" and the calls electricCarFilter() method from CarDealership Class
				else if (string.equals("FEL")) 
				{ 
					carDealershipObj.electricCarFilter();
				}
				
				//checks if the input is "FAW" and the calls AWDFilter() method from CarDealership Class
				else if (string.equals("FAW")) 
				{ 
					carDealershipObj.AWDFilter();
				}
				
				//checks if the input is "FCL" and the calls filtersClear() method from CarDealership Class
				else if (string.equals("FCL"))
				{ 
					carDealershipObj.filtersClear();
				}
				
				//if the input doesn't match any of the above commands it would print the error message about the invalid input
				else 
				{
					System.out.println("PLEASE MAKE A VALID INPUT");
				}					
	 
	 }
	scanner.close();
  }
}