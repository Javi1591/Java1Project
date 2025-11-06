package nazarioProject;


import java.util.ArrayList;
import java.io.IOException;

public class CarLotTester {

	public static void main(String[] args) {

		// create two car instances with all fields
		Car car1 = new Car("2010 Kia Soul", 12005, 12, 12000.00, 13000.00);
		Car car2 = new Car("2012 Ford Focus", 25032, 28, 12500.00, 13000.00);
		// test the empty constructor and the setters
		Car car3 = new Car();
		car3.setID("2013 Chevrolet Camaro");
		car3.setMPG(30);
		car3.setMileage(25000);
		car3.setCost(10000);
		car3.setSalesPrice(11000);

		// create arraylist to add cars
		ArrayList<Car> addCars = new ArrayList<>();
		addCars.add(car1);
		addCars.add(car2);
		addCars.add(car3);

		// create carlot instance and add the arraylist to the inventory variable
		CarLot carLotOne = new CarLot();

		// test setInventory function;
		carLotOne.setInventory(addCars);

		// test add car function;
		carLotOne.addCar("2011 Acura TL", 16000, 24, 7800, 9000);

		// test saveToDisk function;
		try {
			carLotOne.saveToDisk();
		} catch (IOException e) {
			System.out.println(e.getStackTrace());
		}

		// test loadToDisk function
		try {
			carLotOne.loadFromDisk();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		System.out.println();
		System.out.println("1. Cars in order of entry: " + carLotOne.getCarsInOrderOfEntry());
		System.out.println("2. Sort cars by MPG lowest to highest: " + carLotOne.getCarsSortedByMPG());
		System.out.println("3. Car with best MPG is: " + carLotOne.getCarWithBestMPG());
		System.out.println("4. Car with highest mileage is: " + carLotOne.getCarWithHighestMileage());
		System.out.println("5. Average MPG of the cars in the car lot: " + carLotOne.getAverageMpg());

		// test sell car function;
		carLotOne.sellCar("2011 Acura TL", 10000);
		System.out.println("Total profit from cars sold in the car lot: " + carLotOne.getTotalProfit());

		// test the error thrown when a car with a wrong identifier is sold
		carLotOne.sellCar("Random car", 15000);
	}

}