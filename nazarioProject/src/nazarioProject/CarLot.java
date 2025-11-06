// Xavier Nazario
// Student ID# 2512208
// Program for CarLot class.

package nazarioProject;

import java.io.*;
import java.util.ArrayList;
import java.util.Comparator;

public class CarLot {
	private ArrayList<Car> inventory = new ArrayList<>();

	public ArrayList<Car> getInventory() {
		return inventory;
	}

	public void setInventory(ArrayList<Car> inventory) {
		this.inventory = inventory;
	}

	public Car findCarByIdentifier(String identifier) {
		for (Car car : inventory) {
			if (car.getID().equals(identifier)) {
				return car;
			}
		}
		return null;
	}

	public ArrayList<Car> getCarsInOrderOfEntry() {
		return new ArrayList<>(inventory);
	}

	public ArrayList<Car> getCarsSortedByMPG() {
		ArrayList<Car> sortedCars = new ArrayList<>(inventory);
		sortedCars.sort(Comparator.comparingInt(Car::getMPG));
		return sortedCars;
	}

	public void selectionSort(ArrayList<Car> sortedByMPG) {
		sortedByMPG.sort(Comparator.comparingInt(Car::getMPG));
	}

	public Car getCarWithBestMPG() {
		return inventory.stream().max(Comparator.comparingInt(Car::getMPG)).orElse(null);
	}

	public Car getCarWithHighestMileage() {
		return inventory.stream().max(Comparator.comparingInt(Car::getMileage)).orElse(null);
	}

	public double getAverageMpg() {
		return inventory.stream().mapToInt(Car::getMPG).average().orElse(0);
	}

	public double getTotalProfit() {
		return inventory.stream().filter(Car::getIsSold).mapToDouble(Car::getProfit).sum();
	}

	public void addCar(String id, int mileage, int mpg, double cost, double salesPrice) {
		inventory.add(new Car(id, mileage, mpg, cost, salesPrice));
	}

	public void sellCar(String identifier, double priceSold) {
		Car car = findCarByIdentifier(identifier);
		if (car != null) {
			car.sellCar(priceSold);
		} else {
			System.out.println("Car with identifier " + identifier + " not found.");
		}
	}

	public void saveToDisk() throws IOException {
		try (BufferedWriter writer = new BufferedWriter(new FileWriter("carLotInventory.txt"))) {
			for (Car car : inventory) {
				writer.write(car.getID() + "," + car.getMileage() + "," + car.getMPG() + "," + car.getCost() + ","
						+ car.getSalesPrice() + "," + car.getIsSold() + "," + car.getPriceSold() + ","
						+ car.getProfit());
				writer.newLine();
			}
		}
	}

	public void loadFromDisk() throws IOException {
		try (BufferedReader reader = new BufferedReader(new FileReader("carLotInventory.txt"))) {
			String line;
			inventory.clear();
			while ((line = reader.readLine()) != null) {
				String[] parts = line.split(",");
				if (parts.length == 8) {
					String id = parts[0];
					int mileage = Integer.parseInt(parts[1]);
					int mpg = Integer.parseInt(parts[2]);
					double cost = Double.parseDouble(parts[3]);
					double salesPrice = Double.parseDouble(parts[4]);
					boolean isSold = Boolean.parseBoolean(parts[5]);
					double priceSold = Double.parseDouble(parts[6]);
					double profit = Double.parseDouble(parts[7]);

					Car car = new Car(id, mileage, mpg, cost, salesPrice);
					if (isSold) {
						car.sellCar(priceSold);
					}
					inventory.add(car);
				}
			}
		}
	}
}
