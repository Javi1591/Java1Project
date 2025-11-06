// Xavier Nazario
// Student ID# 2512208
// Program finishing stater code for 
// menu.

package nazarioProject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class CarLotMain {

	public static void main(String[] args) {

		Scanner input = new Scanner(System.in);
		CarLot carLot = new CarLot();
		String prompt = "[0] Exit \n" + "[1] Add a car to inventory \n" + "[2] Sell a car from inventory \n"
				+ "[3] Save to Disk \n" + "[4] Load From Disk \n" + "[5] List of inventory by order of acquisition \n"
				+ "[6] List Inventory From Best MPG to Worst MPG \n" + "[7] Display car with best MPG \n"
				+ "[8] Display car with the highest mileage \n" + "[9] Display overall MPG for the entire inventory \n"
				+ "[10] Display profit for all sold cars \n" + "Enter a number from 0 to 10: ";

		int option;

		do {
			System.out.println(prompt);
			option = input.nextInt();
			input.nextLine(); // Consume newline after integer input

			switch (option) {

			case 0: {
				System.out.println("Exiting... Thanks for visiting our car lot! Please come again!");
				break;
			}
			case 1: {
				System.out.println("Enter car ID: ");
				String id = input.nextLine();
				System.out.println("Enter mileage: ");
				int mileage = input.nextInt();
				System.out.println("Enter MPG: ");
				int mpg = input.nextInt();
				System.out.println("Enter cost: ");
				double cost = input.nextDouble();
				System.out.println("Enter sales price: ");
				double salesPrice = input.nextDouble();
				carLot.addCar(id, mileage, mpg, cost, salesPrice);
				System.out.println("Car added to inventory.");
				break;
			}
			case 2: {
				System.out.println("Enter car ID to sell: ");
				String id = input.nextLine();
				System.out.println("Enter sale price: ");
				double priceSold = input.nextDouble();
				carLot.sellCar(id, priceSold);
				System.out.println("Car sold.");
				break;
			}
			case 3: {
				try {
					carLot.saveToDisk();
					System.out.println("Inventory saved to disk.");
				} catch (IOException e) {
					System.out.println("Error saving to disk: " + e.getMessage());
				}
				break;
			}
			case 4: {
				try {
					carLot.loadFromDisk();
					System.out.println("Inventory loaded from disk.");
				} catch (IOException e) {
					System.out.println("Error loading from disk: " + e.getMessage());
				}
				break;
			}
			case 5: {
				ArrayList<Car> cars = carLot.getCarsInOrderOfEntry();
				System.out.println("List of inventory by order of acquisition:");
				for (Car car : cars) {
					System.out.println(car);
				}
				break;
			}
			case 6: {
				ArrayList<Car> cars = carLot.getCarsSortedByMPG();
				System.out.println("List of inventory from best MPG to worst MPG:");
				for (Car car : cars) {
					System.out.println(car);
				}
				break;
			}
			case 7: {
				Car bestMPGCar = carLot.getCarWithBestMPG();
				System.out.println("Car with best MPG: " + bestMPGCar);
				break;
			}
			case 8: {
				Car highestMileageCar = carLot.getCarWithHighestMileage();
				System.out.println("Car with the highest mileage: " + highestMileageCar);
				break;
			}
			case 9: {
				double averageMPG = carLot.getAverageMpg();
				System.out.println("Overall MPG for the entire inventory: " + averageMPG);
				break;
			}
			case 10: {
				double totalProfit = carLot.getTotalProfit();
				System.out.println("Total profit for all sold cars: " + totalProfit);
				break;
			}
			case 11: {
				break; // Continue loop to show main menu again
			}
			default: {
				System.out.println("Invalid option. Please try again.");
				break;
			}
			}

		} while (option != 0);

		input.close();
	}
}