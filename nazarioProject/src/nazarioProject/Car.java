// Xavier Nazario
// Student ID# 2512208
// Program for Car class.

package nazarioProject;

public class Car {

	// Fields
	// Use private
	// Integer, double, boolean
	private String id = "";
	private int mileage = 0;
	private int mpg = 0;
	private double cost = 0.0;
	private double salesPrice = 0.0;
	private boolean isSold = false;
	private double priceSold = 0.0;
	private double profit = 0.0;

	// Constructors
	public Car() {
		// Default constructor
	}

	public Car(String id, int mileage, int mpg, double cost, double salesPrice) {
		this.id = id;
		this.mileage = mileage;
		this.mpg = mpg;
		this.cost = cost;
		this.salesPrice = salesPrice;
		this.isSold = false;
		this.priceSold = 0;
		this.profit = 0;
	}

	// Getters
	public String getID() {
		return id;
	}

	public int getMileage() {
		return mileage;
	}

	public int getMPG() {
		return mpg;
	}

	public double getCost() {
		return cost;
	}

	public double getSalesPrice() {
		return salesPrice;
	}

	public double getPriceSold() {
		return priceSold;
	}

	public boolean getIsSold() {
		return isSold;
	}

	public double getProfit() {
		return profit;
	}

	// Setters
	public void setID(String id) {
		this.id = id;
	}

	public void setMileage(int mileage) {
		this.mileage = mileage;
	}

	public void setMPG(int mpg) {
		this.mpg = mpg;
	}

	public void setCost(double cost) {
		this.cost = cost;
	}

	public void setSalesPrice(double salesPrice) {
		this.salesPrice = salesPrice;
	}

	public void sellCar(double priceSold) {
		this.priceSold = priceSold;
		this.isSold = true;
		this.profit = priceSold - this.cost;
	}

	// Comparison Methods
	public int compareMPG(Car otherCar) {
		return Integer.compare(this.mpg, otherCar.getMPG());
	}

	public int compareMiles(Car otherCar) {
		return Integer.compare(this.mileage, otherCar.getMileage());
	}

	public int comparePrice(Car otherCar) {
		return Double.compare(this.salesPrice, otherCar.getSalesPrice());
	}

	// toString method
	@Override
	public String toString() {
		return "Car ID: " + id + "\nMileage: " + mileage + "\nMPG: " + mpg + "\nCost: " + cost + "\nSales Price: "
				+ salesPrice + "\nSold: " + (isSold ? "Yes" : "No") + "\nPrice Sold: " + priceSold + "\nProfit: "
				+ profit;
	}
}
