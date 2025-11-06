# COP2251 – Java Final Project: Car Lot Inventory System

## Summary
This project implements a complete object-oriented car lot management system. It uses encapsulated classes, array-based collections, file input/output, and comparison methods to simulate a dealership’s inventory tracking, sales, and reporting. The program supports creating, modifying, saving, and analyzing vehicle data interactively through a console-based menu system.

## Program Behavior
- Car  
  - Defines vehicle attributes such as ID, mileage, miles-per-gallon (MPG), cost, sales price, sale status, and profit.  
  - Provides full constructors, getters, setters, and comparison methods (`compareMPG`, `compareMiles`, and `comparePrice`).  
  - The `sellCar(double priceSold)` method marks a car as sold, records the sale price, and calculates profit as `priceSold - cost`.  
  - Includes a `toString()` method for formatted object output.

- CarLot  
  - Maintains an `ArrayList<Car>` representing the inventory.  
  - Provides methods for adding and selling cars, calculating statistics (average MPG, total profit), and sorting cars by MPG or mileage.  
  - Includes `saveToDisk()` and `loadFromDisk()` methods to persist and restore inventory data from `carLotInventory.txt`.  
  - Uses modern `Comparator` logic and Java Streams for calculations like averages and totals.

- CarLotMain  
  - The primary console-driven interface with a text-based menu.  
  - Allows the user to:
    - Add new cars to inventory  
    - Sell cars and record profits  
    - Save or load the inventory from disk  
    - Display statistics such as highest MPG, highest mileage, average MPG, and total profit  
  - Handles user input validation and ensures data consistency.

- CarTester and CarLotTester  
  - Provide isolated tests for class behavior and data integrity.  
  - Verify constructors, setters/getters, sorting, comparison, and file persistence functionality.

## Key Concepts Demonstrated
- Object-Oriented Programming: Encapsulation, class design, constructors, method overloading, and polymorphism.  
- File I/O: Reading and writing structured data to disk with `BufferedWriter` and `FileReader`.  
- Collections: Using `ArrayList<Car>` to store and manipulate dynamic data.  
- Data Sorting and Aggregation: Implementing selection sort and Java `Comparator` for comparisons.  
- Stream API: Calculating averages and sums concisely.  
- Menu-Driven Control Flow: Interactive console interface with a persistent program loop.  
- Exception Handling: Try-catch blocks for I/O and user input validation.

## How to Compile and Run
Requirements:
- Java Development Kit (JDK) 17 or later  
- Command line terminal or IDE (IntelliJ IDEA, Eclipse, or VS Code)

Commands (from the `nazarioProject/src` directory):
javac -d ../out module-info.java nazarioProject/Car.java nazarioProject/CarLot.java nazarioProject/CarLotMain.java nazarioProject/CarLotTester.java nazarioProject/CarTester.java  
java -cp ../out nazarioProject.CarLotMain
